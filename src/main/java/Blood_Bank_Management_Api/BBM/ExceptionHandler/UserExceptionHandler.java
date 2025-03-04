package Blood_Bank_Management_Api.BBM.ExceptionHandler;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.utility.ErrorStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {
    private RestResponseBuilder restResponseBuilder;

    @ExceptionHandler(UserNotFoundExceptionById.class)

    //public ResponseEntity<ErrorStructure> handleUserNotFoundById(HttpStatus status, String rootCause, String message)
    public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundExceptionById ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"user not found by given id");
    }
}
