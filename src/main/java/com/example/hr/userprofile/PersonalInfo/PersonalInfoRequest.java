package com.example.hr.userprofile.PersonalInfo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class PersonalInfoRequest {
    private Integer image;
    private Integer idNumber;
    private Integer combo;
    private String name;
    private String lastName;
    private String displayName;
    private String displayNameEng;
    private Date dateOfBirth;
    private Integer age;
    private String gender;
    private String maritalStatus;
    private String residency;
    private String citizenship;
    private String birthCountry;
    private String birthPlace;
    private Integer officeId;
    private String roomNumber;
    private String homePhoneNumber;
    private String workPhoneNumber;
    private String fax;
    private String mobile;
    private String workEmail;
    private String personalEmail;
    private String emergencyContact;
    private String webAddress;
    private Timestamp timeStamp;
    private String changeUserId;
}
