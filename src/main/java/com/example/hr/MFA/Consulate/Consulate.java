package com.example.hr.MFA.Consulate;

import com.example.hr.MFA.Mfa;
import com.example.hr.MFA.RepresentationAbroad.RepresentationAbroad;
import com.example.hr.Organization.OrganizationModel;
import com.example.hr.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "consulate")
public class Consulate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
//    @ManyToOne
//    @JoinColumn(name = "representation_abroad_id") // Adjust the column name accordingly
//    private RepresentationAbroad representationAbroad;
    @JsonIgnore
    public RepresentationAbroad getRepresentationAbroad() {
        return new RepresentationAbroad();
    }
//    @OneToOne
//    private OrganizationModel organizationModel;

//    public RepresentationAbroad getRepresentationAbroad() {
//        return null;
//    }


//    @ManyToMany
//    private Set<RepresentationAbroad> representationAbroad;
}
