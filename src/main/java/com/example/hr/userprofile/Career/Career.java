package com.example.hr.userprofile.Career;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "career")
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personId;
    private String employer;
    private String organizationType;
    private String unit;
    private String positionName;
    private Date startDate;
    private Date endDate;
    private Boolean governmentalPosition;
    private String stateStatus;
    private Timestamp timestamp;
    private String changeUserId;
}
