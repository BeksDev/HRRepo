package com.example.hr.userprofile.HealthInsurence;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class HealthInsurenceRequest {
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
