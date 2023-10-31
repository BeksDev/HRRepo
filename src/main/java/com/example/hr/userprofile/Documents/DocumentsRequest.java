package com.example.hr.userprofile.Documents;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class DocumentsRequest {
    private String owner;
    private String documentType;
    private String documentName;
    private String issuerOrganization;
    private String attachment;
    private Timestamp time;
    private String stateStatus;
    private Integer changeUserId;
}
