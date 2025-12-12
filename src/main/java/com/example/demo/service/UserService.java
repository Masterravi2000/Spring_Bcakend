package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(RegisterRequest req) {

        if (userRepo.findByEmail(req.getEmail()) != null) {
            return "Email already exists";
        }

        User user = new User();
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setEmail(req.getEmail());
        user.setPassword(encoder.encode(req.getPassword()));  // hashing

        userRepo.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail());
        if (user == null) return "User not found";

        // IMPORTANT: use encoder.matches()
        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            return "Incorrect password";
        }

        return "Login successful";
    }
}
