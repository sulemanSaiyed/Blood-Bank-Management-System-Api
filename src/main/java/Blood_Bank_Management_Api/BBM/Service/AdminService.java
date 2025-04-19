package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Response.AdminResponse;

public interface AdminService {
    public AdminResponse promoteUserToAdmin(int userId);
}
