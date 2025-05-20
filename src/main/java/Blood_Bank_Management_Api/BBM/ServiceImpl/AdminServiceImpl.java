package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.AdminResponse;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.AdminService;
import Blood_Bank_Management_Api.BBM.entity.Admin;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.enums.AdminType;
import Blood_Bank_Management_Api.BBM.enums.Role;
import Blood_Bank_Management_Api.BBM.repository.AdminRepositry;
import Blood_Bank_Management_Api.BBM.repository.HospitalRepository;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final AdminRepositry adminRepositry;


@Override
    public AdminResponse promoteUserToAdmin(int userId){

    User existUser = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundExceptionById("user not found"));
Admin admin=Admin.builder()
                .adminType(AdminType.OWNER)
                        .build();
Admin savedAdmin=adminRepositry.save(admin);
existUser.setRole(Role.ADMIN);
existUser.setAdmin(savedAdmin);
savedAdmin.setUser(existUser);
userRepository.save(existUser);

    return AdminResponse.builder()
            .adminId(savedAdmin.getAdminId())
            .user(existUser)
    .build();


}


}
