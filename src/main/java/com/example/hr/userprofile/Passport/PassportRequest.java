package com.example.hr.userprofile.Passport;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Setter
@Getter
public class PassportRequest {
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
