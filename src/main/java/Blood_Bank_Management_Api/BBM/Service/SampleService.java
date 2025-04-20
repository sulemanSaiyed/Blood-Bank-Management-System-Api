package Blood_Bank_Management_Api.BBM.Service;


import Blood_Bank_Management_Api.BBM.Request.SampleRequest;
import Blood_Bank_Management_Api.BBM.Response.SampleResponse;

import java.util.List;

public interface SampleService {
    SampleResponse addSample(SampleRequest sampleRequest);

    SampleResponse findSampleById(int sampleId);

    List<SampleResponse> findAllSamples();

    SampleResponse updateSampleId(int sampleId, SampleRequest sampleRequest);

    SampleResponse addSampleToBank(SampleRequest sampleRequest, int bankId);
}