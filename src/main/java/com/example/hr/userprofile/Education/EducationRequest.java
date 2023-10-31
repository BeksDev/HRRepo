package com.example.hr.userprofile.Education;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
@Getter
@Setter
public class EducationRequest {
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
