package com.vemm8ks2.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService {

  private SecretKey secretKey;
  private String encodedSecretKey;

  public JwtServiceImpl() {
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
      secretKey = keyGenerator.generateKey();
      encodedSecretKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String generateToken(UserDetails userDetails) {
    return Jwts.builder().subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() * 1000 * 60 * 60 * 24)).signWith(getSignKey())
        .compact();
  }

  public String generateRefreshToken(Map<String, Object> extraClaims,UserDetails userDetails) {
    return Jwts.builder().subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() * 1000 * 60 * 60 * 24 * 7)).signWith(getSignKey())
        .compact();
  }

  public String extractUsername(String token) {
    return extractClaims(token, Claims::getSubject);
  }

  private <T> T extractClaims(String token, Function<Claims, T> claimsResolvers) {
    Claims claims = extractAllClaims(token);
    return claimsResolvers.apply(claims);
  }

  private Key getSignKey() {
    byte[] key = Decoders.BASE64.decode(encodedSecretKey);
    return Keys.hmacShaKeyFor(key);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
  }

  public boolean isValidToken(String token, UserDetails userDetails) {
    String username = extractUsername(token);
    return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return extractClaims(token, Claims::getExpiration).before(new Date());
  }
}
