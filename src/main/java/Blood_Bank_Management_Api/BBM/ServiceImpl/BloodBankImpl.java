package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.BloodBankNotFoundByIDException;
import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Request.BloodBankRequest;
import Blood_Bank_Management_Api.BBM.Response.BloodBankResponse;
import Blood_Bank_Management_Api.BBM.Service.BloodBanklService;
import Blood_Bank_Management_Api.BBM.entity.Admin;
import Blood_Bank_Management_Api.BBM.entity.BloodBank;
import Blood_Bank_Management_Api.BBM.enums.AdminType;
import Blood_Bank_Management_Api.BBM.repository.AdminRepositry;
import Blood_Bank_Management_Api.BBM.repository.BloodBankRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BloodBankImpl implements BloodBanklService {
    private BloodBankRepository bloodBankRepository;
private AdminRepositry adminRepositry;

private  BloodBankResponse mapToBloodABnkResponse(BloodBank bloodBank){
    return BloodBankResponse.builder()
            .bankId(bloodBank.getBankId())
            .bankName(bloodBank.getBankName())
            .emergencyUnitCount(bloodBank.getEmergencyUnitCount())
            .build();

}
private BloodBank mapToBloodABnk(BloodBankRequest bloodBankRequest, BloodBank bloodBank){
    bloodBank.setBankName(bloodBankRequest.getBankName());
    bloodBank.setEmergencyUnitCount(bloodBankRequest.getEmergencyUnitCount());
    return bloodBank;
}

@Override
   public BloodBankResponse addBloodBank( BloodBankRequest bloodBankRequest){
    BloodBank bloodBank=mapToBloodABnk(bloodBankRequest, new BloodBank());
    bloodBank=bloodBankRepository.save(bloodBank);
    return mapToBloodABnkResponse(bloodBank) ;
}
    @Override
    public List<BloodBankResponse> findAllBank(){
       List<BloodBank>bloodBank=bloodBankRepository.findAll();
        if(bloodBank.isEmpty()){
            throw new BloodBankNotFoundByIDException("Failed to find blood banks in database");
        } else { return bloodBank.stream()
                .map(this::mapToBloodABnkResponse)
                .toList();
    }}


    @Override
    public BloodBankResponse findBloodBankById( int bankId){
BloodBank bloodBank=bloodBankRepository.findById(bankId).orElseThrow(()->new BloodBankNotFoundByIDException("bank not found"));
        return mapToBloodABnkResponse(bloodBank);
    }
    @Override
    public  BloodBankResponse updateBloodBankById( int bankId, BloodBankRequest bloodBankRequest){
    BloodBank getBloodBank=bloodBankRepository.findById(bankId).orElseThrow(()->new BloodBankNotFoundByIDException("failed to update"));
    BloodBank bloodBank=mapToBloodABnk(bloodBankRequest, getBloodBank);
    BloodBank updateBloodbank=bloodBankRepository.save(bloodBank);
return mapToBloodABnkResponse(updateBloodbank);
    }

    @Override
    public BloodBankResponse addAdminBank(BloodBankRequest bloodBankRequest, int adminId ){
        Admin fetchedadmin=adminRepositry.findById(adminId).orElseThrow(()-> new UserNotFoundExceptionById("Admin not found"));
        List<Admin>admins=new ArrayList<>();
        admins.add(fetchedadmin);
        BloodBank bloodBank=BloodBank.builder()
                .admin(admins)
                .bankName(bloodBankRequest.getBankName())
                .emergencyUnitCount(bloodBankRequest.getEmergencyUnitCount())
                .build();


        bloodBankRepository.save(bloodBank);
        return this.mapToBloodABnkResponse(bloodBank);
}

    }




