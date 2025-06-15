package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.HospitalNotFoundException;

import Blood_Bank_Management_Api.BBM.Exception.UserNotFoundExceptionById;
import Blood_Bank_Management_Api.BBM.Request.HospitalRequest;
import Blood_Bank_Management_Api.BBM.Response.HospitalResponse;
import Blood_Bank_Management_Api.BBM.Service.HospitalService;
import Blood_Bank_Management_Api.BBM.entity.Admin;
import Blood_Bank_Management_Api.BBM.entity.Hospital;
import Blood_Bank_Management_Api.BBM.enums.AdminType;
import Blood_Bank_Management_Api.BBM.repository.AdminRepositry;
import Blood_Bank_Management_Api.BBM.repository.HospitalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HospiitalImpl implements HospitalService {
    private  final HospitalRepository hospitalRepository;
private  final AdminRepositry adminRepositry;

    private Hospital mapToHospital(HospitalRequest hospitalRequest, Hospital hospital1){
        hospital1.setHospitalName(hospitalRequest.getHospitalName());
        return hospital1;

    }
    private HospitalResponse mapToHospitalResponse(Hospital hospital){
        return HospitalResponse.builder()
                .hospitalId(hospital.getHospitalId())
                .hospitalName(hospital.getHospitalName())
                .build();
    }




    @Override
    public HospitalResponse addHospital(HospitalRequest hospitalRequest){
Hospital hospital2=this.mapToHospital(hospitalRequest, new Hospital());
hospital2=hospitalRepository.save(hospital2);
return this.mapToHospitalResponse(hospital2);

    }
    @Override
    public HospitalResponse findByHospitalId(int hospitalId){
Hospital hospital3=hospitalRepository.findById(hospitalId).orElseThrow(()->new HospitalNotFoundException("user not found"));
return this.mapToHospitalResponse(hospital3);
    }


    @Override
    public HospitalResponse updateByHospitalId(int hospitalId ,HospitalRequest hospitalRequest){
Hospital hospital3 = hospitalRepository.findById(hospitalId)
        .orElseThrow(()->new HospitalNotFoundException(("cant find hospital need to update")));

Hospital hospital5=this.mapToHospital(hospitalRequest, hospital3);
 hospital5=hospitalRepository.save(hospital5);
return this.mapToHospitalResponse(hospital5);
    }

    public HospitalResponse addAdminHospital(HospitalRequest hospitalRequest, int adminId){
Admin admin=adminRepositry.findById(adminId).orElseThrow(()->new UserNotFoundExceptionById("admin not found"));

Hospital hospital=Hospital.builder()
        .hospitalName(hospitalRequest.getHospitalName())
        .build();
        hospital = hospitalRepository.save(hospital);
        List<Admin> admins = new ArrayList<>();
        admins.add(admin);
        hospital.setAdmin(admins);

        admin.setHospital(hospital);
        adminRepositry.save(admin);

        return this.mapToHospitalResponse(hospital);
    }



}

