package Blood_Bank_Management_Api.BBM.repository;

import Blood_Bank_Management_Api.BBM.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepositry extends JpaRepository<Admin, Integer> {

    public Optional<Admin> findByUser_Email(String userName);
}
