package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Request.UserRequest;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor

public class UserController {

   private final UserService userService;
   private final RestResponseBuilder restResponseBuilder;

@PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody UserRequest userRequest){
UserResponse userResponse=userService.addUser(userRequest);
        return restResponseBuilder
                .success(HttpStatus.CREATED,"user created", userResponse) ;
    }

    @GetMapping("/users/{userid}")
    public ResponseEntity<ResponseStructure<UserResponse>>findByUserId(@PathVariable  ("userid") int userId) {
UserResponse userResponse= userService.findByUserId(userId);
return restResponseBuilder.
        success(HttpStatus.FOUND, "User Found", userResponse);
    }
@PutMapping("/users/{userid}")
    public ResponseEntity<ResponseStructure<UserResponse>>updateUser(@PathVariable ("userid") int userId, @RequestBody UserRequest userRequest) {
    UserResponse userResponse1=userService.updateUserById(userId,userRequest);
    return restResponseBuilder.success(HttpStatus.OK,"user updated", userResponse1 );

}
}


