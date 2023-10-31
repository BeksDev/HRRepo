package com.example.hr.userprofile.Ewards;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class EwardsRequest {
    private String encouragementForm;
    private String encouragementType;
    private String description;
    private Date date;
    private String employer;
    private String basedOn;
    private String attachment;
    private Timestamp timestamp;
    private Integer changeUserId;
}
