package Blood_Bank_Management_Api.BBM.entity;

import Blood_Bank_Management_Api.BBM.enums.AdminType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;


    @OneToOne
    private User user;


    @Enumerated(EnumType.STRING)
    private AdminType adminType;
}
