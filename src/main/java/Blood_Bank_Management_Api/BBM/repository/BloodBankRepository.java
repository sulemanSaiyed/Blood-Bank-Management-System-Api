package Blood_Bank_Management_Api.BBM.repository;

import Blood_Bank_Management_Api.BBM.entity.BloodBank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository extends JpaRepository<BloodBank, Integer> {
}
