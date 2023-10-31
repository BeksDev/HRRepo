package com.example.hr.userprofile;

import com.example.hr.userprofile.Address.Address;
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
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personalinfo_id")
    private PersonalInfo personalInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_familymember_id")
    private FamilyMembers familyMember;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_career_id")
    private Career career;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_aditionalfunction_id")
    private AditionalFunction aditionalFunction;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_education_id")
    private Education educationl;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ewards_id")
    private Ewards ewards;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_rank_id")
    private Rank rank;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_discipline_id")
    private Discipline discipline;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_documents_id")
    private Documents documents;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_passports_id")
    private Passports passports;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_insurance_id")
    private HealthInsurence healthInsurence;

    public UserProfile(UserProfileRequest userProfileRequestModel) {
          this.setPersonalInfo(userProfileRequestModel.getPersonalInfo());
          this.setFamilyMember(userProfileRequestModel.getFamilyMembers());
          this.setAditionalFunction(userProfileRequestModel.getAditionalFunction());
          this.setAddress(userProfileRequestModel.getAddress());
          this.setCareer(userProfileRequestModel.getCareer());
          this.setEducationl(userProfileRequestModel.getEducation());
          this.setEwards(userProfileRequestModel.getEwards());
          this.setRank(userProfileRequestModel.getRank());
          this.setDiscipline(userProfileRequestModel.getDiscipline());
          this.setDocuments(userProfileRequestModel.getDocuments());
          this.setPassports(userProfileRequestModel.getPassports());
          this.setHealthInsurence(userProfileRequestModel.getHealthInsurence());
    }
}
