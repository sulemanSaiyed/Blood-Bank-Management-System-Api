package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.AdminResponse;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;

public interface AdminService {
    public UserResponse promoteUserToAdmin(UserRequest userRequest,int userId);
    UserResponse addAdminUsers(UserRequest userRequest);
}
