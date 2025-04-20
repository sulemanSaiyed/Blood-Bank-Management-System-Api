package Blood_Bank_Management_Api.BBM.entity;

import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleId;
    private BloodGroup bloodGroup;
    private int quantity;
    private boolean availability;
    private int emergencyUnits;
    private int availableUnits;

    @ManyToOne
    private BloodBank bloodBank;
}

