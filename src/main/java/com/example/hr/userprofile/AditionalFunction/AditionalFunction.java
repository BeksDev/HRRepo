package com.example.hr.userprofile.AditionalFunction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "aditionalfunction")
public class AditionalFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personID;
    private Integer appointmentID;
    private Integer functionID;
    private String functionName;
    private String functionNameEng;
    private String functionPriority;
    private Date startDateValue;
    private Date endDateValue;
    private String report;
    private Boolean status;
    private Timestamp timeStampValue;
    private String stateStatus;
    private Integer changeUserID;
}
