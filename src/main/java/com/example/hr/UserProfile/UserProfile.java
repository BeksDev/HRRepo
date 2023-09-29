package com.example.hr.UserProfile;

import com.example.hr.User.User;
import com.example.hr.UserProfile.AdditionalFunctionModelRepository.AdditionalFunctionModel;
import com.example.hr.UserProfile.CareerModelRepository.CareerModel;
import com.example.hr.UserProfile.PersonalInformationModelRepository.PersonalInformationModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userProfileDetails")
public class UserProfile {
    

    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personalinfo_id")
    private PersonalInformationModel personalInfo;
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
    @OneToOne()
    private User user;
    private String Education;
    private String Ranks;
    private String AwardsAndCourarguments;
    private String Disciple;
    private String Documents;
    private String Passports;
    private String HealthAndInsurence;


    public UserProfile(UserProfileRequestModel userProfileRequestModel) {
        this.setPersonalInfo(userProfileRequestModel.getPersonalInfo());
        this.setFamilyMembers(userProfileRequestModel.getFamilyMembers());
        this.setAddresses(userProfileRequestModel.getAddresses());
        this.setCareer(userProfileRequestModel.getCareer());
        this.setAdditionalFunctions(userProfileRequestModel.getAdditionalFunctions());
        this.setEducation(userProfileRequestModel.getEducation());
        this.setRanks(userProfileRequestModel.getRanks());
        this.setAwardsAndCourarguments(userProfileRequestModel.getAwardsAndCourarguments());
        this.setDisciple(userProfileRequestModel.getDisciple());
        this.setDocuments(userProfileRequestModel.getDocuments());
        this.setPassports(userProfileRequestModel.getPassports());
        this.setHealthAndInsurence(userProfileRequestModel.getHealthAndInsurence());

    }


    public void setFirstName(Object firstName) {
    }


    public void setLastName(Object lastName) {
    }


    public void setAddress(Object address) {
    }


    public void setPhoneNumber(Object phoneNumber) {
    }




    //  // Getter methods
    //  public Integer getId() {
    //     return id;
    // }

    // public String getPersonalInfo() {
    //     return PersonalInfo;
    // }

    // public String getFamilyMembers() {
    //     return FamilyMembers;
    // }

    // // Setter methods
    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // public void setPersonalInfo(String personalInfo) {
    //     PersonalInfo = personalInfo;
    // }

    // public void setFamilyMembers(String familyMembers) {
    //     FamilyMembers = familyMembers;
    // }

    // public String getCareer() {
    //     return Career;
    // }

    // public String getAdditionalFunctions() {
    //     return AdditionalFunctions;
    // }

    // public String getEducation() {
    //     return Education;
    // }

    // public String getRanks() {
    //     return Ranks;
    // }

    // public String getAwardsAndCourarguments() {
    //     return AwardsAndCourarguments;
    // }

    // public String getDisciple() {
    //     return Disciple;
    // }

    // public String getDocuments() {
    //     return Documents;
    // }

    // public String getPassports() {
    //     return Passports;
    // }

    // public String getHealthAndInsurence() {
    //     return HealthAndInsurence;
    // }

    // // Setter methods
    // public void setAddresses(String addresses) {
    //     Addresses = addresses;
    // }

    // public void setCareer(String career) {
    //     Career = career;
    // }

    // public void setAdditionalFunctions(String additionalFunctions) {
    //     AdditionalFunctions = additionalFunctions;
    // }

    // public void setEducation(String education) {
    //     Education = education;
    // }

    // public void setRanks(String ranks) {
    //     Ranks = ranks;
    // }

    // public void setAwardsAndCourarguments(String awardsAndCourarguments) {
    //     AwardsAndCourarguments = awardsAndCourarguments;
    // }

    // public void setDisciple(String disciple) {
    //     Disciple = disciple;
    // }

    // public void setDocuments(String documents) {
    //     Documents = documents;
    // }

    // public void setPassports(String passports) {
    //     Passports = passports;
    // }

    // public void setHealthAndInsurence(String healthAndInsurence) {
    //     HealthAndInsurence = healthAndInsurence;
    // }
}
