package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor

public class UserController {

   private final UserService userService;
   private final RestResponseBuilder restResponseBuilder;

@PostMapping("/registerUsers")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser( @RequestBody @Valid  UserRequest userRequest){
UserResponse userResponse=userService.addUser(userRequest);
        return restResponseBuilder
                .success(HttpStatus.CREATED,"user created", userResponse) ;
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(){
        UserResponse userResponse = userService.findByUserId();
return restResponseBuilder.
        success(HttpStatus.FOUND, "User Found", userResponse);
    }
    @PutMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody @Valid UserRequest userRequest){
        UserResponse userResponse = userService.updateUserById(userRequest);
    return restResponseBuilder.success(HttpStatus.OK,"user updated", userResponse );

}
    @PostMapping("/register-admin")
    public ResponseEntity<ResponseStructure<UserResponse>> addUserAsAdmin(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.addUserAsAdmin(userRequest);
        return restResponseBuilder.success(HttpStatus.CREATED, "User Created", userResponse);
    }

    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN') || hasAnyAuthority('OWNER_ADMIN')")
    @PatchMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> verifyStatus(@PathVariable int userId, @RequestParam boolean isVerified) {
        UserResponse userResponse = userService.verifyStatus(userId, isVerified);
        return restResponseBuilder.success(HttpStatus.OK,"Status Updated", userResponse);
    }
    @PatchMapping("/users-lastDonate")
    public ResponseEntity<ResponseStructure<UserResponse>> updateLastDonatedAt(@RequestParam LocalDate lastDonatedAt){
        UserResponse userResponse = userService.lastDonatedAt(lastDonatedAt);
        return restResponseBuilder.success(HttpStatus.OK,"Last Donated Date Updated", userResponse);
    }
}


