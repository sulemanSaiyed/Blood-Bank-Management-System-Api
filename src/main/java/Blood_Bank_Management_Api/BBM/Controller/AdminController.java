package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Response.AdminResponse;
import Blood_Bank_Management_Api.BBM.Service.AdminService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/admins/{userId}")
    public ResponseEntity<ResponseStructure<AdminResponse>> promoteUserToAdmin(@PathVariable int userId) {
        AdminResponse adminResponse = adminService.promoteUserToAdmin(userId);
        return responseBuilder.success(HttpStatus.CREATED, "Admin Created", adminResponse);

    }

}
