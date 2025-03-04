package Blood_Bank_Management_Api.BBM.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class UserNotFoundExceptionById extends Exception {
    private final String message;
}
