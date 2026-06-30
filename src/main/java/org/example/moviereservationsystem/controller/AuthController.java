package org.example.moviereservationsystem.controller;

import org.example.moviereservationsystem.DTO.AuthResponse;
import org.example.moviereservationsystem.DTO.LoginRequest;
import org.example.moviereservationsystem.DTO.RegisterRequest;
import org.example.moviereservationsystem.model.Role;
import org.example.moviereservationsystem.model.User;
import org.example.moviereservationsystem.repository.UserRepository;
import org.example.moviereservationsystem.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.email(),
                        loginRequest.password()
                )
        );
        User user = userRepository.findByEmail(loginRequest.email()).orElseThrow();
        return new AuthResponse(jwtUtil.generateToken(user));
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {
        if(userRepository.findByEmail(registerRequest.email()).isPresent()) {
            return "User already exists";
        }

        Role role = Role.USER;

        User newUser = new User();
        newUser.setEmail(registerRequest.email());
        newUser.setPasswordHash(passwordEncoder.encode(registerRequest.password()));
        newUser.setName(registerRequest.name());
        newUser.setRole(role);
        userRepository.save(newUser);
        return "User registered successfully";
    }

}
