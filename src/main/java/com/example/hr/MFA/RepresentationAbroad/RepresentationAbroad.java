package com.example.hr.MFA.RepresentationAbroad;

import com.example.hr.MFA.Consulate.Consulate;
import com.example.hr.MFA.Embassy.Embassy;
import com.example.hr.MFA.Mfa;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "representanion_abroad")
public class RepresentationAbroad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Embassy> embassy = new HashSet<>();
    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Consulate> consulates = new HashSet<>();
}
