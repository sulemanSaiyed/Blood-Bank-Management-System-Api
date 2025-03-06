package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User findByUserId(int userId ) {
        Optional<User> optional=userRepository.findById(userId);
        if(optional.isEmpty()){
            throw new UserNotFoundExceptionById("user not found");}
        return optional.get();
    }
    @Override
    public User updateUserById( int userId, User user){
        Optional<User>optional=userRepository.findById(userId);
        if(optional.isPresent()){
            User cc=optional.get();
            cc.setUserName(user.getUserName());
            cc.setPhoneNumber(user.getPhoneNumber());
           cc.setAge(user.getAge());
         cc.setEmail(user.getEmail());
           cc.setPassword(user.getPassword());
            cc.setBloodGroup(user.getBloodGroup());
            cc.setGender(user.getGender());
           cc.setAvailableCity(user.getAvailableCity());
            cc.setVerified(user.isVerified());
            return userRepository.save(cc);
        }
        else throw  new UserNotFoundExceptionById("user not found");
    }
}
