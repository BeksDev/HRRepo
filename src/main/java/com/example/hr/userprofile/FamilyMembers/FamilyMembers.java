package com.example.hr.userprofile.FamilyMembers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "familymembers")
public class FamilyMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer userPersonId;
    private String relationType;
    private Integer personId;
    private String nameSurName;
    private String nameSurNameEng;
    private String citizenship;
    private Date dateOfBirth;
    private String dependent;
    private Integer mobilePhone;
    private String registrationAddress;
    private String currentActivityOccupation;
    private Timestamp Date;
    private String stateStatus;
    private Integer changeUserId;
}
