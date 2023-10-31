package com.example.hr.MFA;

import com.example.hr.MFA.RepresentationAbroad.RepresentationAbroad;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "mfa")
public class Mfa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private Integer parentId;
//    private Integer type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "representation_abroad_id")
    private RepresentationAbroad representationAbroad;
}
