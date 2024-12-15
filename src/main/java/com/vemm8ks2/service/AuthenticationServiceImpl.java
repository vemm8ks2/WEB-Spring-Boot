package com.vemm8ks2.service;

import java.util.HashMap;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vemm8ks2.dto.JwtAuthSuccess;
import com.vemm8ks2.dto.RefreshTokenRequest;
import com.vemm8ks2.model.UserRole;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

  private final UserRepository userRepository;
  private final CartService cartService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  @Transactional
  public Users signup(Users user) {

    Users _user = new Users();

    _user.setUsername(user.getUsername());
    _user.setPassword(passwordEncoder.encode(user.getPassword()));
    _user.setGender(user.getGender());
    _user.setBirthDate(user.getBirthDate());
    _user.setRole(UserRole.USER);

    cartService.createCart(_user);
    return userRepository.save(_user);
  }

  public JwtAuthSuccess signin(Users user) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

    Users _user = userRepository.findByUsername(user.getUsername())
        .orElseThrow(() -> new IllegalArgumentException("아이디 혹은 비밀번호가 일치하지 않습니다."));

    String token = jwtService.generateToken(_user);
    String refreshToken = jwtService.generateRefreshToken(new HashMap<>(), _user);

    JwtAuthSuccess response = new JwtAuthSuccess();

    response.setToken(token);
    response.setRefreshToken(refreshToken);
    response.setUser(_user);

    return response;
  }

  public JwtAuthSuccess refreshToken(RefreshTokenRequest refreshTokenRequest) {
    String username = jwtService.extractUsername(refreshTokenRequest.getToken());
    Users user = userRepository.findByUsername(username).orElseThrow();

    if (jwtService.isValidToken(refreshTokenRequest.getToken(), user)) {
      String token = jwtService.generateToken(user);

      JwtAuthSuccess response = new JwtAuthSuccess();

      response.setToken(token);
      response.setRefreshToken(refreshTokenRequest.getToken());
      response.setUser(user);

      return response;
    }

    return null;
  }
}
