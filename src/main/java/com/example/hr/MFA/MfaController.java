package com.example.hr.MFA;

import com.example.hr.MFA.Consulate.Consulate;
import com.example.hr.MFA.Consulate.ConsulateRepository;
import com.example.hr.MFA.Embassy.Embassy;
import com.example.hr.MFA.Embassy.EmbassyRepository;
import com.example.hr.MFA.RepresentationAbroad.AbroadRepository;
import com.example.hr.MFA.RepresentationAbroad.CreateRepresentationAbroadRequest;
import com.example.hr.MFA.RepresentationAbroad.RepresentationAbroad;
import com.example.hr.Organization.OrganizationModel;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Organization Tree")
@RequestMapping("/api/mfa/organization")
@PreAuthorize("hasRole('ADMIN')")
public class MfaController {
    private final MfaRepository mfaRepository;
    private final AbroadRepository abroadRepository;

    private final ConsulateRepository consulateRepository;
    private final EmbassyRepository embassyRepository;

    @Autowired MfaController(MfaRepository mfaRepository, AbroadRepository abroadRepository, ConsulateRepository consulateRepository, EmbassyRepository embassyRepository){
        this.mfaRepository = mfaRepository;
        this.abroadRepository = abroadRepository;
        this.consulateRepository = consulateRepository;
        this.embassyRepository = embassyRepository;
    }

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('admin:read')")
    public ResponseEntity<List<Mfa>> retriveAllTree(){
        try {
            List<Mfa> tree = mfaRepository.findAll();
            return ResponseEntity.ok(tree);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return null;
        }
    }

    @PostMapping("/create/mfa")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Mfa> createMfa(@RequestBody CreateMfaRequest request, @RequestParam("representation abroad:id") Integer representationAbroadId) {
        Mfa mfa = new Mfa();
        mfa.setName(request.getName());

        // Set the associated RepresentationAbroad
        RepresentationAbroad representationAbroad = abroadRepository.findById(representationAbroadId).orElse(null);
        mfa.setRepresentationAbroad(representationAbroad);

        Mfa createdMfa = mfaRepository.save(mfa);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdMfa);
    }

    @PostMapping("/create/representation/abroad")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<RepresentationAbroad> createRepresentation(@RequestBody CreateRepresentationAbroadRequest request) {
        // Create a new instance of RepresentationAbroad
        RepresentationAbroad representationAbroad = new RepresentationAbroad();

        // Set the name from the request to the representationAbroad
        representationAbroad.setName(request.getName());

        // Save the representationAbroad instance using the abroadRepository
        RepresentationAbroad createdRepresentation = abroadRepository.save(representationAbroad);

        // Return a ResponseEntity with HTTP status 201 (Created) and the createdRepresentation in the response body
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRepresentation);
    }
    @PostMapping("/create/consulate")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Consulate> createConsulate(@RequestBody Consulate request, @RequestParam("representationAbroadId") Integer representationAbroadId) {
        try {
            // Create a new Consulate instance
            Consulate consulate = new Consulate();
            consulate.setName(request.getName());

            // Find the RepresentationAbroad using its ID
            RepresentationAbroad representationAbroad = abroadRepository.findById(representationAbroadId)
                    .orElseThrow(() -> new EntityNotFoundException("RepresentationAbroad not found with ID: " + representationAbroadId));

            // Add the Consulate to the RepresentationAbroad's set of consulates
            representationAbroad.getConsulates().add(consulate);

            // Save the Consulate and the updated RepresentationAbroad
            Consulate createdConsulate = consulateRepository.save(consulate);
            abroadRepository.save(representationAbroad);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdConsulate);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/create/embassy")
    @PreAuthorize("hasAuthority('admin:create')")
    public ResponseEntity<Embassy> createEmbassy(@RequestBody Embassy request, @RequestParam("representationAbroadId") Integer representationAbroadId) {
        try {
            // Create a new Consulate instance
            Embassy embassy = new Embassy();
            embassy.setName(request.getName());

            // Find the RepresentationAbroad using its ID
            RepresentationAbroad representationAbroad = abroadRepository.findById(representationAbroadId)
                    .orElseThrow(() -> new EntityNotFoundException("RepresentationAbroad not found with ID: " + representationAbroadId));

            // Add the Consulate to the RepresentationAbroad's set of consulates
            representationAbroad.getEmbassy().add(embassy);

            // Save the Consulate and the updated RepresentationAbroad
            Embassy createdEmbassy = embassyRepository.save(embassy);
            abroadRepository.save(representationAbroad);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmbassy);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @DeleteMapping("/delete/consulate/{consulateId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<String> deleteConsulate(@PathVariable("consulateId") Integer consulateId) {
        try {
            // Find the Consulate using its ID
            Consulate consulate = consulateRepository.findById(consulateId)
                    .orElseThrow(() -> new EntityNotFoundException("Consulate not found with ID: " + consulateId));

            // Find the associated RepresentationAbroad
            RepresentationAbroad representationAbroad = consulate.getRepresentationAbroad();

            // Remove the Consulate from the RepresentationAbroad's set of consulates
            representationAbroad.getConsulates().remove(consulate);

            // Delete the Consulate
            consulateRepository.delete(consulate);

            // Save the updated RepresentationAbroad
            abroadRepository.save(representationAbroad);

            return ResponseEntity.ok("Consulate with ID " + consulateId + " deleted successfully.");
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the consulate.");
        }
    }





    @DeleteMapping("/delete/embassy/{embassyId}")
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<String> deleteEmbassy(@PathVariable("embassyId") Integer embassyId) {
        try {
            // Find the Embassy using its ID
            Embassy embassy = embassyRepository.findById(embassyId)
                    .orElseThrow(() -> new EntityNotFoundException("Embassy not found with ID: " + embassyId));

            // Find the associated RepresentationAbroad
            RepresentationAbroad representationAbroad = embassy.getRepresentationAbroad();

            // Remove the Embassy from the RepresentationAbroad's set of embassies
            representationAbroad.getEmbassy().remove(embassy);

            // Delete the Embassy
            embassyRepository.delete(embassy);

            // Save the updated RepresentationAbroad
            abroadRepository.save(representationAbroad);

            return ResponseEntity.ok("Embassy with ID " + embassyId + " deleted successfully.");
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting embassy with ID " + embassyId);
        }
    }



}