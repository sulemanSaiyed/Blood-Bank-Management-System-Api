package Blood_Bank_Management_Api.BBM.Response;

import Blood_Bank_Management_Api.BBM.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {

    private int adminId;
    private User user;
}
