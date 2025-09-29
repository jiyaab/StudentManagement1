package com.iplus.studentManagement.Config;

// FIX: We need the standard Spring Security interface for the constructor
import org.springframework.security.core.userdetails.UserDetailsService; 
import com.iplus.studentManagement.Service.UserService; // Keep this import for context/reference

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // FIX 1: Change the field type to the standard UserDetailsService interface
    private final UserDetailsService userDetailsService;

    // FIX 2: Change the constructor parameter type to the standard UserDetailsService interface
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/signup/**").permitAll()
                         .requestMatchers("/login").permitAll()
                         .requestMatchers("/").permitAll()
                         .anyRequest().authenticated()
            )
            .formLogin(
                form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
            )
            .logout(
                logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .permitAll()
            )
            // The method name is now correct (userDetailsService) and the object being passed 
            // is guaranteed to be of the correct type (UserDetailsService).
            .userDetailsService(userDetailsService); 
        
        http.exceptionHandling(exceptions -> exceptions
            .accessDeniedHandler((request, response, accessDeniedException) -> {
                if (request.getRequestURI().equals("/login") && request.getUserPrincipal() != null) {
                    response.sendRedirect("/home");
                } else {
                    response.sendError(403, "Access Denied");
                }
            })
        );
        
        return http.build();
    }
}