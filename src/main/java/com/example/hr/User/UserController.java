// package com.example.hr.User;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.hr.UserProfile.UserProfile;
// import com.example.hr.UserProfile.UserProfileRepository;

// @RestController
// @RequestMapping("/users")
// public class UserController {

//     private final UserRepository userRepository;

//     @Autowired
//     public UserController(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }
//     @Autowired
//     private UserProfileRepository userProfileRepository;

//     @GetMapping("/{userId}")
//     @PreAuthorize("hasAuthority('admin:read')")
//     public User getUserById(@PathVariable Integer userId) {
//         // Retrieve the user by ID from the repository
//         Optional<User> userOptional = userRepository.findById(userId);

//         if (userOptional.isPresent()) {
//             return userOptional.get();
//         }
//         return null; 
//     }


//     @PostMapping("/{userId}/profile")
//     @PreAuthorize("hasAuthority('admin:create')")
//     public ResponseEntity<String> createUserProfile(
//             @PathVariable Integer userId,
//             @RequestBody UserProfile userProfile) {

//         // Find the user by ID
//         User user = userRepository.findById(userId).orElse(null);

//         if (user != null) {
//             userProfile.setUser(user); // Associate UserProfile with User
//             userProfileRepository.save(userProfile); // Save the UserProfile
//             return ResponseEntity.ok("UserProfile created successfully.");
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

    
// }
