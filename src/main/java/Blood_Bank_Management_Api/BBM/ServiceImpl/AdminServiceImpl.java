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

    private  User mapUserRequestToUser(UserRequest userRequest, User user) {
        user.setUserName(userRequest.getUserName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setBloodGroup(userRequest.getBloodGroup());
        user.setAge(userRequest.getAge());
        user.setAvailableCity(userRequest.getAvailableCity());
        user.setLastDonatedAt(userRequest.getLastDonatedAt());
        return user;
    }
    //Factory Method to avoid Code Redundancy => To map 'User' to 'UserResponse DTO'
    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .lastDonatedAt(user.getLastDonatedAt())
                .gender(user.getGender())
                .availableCity(user.getAvailableCity())
                .verified(user.isVerified())
                .bloodGroup(user.getBloodGroup())
                .role(user.getRole())
                .build();
    }
@Override
    public UserResponse promoteUserToAdmin(UserRequest userRequest,int userId){
    Optional<User> user=userRepository.findById(userId);
            if(user.isEmpty())
        throw new UserNotFoundExceptionById("Failed to find user");

    User existUser = user.get();
    existUser.setRole(Role.ADMIN);

    mapUserRequestToUser(userRequest,existUser);

    userRepository.save(existUser);

    Admin admin = Admin.builder().user(existUser).build();

    adminRepositry.save(admin);
    return mapToUserResponse(existUser);
}
    @Override
    public UserResponse addAdminUsers(UserRequest userRequest) {

        User user = mapUserRequestToUser(userRequest,new User());
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        Admin admin = Admin.builder()
                .adminType(AdminType.OWNER)
                .user(user)
                .build();

        adminRepositry.save(admin);
        return mapToUserResponse(user);
    }

}
