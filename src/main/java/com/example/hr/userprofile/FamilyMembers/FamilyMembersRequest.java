package com.example.hr.userprofile.FamilyMembers;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class FamilyMembersRequest {
    private String relationType;
    private Integer personId;
    private String nameSurName;
    private String nameSurNameEng;
    private String citizenship;
    private java.sql.Date dateOfBirth;
    private String dependent;
    private Integer mobilePhone;
    private String registrationAddress;
    private String currentActivityOccupation;
    private Timestamp Date;
    private String stateStatus;
    private Integer changeUserId;
}
