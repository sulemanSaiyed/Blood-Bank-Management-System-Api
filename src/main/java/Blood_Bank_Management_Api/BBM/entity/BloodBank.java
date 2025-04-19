package Blood_Bank_Management_Api.BBM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bankId;

    private String bankName;
    private int emergencyUnitCount;

    @OneToMany
    private List<Admin> admin;


}
