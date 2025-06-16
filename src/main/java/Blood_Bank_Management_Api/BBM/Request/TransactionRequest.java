package Blood_Bank_Management_Api.BBM.Request;

import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import Blood_Bank_Management_Api.BBM.enums.TransactionType;
import lombok.AllArgsConstructor;Add commentMore actions
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private LocalDate date;
    private LocalTime time;
    private int noOfUnits;
    private TransactionType transactionType;
    private BloodGroup bloodGroup;
}