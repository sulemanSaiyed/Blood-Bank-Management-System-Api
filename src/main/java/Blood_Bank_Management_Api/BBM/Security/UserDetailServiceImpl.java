package Blood_Bank_Management_Api.BBM.Security;

import Blood_Bank_Management_Api.BBM.Exception.BloodBankNotFoundByIDException;
import Blood_Bank_Management_Api.BBM.entity.User;
import Blood_Bank_Management_Api.BBM.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService{

private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= userRepository.findByEmail(username).orElseThrow(()-> new BloodBankNotFoundByIDException("failed to find the user"));


        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().name()) //updating userDetailServiceImpl class give authorities to user to access the data based on their roles accordingly
                .build();
    }
}


