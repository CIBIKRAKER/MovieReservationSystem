package org.example.moviereservationsystem.service;

import org.example.moviereservationsystem.exception.EmailNotFoundException;
import org.example.moviereservationsystem.model.User;
import org.example.moviereservationsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException("Email not found!"));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPasswordHash()) // the BCrypt hash from the database
                .authorities(user.getRole().name())
                .build();
    }
}
