package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Security.AuthUtil;
import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.Admin;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.enums.AdminType;
import Blood_Bank_Management_Api.BBM.enums.Role;
import Blood_Bank_Management_Api.BBM.repository.AdminRepositry;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

private final UserRepository userRepository;
private final AdminRepositry adminRepositry;
private  final PasswordEncoder passwordEncoder;


    private final AuthUtil authUtil;

    private UserResponse mapToUSerResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .bloodGroup(user.getBloodGroup())
                .lastDonatedAt(user.getLastDonatedAt())
                .age(user.getAge())
                .gender(user.getGender())
                .availableCity(user.getAvailableCity())
                .verified(user.isVerified())
                .role(user.getRole())
                .build();
    }

    private  User mapToUser(UserRequest userRequest , User user1) {

        user1.setUserName(userRequest.getUserName());
        user1.setPhoneNumber(userRequest.getPhoneNumber());
        user1.setAge(userRequest.getAge());
        user1.setEmail(userRequest.getEmail());
        user1.setPassword(userRequest.getPassword());
        user1.setBloodGroup(userRequest.getBloodGroup());
        user1.setGender(userRequest.getGender());
        user1.setAvailableCity(userRequest.getAvailableCity());
        user1.setLastDonatedAt(userRequest.getLastDonatedAt());
        return user1;
    }


    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user=this.mapToUser(userRequest, new User());
        user.setRole(Role.GUEST_ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user=userRepository.save(user);
        return this.mapToUSerResponse(user);
    }

    @Override
    public UserResponse findByUserId() {
        User user = authUtil.getCurrentUser();
        return mapToUSerResponse(user);
    }
    @Override
    public UserResponse updateUserById(UserRequest userRequest) {
        User exuser = authUtil.getCurrentUser();

           User user3=this.mapToUser(userRequest, exuser);
        User updatedUser = userRepository.save(user3);

        return mapToUSerResponse(updatedUser);

    }

    @Override
    public UserResponse addUserAsAdmin(UserRequest userRequest) {
        User user = this.mapToUser(userRequest, new User());
        user.setRole(Role.OWNER_ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        UserResponse userResponse = this.mapToUSerResponse(user);
        Admin admin = Admin.builder()
                .user(user)

                .build();
        adminRepositry.save(admin);
        return userResponse;
    }
    @Override
    public UserResponse verifyStatus(int userId, boolean status) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundExceptionById("Failed to find the user"));
        user.setVerified(status);
        userRepository.save(user);
        return this.mapToUSerResponse(user);
    }

    @Override
    public UserResponse lastDonatedAt(LocalDate lastDonatedAt) {
        User user = authUtil.getCurrentUser();
        user.setLastDonatedAt(lastDonatedAt);
        User updatedUser = userRepository.save(user);
        return this.mapToUSerResponse(updatedUser);
    }
}
