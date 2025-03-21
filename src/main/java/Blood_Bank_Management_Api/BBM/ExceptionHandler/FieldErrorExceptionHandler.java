package Blood_Bank_Management_Api.BBM.ExceptionHandler;

import Blood_Bank_Management_Api.BBM.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
      List<ObjectError>objectErrors =ex.getAllErrors();
      List<FieldErrorStructure>error=new ArrayList<>();

for(ObjectError objectError:objectErrors){
   FieldError error1 =(FieldError)objectError;
   error.add(FieldErrorStructure.builder()
                   .field(error1.getField())
                           .rejectedValue(error1.getRejectedValue())
    .message(error1.getDefaultMessage())
           .build());
}
        ErrorStructure<List<FieldErrorStructure>> error2=new ErrorStructure();
error2.setStatus(HttpStatus.BAD_REQUEST.value());
error2.setRootCause(error);
error2.setMessage("invalid input");


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error2);
    }

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public static class FieldErrorStructure{
    private String field;
    private Object rejectedValue;
    private String message;
}}