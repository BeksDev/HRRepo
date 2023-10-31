package com.example.hr.userprofile.Rank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "ranks")
@Table
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personId;

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

