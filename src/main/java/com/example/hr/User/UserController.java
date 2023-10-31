package com.example.hr.User;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Users")
@RequestMapping("/api/mfa/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){this.userRepository = userRepository;}


//    @GetMapping("/get")
//    @PreAuthorize("hasAuthority('admin:read')")
//    public ResponseEntity<List<User>> retrieveAllUsers() {
//        try {
//            List<User> users = userRepository.findAll();
//            return ResponseEntity.ok(users);
//        } catch (Exception e) {
//            // Handle exceptions and return an error response
//            return null;
//        }
//    }

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('admin:read')")
    public Page<User> retrieveAllUsers(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) //@RequestParam(defaultValue = "id") String sortBy
                                  {
        Pageable pageable = PageRequest.of(page, size);   //, Sort.by(sortBy)
        return userRepository.findAll(pageable);
    }

    @GetMapping("/get/byid")
    @PreAuthorize("hasAuthority('admin:read')")
    public Optional<User> searchById(@RequestParam("by:id") Integer id) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional == null && userOptional.isEmpty()) throw new UsernameNotFoundException(String.format("Not Found User WIth Id %s", id));
        return userOptional;
    }
}
