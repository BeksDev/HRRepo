package com.example.hr.userprofile.AditionalFunction;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class AditionalFunctionRequest {
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
