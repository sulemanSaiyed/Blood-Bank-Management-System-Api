package Blood_Bank_Management_Api.BBM.Security;

import Blood_Bank_Management_Api.BBM.entity.Admin;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.repository.AdminRepositry;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthUtil {
    private final UserRepository userRepository;
    private final AdminRepositry adminRepository;

    public String getCurrentUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();

    }
    public User getCurrentUser(){
        return userRepository.findByEmail(this.getCurrentUserName())
                .orElseThrow(()->new UsernameNotFoundException("failed r=to find to user"));

    }
    public Admin getCurrentAdmin() throws Exception{
        return adminRepository.findByUser_Email(this.getCurrentUserName())
                .orElseThrow(()-> new UsernameNotFoundException("Failed to authenticate"));
    }
}
