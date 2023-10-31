package com.example.hr.userprofile;


import com.example.hr.userprofile.Address.Address;
import com.example.hr.userprofile.Address.AddressRequest;
import com.example.hr.userprofile.AditionalFunction.AditionalFunction;
import com.example.hr.userprofile.Career.Career;
import com.example.hr.userprofile.Discipline.Discipline;
import com.example.hr.userprofile.Documents.Documents;
import com.example.hr.userprofile.Education.Education;
import com.example.hr.userprofile.Ewards.Ewards;
import com.example.hr.userprofile.FamilyMembers.FamilyMembers;
import com.example.hr.userprofile.HealthInsurence.HealthInsurence;
import com.example.hr.userprofile.Passport.Passports;
import com.example.hr.userprofile.PersonalInfo.PersonalInfo;
import com.example.hr.userprofile.Rank.Rank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileRequest {
    private PersonalInfo personalInfo;
    private FamilyMembers familyMembers;
    private AditionalFunction aditionalFunction;
    private Address address;
    private Career career;
    private Education education;
    private Ewards ewards;
    private Rank rank;
    private Discipline discipline;
    private Documents documents;
    private Passports passports;
    private HealthInsurence healthInsurence;
}
