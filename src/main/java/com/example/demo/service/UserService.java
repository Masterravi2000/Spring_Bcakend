package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    public String register(RegisterRequest req) {
        try {
            if (userRepo.findByEmail(req.getEmail()) != null) {
                return "Email already exists";
            }

            User user = new User();
            // user.setProfilePic(req.getProfilePic());
            user.setFirstName(req.getFirstName());
            user.setLastName(req.getLastName());
            user.setEmail(req.getEmail());
            user.setPassword(encoder.encode(req.getPassword()));

            userRepo.save(user);
            return "User registered successfully";

        } catch (Exception e) {
            e.printStackTrace();
            return "Registration failed. Try again.";
        }
    }

    public String login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail());
        if (user == null)
            return "User not found";

        // IMPORTANT: use encoder.matches()
        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            return "Incorrect password";
        }

        return "Login successful";
    }

    // get user data
    public UserResponse getUserByEmail(String email) {
        User user = userRepo.findByEmail(email);
        if (user == null)
            return null;

        UserResponse response = new UserResponse();
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());

        return response;
    }
}
