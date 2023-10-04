package com.example.hr.userprofile;

import com.example.hr.User.User;
import com.example.hr.userprofile.PersonalInfo.PersonalInfo;
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
    @GeneratedValue
    private Integer Id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_personalinfo_id")
    private PersonalInfo personalInfo;


//    private String lastName;
//    private String workName;
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;


    public UserProfile(UserProfileRequest userProfileRequestModel) {
          this.setPersonalInfo(userProfileRequestModel.getPersonalInfo());
//        this.setFirstName(userProfileRequestModel.getFirstName());
//        this.setLastName(userProfileRequestModel.getLastName());
//        this.setWorkName(userProfileRequestModel.getWorkName());
    }


}
