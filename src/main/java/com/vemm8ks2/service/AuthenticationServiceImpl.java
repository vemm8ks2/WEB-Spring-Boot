package com.vemm8ks2.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.vemm8ks2.model.UserRole;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public Users signup(Users user) {

    Users _user = new Users();

    _user.setUsername(user.getUsername());
    _user.setPassword(passwordEncoder.encode(user.getPassword()));
    _user.setGender(user.getGender());
    _user.setBirthDate(user.getBirthDate());
    _user.setRole(UserRole.USER);

    return userRepository.save(_user);
  }
}
