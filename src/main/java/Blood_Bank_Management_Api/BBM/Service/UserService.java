package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.entity.User;

public interface UserService {

    UserResponse addUser(UserRequest userRequest);
    public UserResponse findByUserId(int userId);

    public User updateUserById(int userId, UserRequest userRequest);


}
  