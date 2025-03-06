package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.entity.User;

public interface UserService {

    User addUser(User user);
    public User findByUserId(int userId);

    public User updateUserById(int userId, User user);


}
  