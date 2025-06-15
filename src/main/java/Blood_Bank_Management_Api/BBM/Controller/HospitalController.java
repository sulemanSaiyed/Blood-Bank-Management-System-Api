package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Request.BloodBankRequest;
import Blood_Bank_Management_Api.BBM.Request.HospitalRequest;
import Blood_Bank_Management_Api.BBM.Response.BloodBankResponse;
import Blood_Bank_Management_Api.BBM.Response.HospitalResponse;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.HospitalService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final RestResponseBuilder restResponseBuilder;

    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN')")
    @PostMapping("/hospitals-admin/{adminId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> addAdminHospital(@RequestBody HospitalRequest hospitalRequest, @PathVariable int adminId){
        HospitalResponse hospitalResponse = hospitalService.addAdminHospital(hospitalRequest, adminId);
        return restResponseBuilder.success(HttpStatus.CREATED, "Hospital Admin Created", hospitalResponse);}

@GetMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>>getHospital(@PathVariable ("hospitalId") int hospitalId){
    HospitalResponse hospitalResponse=hospitalService.findByHospitalId(hospitalId);
    return  restResponseBuilder.success(HttpStatus.FOUND, "Hospital found", hospitalResponse);
}
    @PreAuthorize("hasAuthority('GUEST_ADMIN')")
    @PutMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>>updateHospital(@PathVariable  ("hospitalId")  int hospitalId, @RequestBody @Valid HospitalRequest hospitalRequest){
        HospitalResponse hospitalResponse=hospitalService.updateByHospitalId(hospitalId, hospitalRequest);
        return  restResponseBuilder.success(HttpStatus.OK, "Hospital updated", hospitalResponse);
    }


}
