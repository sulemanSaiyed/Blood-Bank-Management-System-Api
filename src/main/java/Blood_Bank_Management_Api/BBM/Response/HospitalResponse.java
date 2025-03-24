package Blood_Bank_Management_Api.BBM.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalResponse {
    private  int hospitalId;
    private String hospitalName;


}

