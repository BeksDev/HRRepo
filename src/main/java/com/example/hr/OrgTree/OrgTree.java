package com.example.hr.OrgTree;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "orgtree")
public class OrgTree {
    @Id
    private Long depKey;
    private String name;
}
