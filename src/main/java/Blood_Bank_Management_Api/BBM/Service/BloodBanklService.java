package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.BloodBankRequest;
import Blood_Bank_Management_Api.BBM.Response.BloodBankResponse;
import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import jakarta.validation.Valid;

import java.util.List;

public interface BloodBanklService {

    List<BloodBankResponse> findAllBloodBankByCity(List<String> city, BloodGroup bloodGroup);
    BloodBankResponse findBloodBankById( int bankId);
    BloodBankResponse updateBloodBankById( int bankId, BloodBankRequest bloodBankRequest);
    BloodBankResponse addAdminBank(BloodBankRequest bloodBankRequest, int adminId );
}
