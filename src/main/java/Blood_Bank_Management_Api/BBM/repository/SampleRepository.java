package Blood_Bank_Management_Api.BBM.repository;


import Blood_Bank_Management_Api.BBM.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Integer> {
}