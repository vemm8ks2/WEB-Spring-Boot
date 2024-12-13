package com.vemm8ks2.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

  public String extractUsername(String token);

  public String generateToken(UserDetails userDetails);

  public boolean isValidToken(String token, UserDetails userDetails);
}
