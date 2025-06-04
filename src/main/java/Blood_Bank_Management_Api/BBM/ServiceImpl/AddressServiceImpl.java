package Blood_Bank_Management_Api.BBM.ServiceImpl;


import Blood_Bank_Management_Api.BBM.Request.AddressRequest;
import Blood_Bank_Management_Api.BBM.Response.AddressResponse;
import Blood_Bank_Management_Api.BBM.Service.AddressService;
import Blood_Bank_Management_Api.BBM.entity.Address;
import Blood_Bank_Management_Api.BBM.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private AddressResponse mapToAddressResponse(Address address) {
        return AddressResponse.builder()
                .addressId(address.getAddressId())
                .addressLine(address.getAddressLine())
                .landmark(address.getLandmark())
                .area(address.getArea())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pincode(address.getPincode())
                .build();
    }

    private Address mapToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .addressLine(addressRequest.getAddressLine())
                .landmark(addressRequest.getLandmark())
                .area(addressRequest.getArea())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .pincode(addressRequest.getPincode())
                .build();
    }
    @Override
    public AddressResponse addAddress(AddressRequest addressRequest) {
        Address address = this.mapToAddress(addressRequest);
        address = addressRepository.save(address);
        return this.mapToAddressResponse(address);
    }

}