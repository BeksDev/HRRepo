package com.example.hr.userprofile.Address;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Data
public class AddressRequest {
    private String addressType;
    private String country;
    private String region;
    private String municipality;
    private String cityOrVillage;
    private String zipCode;
    private String address;
    private Timestamp timeStamp;
    private Integer name;
}
