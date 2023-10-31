package com.example.hr.userprofile.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
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
}
