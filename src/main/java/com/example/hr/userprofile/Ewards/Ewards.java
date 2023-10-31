package com.example.hr.userprofile.Ewards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ewards")
public class Ewards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personId;
    private String encouragementForm;
    private String encouragementType;
    private String description;
    private Date date;
    private String employer;
    private String basedOn;
    private String attachment;
    private Timestamp timestamp;
    private Integer changeUserId;
}
