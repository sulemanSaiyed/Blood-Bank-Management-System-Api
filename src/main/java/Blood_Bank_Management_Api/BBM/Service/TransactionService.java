package Blood_Bank_Management_Api.BBM.Service;


import Blood_Bank_Management_Api.BBM.Request.TransactionRequest;
import Blood_Bank_Management_Api.BBM.Response.TransactionResponse;

public interface TransactionService {

    TransactionResponse checkTransaction(TransactionRequest transactionRequest, int hospitalId, int userId) throws Exception;

//    TransactionResponse addUserTransaction(TransactionRequest transactionRequest);

//    TransactionResponse addHospitalTransaction(TransactionRequest transactionRequest, int hospitalId);

}