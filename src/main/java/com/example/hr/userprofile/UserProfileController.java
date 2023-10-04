package com.example.hr.userprofile;

import com.example.hr.User.User;
import com.example.hr.User.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.Optional;

@RestController
@Tag(name = "UserProfile")
@RequestMapping("/api/mfa/userprofile")
public class UserProfileController {
    private final UserRepository userRepository;

    private UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('admin:create')")
    public UserProfile createUserProfile(@RequestParam("user:id") Integer id, @RequestBody UserProfileRequest profileData) throws UsernameNotFoundException, InstanceAlreadyExistsException {
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional == null && userOptional.isEmpty()) throw new UsernameNotFoundException(String.format("Not Found User With Id %s", id));

        User user = userOptional.get();

        if (user.getUserProfile() != null) { throw new InstanceAlreadyExistsException("user has already profile"); }


        UserProfile userProfile = new UserProfile(profileData);
//        userProfile.setUser(user);
        user.setUserProfile(userProfile);

        userProfileRepository.save(userProfile);
        userRepository.save(user);

//        return new ResponseEntity<>(user, HttpStatus.CREATED);
        return userProfile;
    }


    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
}
