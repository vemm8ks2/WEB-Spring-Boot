package com.vemm8ks2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.JwtAuthSuccess;
import com.vemm8ks2.dto.RefreshTokenRequest;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
  public ResponseEntity<Users> signup(@RequestBody Users user) {
    return ResponseEntity.ok(authenticationService.signup(user));
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtAuthSuccess> signin(@RequestBody Users user) {
    return ResponseEntity.ok(authenticationService.signin(user));
  }

  @PostMapping("/refresh")
  public ResponseEntity<JwtAuthSuccess> refresh(
      @RequestBody RefreshTokenRequest refreshTokenRequest) {
    return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
  }

}
