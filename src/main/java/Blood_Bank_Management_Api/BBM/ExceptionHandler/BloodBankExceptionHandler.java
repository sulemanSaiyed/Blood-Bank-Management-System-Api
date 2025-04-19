package Blood_Bank_Management_Api.BBM.ExceptionHandler;

import Blood_Bank_Management_Api.BBM.Exception.BloodBankNotFoundByIDException;
import Blood_Bank_Management_Api.BBM.utility.ErrorStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BloodBankExceptionHandler {
    private RestResponseBuilder restResponseBuilder;
    @ExceptionHandler(BloodBankNotFoundByIDException.class)
    public <T> ResponseEntity<ErrorStructure<String>> handleBloodBankNotFoundByIDException(BloodBankNotFoundByIDException ex){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"blood bank not found by given id");
    }
}
