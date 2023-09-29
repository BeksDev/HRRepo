package com.example.hr.UserProfile;

// import com.example.hr.User.User;
import com.example.hr.UserProfile.AdditionalFunctionModelRepository.AdditionalFunctionModel;
import com.example.hr.UserProfile.CareerModelRepository.CareerModel;
import com.example.hr.UserProfile.PersonalInformationModelRepository.PersonalInformationModel;

import jakarta.persistence.CascadeType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileRequestModel {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personalinfo_id")
    private PersonalInformationModel PersonalInfo;
    private String FamilyMembers;

    //address_add_id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private AddressModel Addresses;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_career_id")
    private CareerModel Career;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_additonalFUnction_id")
    private AdditionalFunctionModel AdditionalFunctions;
    // @OneToOne()
    private String Education;
    private String Ranks;
    private String AwardsAndCourarguments;
    private String Disciple;
    private String Documents;
    private String Passports;
    private String HealthAndInsurence;
    public Object getFirstName() {
        return null;
    }
    public Object getLastName() {
        return null;
    }
    public Object getAddress() {
        return null;
    }
    public Object getPhoneNumber() {
        return null;
    }
}
