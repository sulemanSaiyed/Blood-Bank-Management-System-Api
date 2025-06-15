package Blood_Bank_Management_Api.BBM.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
   // @OneToMany(mappedBy = "hospital") check
   // @OneToMany
   @OneToMany(mappedBy = "hospital")
    private List<Admin> admin;
    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "hospital")
    private List<Transaction> transaction;
}
