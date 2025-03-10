package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

private final UserRepository userRepository;

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user=User.builder()
                .userName(userRequest.getUserName())
                .email(userRequest.getEmail())
                .age(userRequest.getAge())
                .password(userRequest.getPassword())
                .bloodGroup(userRequest.getBloodGroup())
                .availableCity(userRequest.getAvailableCity())
                .gender(userRequest.getGender())
                .phoneNumber(userRequest.getPhoneNumber())
                .build();

        user=userRepository.save(user);

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
    @Override
    public UserResponse findByUserId(int userId ) {
        User user=userRepository.findById(userId).orElseThrow(()->new UserNotFoundExceptionById("user not found"));
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
    @Override
    public UserResponse updateUserById( int userId, UserRequest userRequest){
        User user1=userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundExceptionById("user not present to update"));


            user1.setUserName(userRequest.getUserName());
            user1.setPhoneNumber(userRequest.getPhoneNumber());
           user1.setAge(userRequest.getAge());
         user1.setEmail(userRequest.getEmail());
           user1.setPassword(userRequest.getPassword());
            user1.setBloodGroup(userRequest.getBloodGroup());
            user1.setGender(userRequest.getGender());
           user1.setAvailableCity(userRequest.getAvailableCity());
           User updateUser=userRepository.save(user1);


            return  UserResponse.builder()
                    .userId(updateUser.getUserId())
                    .userName(updateUser.getUserName())
                    .bloodGroup(updateUser.getBloodGroup())
                    .lastDonatedAt(updateUser.getLastDonatedAt())
                    .age(updateUser.getAge())
                    .gender(updateUser.getGender())
                    .availableCity(updateUser.getAvailableCity())
                    .verified(updateUser.isVerified())
                    .build();

    }
}
