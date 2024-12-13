package com.vemm8ks2.service;

import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

  public String extractUsername(String token);

  public String generateToken(UserDetails userDetails);

  public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);

  public boolean isValidToken(String token, UserDetails userDetails);

}
