package Blood_Bank_Management_Api.BBM.Response;

import Blood_Bank_Management_Api.BBM.enums.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleResponse {


    private int sampleId;
    private BloodGroup bloodGroup;
    private int quantity;
    private boolean availability;
    private int emergencyUnits;
    private int availableUnits;}