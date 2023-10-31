package com.example.hr.userprofile.Rank;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class RankRequest {
    private String educationType;
    private String institution;
    private String faculty;
    private String specialization;
    private String academicDegree;
    private String qualification;
    private Integer diplomaId;

    //    @Column(name = "start_date")
    private Date startDateValue;

    //    @Column(name = "end_date")
    private Date endDateValue;

    private String attachFile;

    //    @Column(name = "timestamp_value")
    private Timestamp timestamp;

    @Column(name = "change_user_id")
    private Integer changeUserId;
}
