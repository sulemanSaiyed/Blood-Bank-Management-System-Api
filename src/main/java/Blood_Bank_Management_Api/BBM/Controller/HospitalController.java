package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Request.HospitalRequest;
import Blood_Bank_Management_Api.BBM.Response.HospitalResponse;
import Blood_Bank_Management_Api.BBM.Response.UserResponse;
import Blood_Bank_Management_Api.BBM.Service.HospitalService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final RestResponseBuilder restResponseBuilder;

@PostMapping ("/hospitals")
   public ResponseEntity<ResponseStructure<HospitalResponse>>addHospital(@RequestBody @Valid HospitalRequest hospitalRequest){
HospitalResponse hospitalResponse=hospitalService.addHospital(hospitalRequest);
return restResponseBuilder.success(HttpStatus.CREATED, "Hospital added", hospitalResponse);
}
@GetMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>>getHospital(@PathVariable ("hospitalId") int hospitalId){
    HospitalResponse hospitalResponse=hospitalService.findByHospitalId(hospitalId);
    return  restResponseBuilder.success(HttpStatus.FOUND, "Hospital found", hospitalResponse);
}
    @PutMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>>updateHospital(@PathVariable  ("hospitalId")  int hospitalId, @RequestBody @Valid HospitalRequest hospitalRequest){
        HospitalResponse hospitalResponse=hospitalService.updateByHospitalId(hospitalId, hospitalRequest);
        return  restResponseBuilder.success(HttpStatus.OK, "Hospital updated", hospitalResponse);
    }

}
