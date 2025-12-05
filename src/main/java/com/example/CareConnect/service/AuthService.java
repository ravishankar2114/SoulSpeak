package com.example.CareConnect.service;



import com.example.CareConnect.dto.SignupRequest;
import com.example.CareConnect.model.User;
import com.example.CareConnect.repository.UserRepository;
import com.example.CareConnect.util.JwtUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtils jwtUtils;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(SignupRequest req) {
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already used");
        }
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setRole(req.getRole() == null ? "STAFF" : req.getRole().toUpperCase());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        userRepo.save(u);
        return "User registered";
    }

    public String login(String email, String password) {
        Optional<User> o = userRepo.findByEmail(email);
        if (o.isEmpty()) throw new RuntimeException("User not found");
        User u = o.get();
        if (!passwordEncoder.matches(password, u.getPassword())) throw new RuntimeException("Invalid credentials");
        return jwtUtils.generateToken(u.getId().toString(), u.getRole());
    }
}
