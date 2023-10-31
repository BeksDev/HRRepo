package com.example.hr.userprofile.Documents;
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
@Entity(name = "documents")
@Table
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer personId;
    private String owner;
    private String documentType;
    private String documentName;
    private String issuerOrganization;
    private String attachment;
    private Timestamp time;
    private String stateStatus;
    private Integer changeUserId;
}
