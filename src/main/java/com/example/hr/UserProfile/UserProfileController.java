package com.example.hr.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr.User.User;
import com.example.hr.User.UserRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

// import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "UserProfile")
@RequestMapping("/api/mfa/userprofile")
public class UserProfileController {
    // private final UserProfileRepository userProfileRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserProfileController(UserProfileRepository userProfileRepository, UserRepository userRepository) {
        // this.userProfileRepository = userProfileRepository;
        this.userRepository = userRepository;

    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<User> createUserProfile(@RequestParam("user:id") Integer id,  @RequestBody UserProfileRequestModel profileData) {

        Optional<User> user = userRepository.findById(id);

        if (user == null && user.isEmpty() ) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        // if (!user.isPresent()) {
        //     return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        // }


        UserProfile userProfile = new UserProfile(profileData);
        user.get().setUserProfile(userProfile);
        // user.get().setToken(null);


        userRepository.save(user.get());

        // return new ResponseEntity<>(user.get(), HttpStatus.OK);

       
        return new ResponseEntity<>(user.get(), HttpStatus.CREATED);
    }

    @GetMapping("/get/user/profiles")
    @PreAuthorize("hasAuthority('admin:read')") // Add appropriate authorization
    public ResponseEntity<List<User>> getUserProfiles() {
        List<User> userProfiles = userRepository.findAll(); // Fetch all user profiles
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

}
