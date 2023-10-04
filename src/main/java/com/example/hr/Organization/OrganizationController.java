 package com.example.hr.Organization;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.access.prepost.PreAuthorize;
 import org.springframework.web.bind.annotation.*;

 import io.swagger.v3.oas.annotations.tags.Tag;

 import java.util.List;

 @RestController
 @Tag(name = "OrgChart")
 @RequestMapping("/api/mfa/orgchart")
 public class OrganizationController {

     private final OrganizationRepository organizationRepository;

     @Autowired
     public OrganizationController(OrganizationRepository organizationRepository) {
         this.organizationRepository = organizationRepository;
     }

     @PostMapping("/create")
     @PreAuthorize("hasAuthority('admin:create')")
     public ResponseEntity<OrganizationModel> createOrganization(@RequestBody OrganizationModel organization) {
         // You can perform validation or other checks here
         OrganizationModel savedOrganization = organizationRepository.save(organization);
         return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
     }

     @GetMapping("/get")
     @PreAuthorize("hasAuthority('admin:read')")
     public ResponseEntity<List<OrganizationModel>> getAllOrganizations() {
         List<OrganizationModel> organizations = organizationRepository.findAll();
         return new ResponseEntity<>(organizations, HttpStatus.OK);
     }
 }
