package com.example.hr.userprofile.Discipline;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class DisciplineRequest {
    private String disciplineMeasure;

    @Column(name = "start_date")
    private Date start;

    @Column(name = "end_date")
    private Date end;

    @Column(name = "is_in_force_or_not_valid")
    private String isInForceOrNotValid;

    @Column(name = "from_value")
    private String from;  // Changed the field name

    private String employer;
    private String basedOn;
    private String attachment;

    @Column(name = "timestamp_value")
    private Timestamp timestamp;  // Changed the field name

    @Column(name = "change_user_id")
    private Integer changeUserId;
}
