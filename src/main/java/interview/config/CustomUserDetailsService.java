package interview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import interview.entity.User;
import interview.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

    	System.out.println("Entered Username = " + username);
    	
        User user = repository.findByUsername(username)
                .orElseThrow(() ->
                new UsernameNotFoundException("User Not Found"));
        
        System.out.println("User Found = " + user.getUsername());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

}
