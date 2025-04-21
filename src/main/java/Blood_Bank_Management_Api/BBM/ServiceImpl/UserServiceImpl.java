package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.Admin;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.enums.AdminType;
import Blood_Bank_Management_Api.BBM.enums.Role;
import Blood_Bank_Management_Api.BBM.repository.AdminRepositry;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

private final UserRepository userRepository;
private final AdminRepositry adminRepositry;



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
        return user1;
    }


    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user=this.mapToUser(userRequest, new User());
        user=userRepository.save(user);
        return this.mapToUSerResponse(user);
    }

    @Override
    public UserResponse findByUserId(int userId ) {
        User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundExceptionById("user not found"));
        return mapToUSerResponse(user);
    }
    @Override
    public UserResponse updateUserById( int userId, UserRequest userRequest){
        User user2=userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundExceptionById("user not present to update"));



           User user3=this.mapToUser(userRequest, user2);
        User updatedUser = userRepository.save(user3);

        return mapToUSerResponse(updatedUser);

    }


}
