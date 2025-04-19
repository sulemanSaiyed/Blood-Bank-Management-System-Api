package Blood_Bank_Management_Api.BBM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bankId;

    private String name;
    private int emergencyUnitCount;

    @OneToMany
    private List<Admin> admin;


}
