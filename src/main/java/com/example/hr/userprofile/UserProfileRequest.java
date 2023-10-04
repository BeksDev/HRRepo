package com.example.hr.userprofile;


import com.example.hr.userprofile.PersonalInfo.PersonalInfo;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class UserProfileRequest {
    private PersonalInfo personalInfo;
}
