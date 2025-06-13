package Blood_Bank_Management_Api.BBM.Controller;


import Blood_Bank_Management_Api.BBM.Request.BloodBankRequest;
import Blood_Bank_Management_Api.BBM.Response.BloodBankResponse;
import Blood_Bank_Management_Api.BBM.Service.BloodBanklService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BloodBankController {

    private BloodBanklService bankService;
    private RestResponseBuilder responseBuilder;

    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN')")
    @PostMapping("/bloodbanks")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> addBloodBank(@RequestBody @Valid BloodBankRequest bankRequest){
        BloodBankResponse bankResponse = bankService.addBloodBank(bankRequest);
        return responseBuilder.success(HttpStatus.CREATED, "BloodBank Created", bankResponse);
    }

    @GetMapping("/bloodbanks/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> findBloodBankById(@PathVariable int bankId){
        BloodBankResponse bankResponse = bankService.findBloodBankById(bankId);
        return responseBuilder.success(HttpStatus.FOUND, "BloodBank Found", bankResponse);
    }

    @GetMapping("/blood-banks")
    public ResponseEntity<ResponseStructure<List<BloodBankResponse>>> findAllBloodBankByCity(@RequestParam List<String> city){
        List<BloodBankResponse> bankResponse = bankService.findAllBloodBankByCity(city);
        return responseBuilder.success(HttpStatus.FOUND, "BloodBanks Found", bankResponse);}

    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN') ")
    @PutMapping("/bloodbanks/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateBloodBankById(@PathVariable int bankId, @RequestBody @Valid BloodBankRequest bankRequest){
        BloodBankResponse bankResponse = bankService.updateBloodBankById(bankId, bankRequest);
        return responseBuilder.success(HttpStatus.FOUND, "BloodBank Updated", bankResponse);
    }
    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN')")
    @PostMapping("/bloodbanks-admin/{adminId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> addAdminBank(@RequestBody BloodBankRequest bankRequest, @PathVariable int adminId){
        BloodBankResponse bankResponse = bankService.addAdminBank(bankRequest, adminId);
        return responseBuilder.success(HttpStatus.CREATED, "Blood Bank Admin Created", bankResponse);
    }
}