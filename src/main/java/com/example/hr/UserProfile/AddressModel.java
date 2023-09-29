package com.example.hr.UserProfile;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@NoArgsConstructor
@Table(name = "address")
public class AddressModel {
    @Id
    @GeneratedValue
    @Column(name = "add_id")
    private Integer personId; 
    private String addressType; 
    private String country;
    private String region; 
    private String municipality; 
    private String cityOrVillage; 
    private String zipCode; 
    private String address;
    private Timestamp timeStamp;
    private Integer name;

    // public Long getAddressId() {
    //     return AddressId;
    // }

    // public String getCity() {
    //     return City;
    // }

    // public String getAddressType() {
    //     return AddressType;
    // }

    // // Setter methods
    // public void setAddressId(Long addressId) {
    //     AddressId = addressId;
    // }

    // public void setCity(String city) {
    //     City = city;
    // }

    // public void setAddressType(String addressType) {
    //     AddressType = addressType;
    // }
}
