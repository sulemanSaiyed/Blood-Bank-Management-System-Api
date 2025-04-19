package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.BloodBankRequest;
import Blood_Bank_Management_Api.BBM.Response.BloodBankResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface BloodBanklService {
    BloodBankResponse addBloodBank(@Valid BloodBankRequest bloodBankRequest);
    List<BloodBankResponse> findAllBank();
    BloodBankResponse findBloodBankById( int bankId);
    BloodBankResponse updateBloodBankById( int bankId, BloodBankRequest bloodBankRequest);
    BloodBankResponse addAdminBank(BloodBankRequest bloodBankRequest, int adminId );
}
