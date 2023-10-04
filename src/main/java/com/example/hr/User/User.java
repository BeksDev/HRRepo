package com.example.hr.User;

import com.example.hr.userprofile.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.hr.token.Token;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  private Integer id;
  private String firstname;
  private String lastname;
  private String email;
  @OneToOne
  @JoinColumn(name = "userprofile_id")
  private UserProfile userProfile;
  @JsonIgnore
  private String password;

  @JsonIgnore
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Token> tokens;

  @JsonIgnore
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return role.getAuthorities();
  }
  @JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }
  @JsonIgnore
  @Override
  public String getUsername() {
    return email;
  }
  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @JsonIgnore
  @Override
  public boolean isEnabled() {
    return true;
  }
}
