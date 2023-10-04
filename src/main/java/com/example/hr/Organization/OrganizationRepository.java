 package com.example.hr.Organization;

 // import java.util.Optional;

 import org.springframework.data.jpa.repository.JpaRepository;

 public interface OrganizationRepository extends JpaRepository<OrganizationModel, Integer> {
     // Optional<OrganizationModel> findByEmail(Integer id);
 }