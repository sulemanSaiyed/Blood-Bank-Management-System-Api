package Blood_Bank_Management_Api.BBM.ServiceImpl;

import Blood_Bank_Management_Api.BBM.Exception.BloodBankNotFoundByIDException;
import Blood_Bank_Management_Api.BBM.Exception.SampleNotFoundException;
import Blood_Bank_Management_Api.BBM.Request.SampleRequest;
import Blood_Bank_Management_Api.BBM.Response.SampleResponse;
import Blood_Bank_Management_Api.BBM.Service.SampleService;
import Blood_Bank_Management_Api.BBM.entity.BloodBank;
import Blood_Bank_Management_Api.BBM.entity.Sample;

import Blood_Bank_Management_Api.BBM.repository.BloodBankRepository;
import Blood_Bank_Management_Api.BBM.repository.SampleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;
    private final BloodBankRepository bloodRepository;

    private SampleResponse mapToSampleResponse(Sample sample) {
        return SampleResponse.builder()
                .sampleId(sample.getSampleId())
                .bloodGroup(sample.getBloodGroup())
                .quantity(sample.getQuantity())
                .availability(sample.isAvailability())
                .emergencyUnits(sample.getEmergencyUnits())
                .availableUnits(sample.getAvailableUnits())
                .build();
    }

    private Sample mapToSample(SampleRequest sampleRequest, Sample sample) {
        sample.setBloodGroup(sampleRequest.getBloodGroup());
        sample.setQuantity(sampleRequest.getQuantity());
        sample.setAvailability(sampleRequest.isAvailability());

        return sample;
    }

    @Override
    public SampleResponse addSample(SampleRequest sampleRequest) {
        Sample sample = mapToSample(sampleRequest, new Sample());
        sample = sampleRepository.save(sample);
        return mapToSampleResponse(sample);
    }

    @Override
    public SampleResponse findSampleById(int sampleId) {
        Sample sample = sampleRepository.findById(sampleId)
                .orElseThrow(() -> new SampleNotFoundException("Sample Not Found"));
        return mapToSampleResponse(sample);
    }

    @Override
    public List<SampleResponse> findAllSamples() {
        List<Sample> samples = sampleRepository.findAll();
        if (samples.isEmpty()) {
            throw new SampleNotFoundException("Failed to find samples in database");
        } else {
            return samples.stream()
                    .map(this::mapToSampleResponse)
                    .toList();
        }
    }

    @Override
    public SampleResponse updateSampleId(int sampleId, SampleRequest sampleRequest) {
        Sample exSample = sampleRepository.findById(sampleId)
                .orElseThrow(() -> new SampleNotFoundException("Failed to update"));
        Sample sample = this.mapToSample(sampleRequest, exSample);
        Sample updatedSample = sampleRepository.save(sample);
        return mapToSampleResponse(updatedSample);
    }

    @Override
    public SampleResponse addSampleToBank(SampleRequest sampleRequest, int bankId) {
        BloodBank bloodBank = bloodRepository.findById(bankId)
                .orElseThrow(() -> new BloodBankNotFoundByIDException("Blood Bank Not Found"));

        Sample sample = Sample.builder()
                .bloodBank(bloodBank)
                .bloodGroup(sampleRequest.getBloodGroup())
                .quantity(sampleRequest.getQuantity())
                .availability(sampleRequest.isAvailability())

                .build();
        int emergencyUnitCount = bloodBank.getEmergencyUnitCount();
        int requestedQuantity = sampleRequest.getQuantity();

        if (requestedQuantity >= emergencyUnitCount) {
            // If the requested quantity is greater than or equal to the emergency unit count
            sample.setEmergencyUnits(emergencyUnitCount);
            sample.setAvailableUnits(requestedQuantity - emergencyUnitCount);
        } else {
            // If the requested quantity is less than the emergency unit count
            sample.setEmergencyUnits(requestedQuantity);
            sample.setAvailableUnits(emergencyUnitCount - requestedQuantity);
        }
        sampleRepository.save(sample);
        return mapToSampleResponse(sample);
    }
}