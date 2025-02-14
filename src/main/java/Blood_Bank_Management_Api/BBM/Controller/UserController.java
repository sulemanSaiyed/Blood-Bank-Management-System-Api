package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Service.UserService;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    @Autowired
    UserService userService;

    public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user){
user=userService.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(),"User created", user) );
    }
}
