package Blood_Bank_Management_Api.BBM.entity;
import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import Blood_Bank_Management_Api.BBM.enums.Gender;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String availableCity;
    private boolean verified;
    private LocalDate lastDonatedAt;
    private int age;
    private BloodGroup bloodGroup;
    private Gender gender;

}
