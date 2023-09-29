package com.example.hr.UserProfile.AdditionalFunctionModelRepository;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EditionalFunction")
public class AdditionalFunctionModel {
    @Id
    @GeneratedValue
    private Integer PersonID;
    private Integer AppointmentID;
    private Integer FunctionID;
    private String FunctionName;
    private String FunctionNameEng;
    private String FunctionPriority;
    private Date StartDate;
    private Date Enddate;
    private String Reportto;
    private boolean Status;
    private Timestamp timeStamp;
    private String StateStatus;
    private Integer ChangeUserID;
}
