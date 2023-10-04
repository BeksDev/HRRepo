package com.example.hr.User;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Users")
@RequestMapping("/api/mfa/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){this.userRepository = userRepository;}


    @GetMapping("/get")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<User>> retrieveAllUsers() {
        try {
            List<User> users = userRepository.findAll();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return null;
        }
    }
}
