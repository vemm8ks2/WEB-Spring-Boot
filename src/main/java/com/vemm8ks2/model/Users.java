package com.vemm8ks2.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users implements UserDetails {

  private static final long serialVersionUID = 4982172815429321669L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserRole role;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserGender gender;

  private LocalDate birthDate;

  public Users buildUser(Users user) {

    Users _user = new Users();

    _user.setUsername(user.getUsername());
    _user.setPassword(user.getPassword());
    _user.setGender(user.getGender());
    _user.setBirthDate(user.getBirthDate());
    _user.setRole(UserRole.USER);

    return _user;
  }

  public Users buildAdmin(Users admin) {

    Users _admin = new Users();

    _admin.setUsername(admin.getUsername());
    _admin.setPassword(admin.getPassword());
    _admin.setRole(UserRole.ADMIN);

    return _admin;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.getValue()));
  }

}
