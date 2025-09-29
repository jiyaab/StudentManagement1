package com.iplus.studentManagement.Service;

import com.iplus.studentManagement.Repository.UserRepository;
import com.iplus.studentManagement.Entity.User; // <-- FIX: Add the import for the User Entity
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Collections;


@Service
// Assuming UserService extends/implements UserDetailsService for security configuration
public class UserServiceImpl implements UserService, UserDetailsService { 

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Example implementation of saveNewUser
    // Assuming this method is defined in the UserService interface
    public User saveNewUser(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); 
        user.setRole(role);
        
        return userRepository.save(user);
    }
    
    // Additional FIX: Must implement loadUserByUsername for UserDetailsService interface
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // Assuming this method exists in UserRepository
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        
        // This creates the UserDetails object required by Spring Security from your Entity.
        // Assuming your User entity has getUsername() and getPassword()
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList() // Simple authority list for demonstration; use actual roles/authorities
        );
    }
}