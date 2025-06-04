package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.entity.User;
import jakarta.validation.Valid;

import java.time.LocalDate;

public interface UserService {

    public UserResponse addUser(UserRequest userRequest);
    public UserResponse findByUserId();

    public UserResponse updateUserById(UserRequest userRequest);

UserResponse addUserAsAdmin(@Valid UserRequest userRequest);
    UserResponse verifyStatus(int userId, boolean isVerified);

    UserResponse lastDonatedAt(LocalDate lastDonatedAt);
}
  