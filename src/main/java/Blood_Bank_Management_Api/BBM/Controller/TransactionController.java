package Blood_Bank_Management_Api.BBM.Controller;
import Blood_Bank_Management_Api.BBM.Request.TransactionRequest;
import Blood_Bank_Management_Api.BBM.Response.TransactionResponse;
import Blood_Bank_Management_Api.BBM.Service.TransactionService;
import Blood_Bank_Management_Api.BBM.utility.ResponseStructure;
import Blood_Bank_Management_Api.BBM.utility.RestResponseBuilder;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final RestResponseBuilder responseBuilder;

//    @PostMapping("/transaction-user")
//    public ResponseEntity<ResponseStructure<TransactionResponse>> addUserTransaction(@RequestBody TransactionRequest transactionRequest){
//        TransactionResponse transactionResponse = transactionService.addUserTransaction(transactionRequest);
//        return responseBuilder.success(HttpStatus.CREATED, "User Transaction Created", transactionResponse);
//    }
//
//    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN') || hasAnyAuthority('GUEST_ADMIN')")
//    @PostMapping("/transaction-hospital")
//    public ResponseEntity<ResponseStructure<TransactionResponse>> addHospitalTransaction(@RequestBody TransactionRequest transactionRequest, @PathVariable int hospitalId){
//        TransactionResponse transactionResponse = transactionService.addHospitalTransaction(transactionRequest, hospitalId);
//        return responseBuilder.success(HttpStatus.CREATED, "Hospital Transaction Created", transactionResponse);
//    }

    @PreAuthorize("hasAnyAuthority('OWNER_ADMIN') || hasAnyAuthority('GUEST_ADMIN')")
    @PostMapping("/transactions/{hospitalId}/{userId}")
    public ResponseEntity<ResponseStructure<TransactionResponse>> checkTransaction(@RequestBody TransactionRequest transactionRequest, @PathVariable int hospitalId, @PathVariable int userId) throws Exception {
        TransactionResponse transactionResponse = transactionService.checkTransaction(transactionRequest, hospitalId, userId);
        return responseBuilder.success(HttpStatus.CREATED, "Transaction Successful", transactionResponse);
    }

}