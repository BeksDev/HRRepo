package com.example.hr.userprofile.Passport;

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
@Entity(name = "passports")
@Table
public class Passports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personId;
    private String passportType;
    private String passportDescription;
    private String owner;
    private String passportN;
    private String issuer;
    private Date issueDate;
    private Date expireDate;
    private String attachement;
    private Timestamp timestamp;
    private Integer changeUserId;
}
