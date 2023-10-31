 package com.example.hr.Organization;

 // import java.util.List;

 import jakarta.persistence.*;
 // import jakarta.persistence.FetchType;
 // import jakarta.persistence.OneToMany;
 import lombok.*;

 @Data
 @Builder
 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor
 @Entity
 @Table(name = "organization")
 public class OrganizationModel {
    
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer Id;
     private Integer Organization_Id;
     private String Organization_Name;
     private String Govermental_Type;
     private String Organization_Type;
     private String Organization_Form;
     private String Subordination;
     private String Head_Organization_Name;
     private String Head_Of_Organization_Position;
     private String Acting_Based;
     private Integer Tax_Payer_Id;
     private Integer Official_Contact;
     private Integer Official_Contact_Position;
     private String Main_Office_Address;
     private Integer Call_Center;
     private Integer Fax;
     private String Email;
     private String Logo;
     private String Web_site;


 }
