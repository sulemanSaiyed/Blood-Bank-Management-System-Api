package Blood_Bank_Management_Api.BBM.Service;


import Blood_Bank_Management_Api.BBM.Request.AddressRequest;
import Blood_Bank_Management_Api.BBM.Response.AddressResponse;

public interface AddressService {
    AddressResponse addAddress(AddressRequest addressRequest);
}