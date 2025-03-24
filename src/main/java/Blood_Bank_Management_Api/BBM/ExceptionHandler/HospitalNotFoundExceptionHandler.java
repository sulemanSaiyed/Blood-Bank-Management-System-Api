package Blood_Bank_Management_Api.BBM.ExceptionHandler;

import Blood_Bank_Management_Api.BBM.Exception.HospitalNotFoundException;
import Blood_Bank_Management_Api.BBM.utility.ErrorStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class HospitalNotFoundExceptionHandler {
    private RestResponseBuilder restResponseBuilder;
    @ExceptionHandler(HospitalNotFoundException.class)
    private<T> ResponseEntity<ErrorStructure<String>>handleHospitalNotFoundException(HospitalNotFoundException hospitalNotFoundException){
        return restResponseBuilder.error(HttpStatus.NOT_FOUND, hospitalNotFoundException.getMessage(), "hospital not by the id");
    }
}
