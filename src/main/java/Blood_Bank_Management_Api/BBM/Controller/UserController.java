package Blood_Bank_Management_Api.BBM.Controller;

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
    public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user){
user=userService.addUser(user);
        return restResponseBuilder
                .success(HttpStatus.CREATED,"user created", user) ;
    }

    @GetMapping("/users/{userid}")
    public ResponseEntity<ResponseStructure<User>>findByUserId(@PathVariable  ("userid") int userId) {
User user= userService.findByUserId(userId);
return restResponseBuilder.
        success(HttpStatus.FOUND, "User Found", user);
    }
@PutMapping("/users/{userid}")
    public ResponseEntity<ResponseStructure<User>>updateUser(@PathVariable ("userid") int userId, @RequestBody User user1) {
    user1=userService.updateUserById(userId,user1);
    return restResponseBuilder.success(HttpStatus.OK,"user updated", user1 );

}
}


