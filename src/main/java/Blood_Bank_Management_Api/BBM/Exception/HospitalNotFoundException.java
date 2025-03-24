package Blood_Bank_Management_Api.BBM.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HospitalNotFoundException extends RuntimeException {
    private String message;
}
