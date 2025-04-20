package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.entity.User;
import jakarta.validation.Valid;

public interface UserService {

    public UserResponse addUser(UserRequest userRequest);
    public UserResponse findByUserId(int userId);

    public UserResponse updateUserById(int userId, UserRequest userRequest);
    UserResponse addUserAsAdmin(@Valid UserRequest userRequest);

}
  