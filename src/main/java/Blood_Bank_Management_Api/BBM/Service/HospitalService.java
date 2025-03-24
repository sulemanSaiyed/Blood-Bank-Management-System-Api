package Blood_Bank_Management_Api.BBM.Service;

import Blood_Bank_Management_Api.BBM.Request.HospitalRequest;
import Blood_Bank_Management_Api.BBM.Response.HospitalResponse;

public interface HospitalService {
    public HospitalResponse addHospital(HospitalRequest hospitalRequest);
    public HospitalResponse findByHospitalId(int hospitalId);
    public HospitalResponse updateByHospitalId(int hospitalId ,HospitalRequest hospitalRequest);
}
