package com.example.hr.userprofile;

import com.example.hr.User.User;
import com.example.hr.User.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
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
        user.setUserProfile(userProfile);

        userProfileRepository.save(userProfile);
        userRepository.save(user);

        return userProfile;
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    public ResponseEntity<UserProfile> updateUserProfile(
            @PathVariable Integer id,
            @RequestBody UserProfileRequest profileData) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();

        if (user.getUserProfile() == null) {
            return ResponseEntity.notFound().build();
        }

        UserProfile userProfile = user.getUserProfile();

        userProfile.setCareer(profileData.getCareer());
        userProfile.setFamilyMember(profileData.getFamilyMembers());
        userProfile.setPersonalInfo(profileData.getPersonalInfo());
        userProfile.setAddress(profileData.getAddress());
        userProfile.setEducationl(profileData.getEducation());
        userProfile.setRank(profileData.getRank());
        userProfile.setDiscipline(profileData.getDiscipline());
        userProfile.setAditionalFunction(profileData.getAditionalFunction());
        userProfile.setEwards(profileData.getEwards());
        userProfile.setDiscipline(profileData.getDiscipline());
        userProfile.setDocuments(profileData.getDocuments());
        userProfile.setPassports(profileData.getPassports());
        userProfile.setHealthInsurence(profileData.getHealthInsurence());


        userProfileRepository.save(userProfile);

        return ResponseEntity.ok(userProfile);
    }


    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
}
