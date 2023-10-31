package com.example.hr.MFA.Embassy;

import com.example.hr.MFA.Mfa;
import com.example.hr.MFA.RepresentationAbroad.RepresentationAbroad;
import com.example.hr.Organization.OrganizationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "embassy")
public class Embassy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonIgnore
    public RepresentationAbroad getRepresentationAbroad() {
        return new RepresentationAbroad();
    }
//    public RepresentationAbroad getRepresentationAbroad() {
//        return new RepresentationAbroad();
//    }
//    @OneToOne
//    private OrganizationModel organizationModel;

//    @ManyToOne
//    private RepresentationAbroad representationAbroad;
}
