package Blood_Bank_Management_Api.BBM.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  int hospitalId;
    private String hospitalName;

}
