package com.vemm8ks2.model;

import java.time.LocalDate;
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
public class Users {

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

}
