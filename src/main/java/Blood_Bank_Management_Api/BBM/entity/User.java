package Blood_Bank_Management_Api.BBM.entity;
import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import Blood_Bank_Management_Api.BBM.enums.Gender;
import Blood_Bank_Management_Api.BBM.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
@OneToOne(mappedBy = "user",fetch = FetchType.EAGER)

    private Admin admin;
    @OneToOne
    private Address address;
}
