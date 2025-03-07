package Blood_Bank_Management_Api.BBM.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {
    public <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data){
return ResponseEntity
        .status(status)
        .body(ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)



                .build());
    }
    public ResponseEntity<ErrorStructure>error(HttpStatus status, String rootCause, String message){
        return  ResponseEntity
                .status(status)
                .body(ErrorStructure.builder()
                        .status(status.value())
                        .rootCause(rootCause)
                        .message(message)

                        .build());
    }
}
