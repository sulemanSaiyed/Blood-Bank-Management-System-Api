package Blood_Bank_Management_Api.BBM.Response;

import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import Blood_Bank_Management_Api.BBM.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private int transactionId;
    private LocalDate date;
    private LocalTime time;
    private int noOfUnits;
    private TransactionType transactionType;
    private BloodGroup bloodGroup;
}