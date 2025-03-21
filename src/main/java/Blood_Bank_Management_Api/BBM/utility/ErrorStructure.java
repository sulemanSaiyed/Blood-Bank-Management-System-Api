package Blood_Bank_Management_Api.BBM.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ErrorStructure <T>{
    private  int status;
    private T rootCause;
    private String message;
}
