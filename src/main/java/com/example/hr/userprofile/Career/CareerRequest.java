package com.example.hr.userprofile.Career;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
@Getter
@Setter
public class CareerRequest {
    private String employer;
    private String organizationType;
    private String unit;
    private String positionName;
    private Date startDate;
    private Date endDate;
    private Boolean governmentalPosition;
    private String stateStatus;
    private Timestamp timestamp;
    private String changeUserId;
}
