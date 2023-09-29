package com.example.hr.Organization;

// import java.util.List;

import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
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
@Table(name = "organization")
public class OrganizationModel {
    
    @Id
    @GeneratedValue
    private Integer Id;
    private Integer Organization_Id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private OrganizationModel parent;

    // @OneToMany(mappedBy = "parent", orphanRemoval = true, fetch = FetchType.EAGER)
    // private List<OrganizationModel> children;

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

     // Getter and Setter methods for Id
     public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    // Getter and Setter methods for Organization_Id
    public Integer getOrganization_Id() {
        return Organization_Id;
    }

    public void setOrganization_Id(Integer Organization_Id) {
        this.Organization_Id = Organization_Id;
    }

    // Getter and Setter methods for Organization_Name
    public String getOrganization_Name() {
        return Organization_Name;
    }

    public void setOrganization_Name(String Organization_Name) {
        this.Organization_Name = Organization_Name;
    }

    // Getter and Setter methods for Govermental_Type
    public String getGovermental_Type() {
        return Govermental_Type;
    }

    public void setGovermental_Type(String Govermental_Type) {
        this.Govermental_Type = Govermental_Type;
    }

    // Getter and Setter methods for Organization_Type
    public String getOrganization_Type() {
        return Organization_Type;
    }

    public void setOrganization_Type(String Organization_Type) {
        this.Organization_Type = Organization_Type;
    }

    // Getter and Setter methods for Organization_Form
    public String getOrganization_Form() {
        return Organization_Form;
    }

    public void setOrganization_Form(String Organization_Form) {
        this.Organization_Form = Organization_Form;
    }

    // Getter and Setter methods for Subordination
    public String getSubordination() {
        return Subordination;
    }

    public void setSubordination(String Subordination) {
        this.Subordination = Subordination;
    }

    // Getter and Setter methods for Head_Organization_Name
    public String getHead_Organization_Name() {
        return Head_Organization_Name;
    }

    public void setHead_Organization_Name(String Head_Organization_Name) {
        this.Head_Organization_Name = Head_Organization_Name;
    }

    // Getter and Setter methods for Head_Of_Organization_Position
    public String getHead_Of_Organization_Position() {
        return Head_Of_Organization_Position;
    }

    public void setHead_Of_Organization_Position(String Head_Of_Organization_Position) {
        this.Head_Of_Organization_Position = Head_Of_Organization_Position;
    }

    // Getter and Setter methods for Acting_Based
    public String getActing_Based() {
        return Acting_Based;
    }

    public void setActing_Based(String Acting_Based) {
        this.Acting_Based = Acting_Based;
    }

    // Getter and Setter methods for Tax_Payer_Id
    public Integer getTax_Payer_Id() {
        return Tax_Payer_Id;
    }

    public void setTax_Payer_Id(Integer Tax_Payer_Id) {
        this.Tax_Payer_Id = Tax_Payer_Id;
    }

    // Getter and Setter methods for Official_Contact
    public Integer getOfficial_Contact() {
        return Official_Contact;
    }

    public void setOfficial_Contact(Integer Official_Contact) {
        this.Official_Contact = Official_Contact;
    }

    // Getter and Setter methods for Official_Contact_Position
    public Integer getOfficial_Contact_Position() {
        return Official_Contact_Position;
    }

    public void setOfficial_Contact_Position(Integer Official_Contact_Position) {
        this.Official_Contact_Position = Official_Contact_Position;
    }

    // Getter and Setter methods for Main_Office_Address
    public String getMain_Office_Address() {
        return Main_Office_Address;
    }

    public void setMain_Office_Address(String Main_Office_Address) {
        this.Main_Office_Address = Main_Office_Address;
    }

    // Getter and Setter methods for Call_Center
    public Integer getCall_Center() {
        return Call_Center;
    }

    public void setCall_Center(Integer Call_Center) {
        this.Call_Center = Call_Center;
    }

    // Getter and Setter methods for Fax
    public Integer getFax() {
        return Fax;
    }

    public void setFax(Integer Fax) {
        this.Fax = Fax;
    }

    // Getter and Setter methods for Email
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    // Getter and Setter methods for Logo
    public String getLogo() {
        return Logo;
    }

    public void setLogo(String Logo) {
        this.Logo = Logo;
    }

    // Getter and Setter methods for Web_site
    public String getWeb_site() {
        return Web_site;
    }

    public void setWeb_site(String Web_site) {
        this.Web_site = Web_site;
    }

}
