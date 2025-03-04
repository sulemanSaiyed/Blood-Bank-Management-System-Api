package Blood_Bank_Management_Api.BBM.utility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResponseStructure<T> {
  private int status;
  private String message;
  private T data;
 // commenting because now  restrespinsebuilder will handles both error structre and response structre
//  public static<T> ResponseStructure <T> create(int status, String message, T data){
//    ResponseStructure<T> structure= new ResponseStructure<T>();
//
//    structure.setStatus(status);
//    structure.setMessage(message);
//
//    structure.setData(data);
//    return structure;
    }

