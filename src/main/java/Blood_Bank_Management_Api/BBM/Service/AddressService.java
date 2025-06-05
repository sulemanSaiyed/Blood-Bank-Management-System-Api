package Blood_Bank_Management_Api.BBM.Service;


import Blood_Bank_Management_Api.BBM.Request.AddressRequest;
import Blood_Bank_Management_Api.BBM.Response.AddressResponse;

public interface AddressService {
   // AddressResponse addAddress(AddressRequest addressRequest);
   AddressResponse addUserAddress(AddressRequest addressRequest);

    AddressResponse addHospitalAddress(AddressRequest addressRequest, int hospitalId);

    AddressResponse addBloodbankAddress(AddressRequest addressRequest, int bloodbankId);

    AddressResponse updateUserAddress(AddressRequest addressRequest, int addressId);

    AddressResponse updateHospitalAddress(AddressRequest addressRequest, int hospitalId);

    AddressResponse updateBloodBankAddress(AddressRequest addressRequest, int bloodbankId);

    AddressResponse findUserAddress();

    AddressResponse findHospitalAddress(int hospitalId);

    AddressResponse findBloodBankAddress(int bloodbankId);

}