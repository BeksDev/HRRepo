package com.example.hr.userprofile.HealthInsurence;

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
@Entity(name = "insurace")
@Table
public class HealthInsurence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personId;
    private String insuranceCompanyId;
    private String insurancePersonNameSurName;
    private String pack;
    private String policy;
    private String card;
    private Integer costComplete;
    private Integer costOrganization;
    private Integer costEmployee;
    private Date startDateInfo;
    private Date endDateInfo;
    private String fileAttach;
    private Timestamp timestamp;
    private Integer personUserId;
}
