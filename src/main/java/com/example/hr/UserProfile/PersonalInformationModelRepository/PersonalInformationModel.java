package com.example.hr.UserProfile.PersonalInformationModelRepository;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personalInformation")
public class PersonalInformationModel {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer image;
    private Integer idNumber;
    private Integer combo;
    private String name;
    private String lastName;
    private String displayName;
    private String displayNameEng;
    private Date dateOfBirth;
    private Integer age;
    private String gender;
    private String maritalStatus;
    private String residency;
    private String citizenship;
    private String birthCountry;
    private String birthPlace;
    private Integer officeId;
    private String roomNumber;
    private String homePhoneNumber;
    private String workPhoneNumber;
    private String fax;
    private String mobile;
    private String workEmail;
    private String personalEmail;
    private String emergencyContact;
    private String webAddress;
    private Timestamp timeStamp;
    private String changeUserId;
}
