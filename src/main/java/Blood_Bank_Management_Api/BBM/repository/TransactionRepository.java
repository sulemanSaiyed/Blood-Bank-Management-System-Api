package Blood_Bank_Management_Api.BBM.repository;

import Blood_Bank_Management_Api.BBM.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}