package Blood_Bank_Management_Api.BBM.Request;

import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import Blood_Bank_Management_Api.BBM.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private BloodGroup bloodGroup;
    private int age;
    private Gender gender;
    private String availableCity;
    private LocalDate lastDonatedAt;
}
