package Blood_Bank_Management_Api.BBM.repository;

import Blood_Bank_Management_Api.BBM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User,Integer> {
}
