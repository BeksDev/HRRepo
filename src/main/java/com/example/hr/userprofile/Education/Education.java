package com.example.hr.userprofile.Education;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "education")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personalId;
    private String educationType;
    private String institution;
    private String faculty;
    private String specializationl;
    private String academicDegree;
    private String qualification;
    private Integer diplomaId;
    private Date startDate;
    private Date endDate;
    private String attachFile;
    private Timestamp timestamp;
    private Integer changeUserId;
}
