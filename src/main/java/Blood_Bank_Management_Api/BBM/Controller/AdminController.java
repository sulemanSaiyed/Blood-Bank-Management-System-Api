package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.AdminResponse;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.AdminService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class  AdminController {

    private final AdminService adminService;
    private final RestResponseBuilder responseBuilder;

    @PreAuthorize("hasAuthority('OWNER_ADMIN')")
    @PutMapping("/users/{userId}")

    public ResponseEntity<ResponseStructure<AdminResponse>> promoteUserToAdmin( @PathVariable int userId) {
        AdminResponse adminResponse = adminService.promoteUserToAdmin(userId);
        return responseBuilder.success(HttpStatus.CREATED, "Admin Created", adminResponse);

    }

}
