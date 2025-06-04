package Blood_Bank_Management_Api.BBM.Controller;

import Blood_Bank_Management_Api.BBM.Request.AddressRequest;
import Blood_Bank_Management_Api.BBM.Response.AddressResponse;
import Blood_Bank_Management_Api.BBM.Service.AddressService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/address")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.addAddress(addressRequest);
        return responseBuilder.success(HttpStatus.CREATED, "Address Created", addressResponse);

    }}