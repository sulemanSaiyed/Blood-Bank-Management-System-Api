package Blood_Bank_Management_Api.BBM.repository;

import Blood_Bank_Management_Api.BBM.entity.BloodBank;

import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodBankRepository extends JpaRepository<BloodBank, Integer> {
    List<BloodBank> findByAddress_CityInAndSamples_BloodGroupIn(List<String> cities, List<BloodGroup> bloodGroups);
}
