package com.vemm8ks2.security;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.vemm8ks2.model.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

  private final String SECRET_KEY = "";
  private final long VALIDITY_IN_MILLISECONDS = 1000L * 60 * 60 * 24; // 24시간
  
  public String createToken(String username, UserRole role) {
    Claims claims = Jwts.claims().build();
    
    claims.put("username", username);
    claims.put("role", role.name());

    Date now = new Date();
    Date validity = new Date(now.getTime() + VALIDITY_IN_MILLISECONDS);

    return Jwts.builder()
            .claims(claims)  // Claims 객체를 설정
            .issuedAt(now)
            .expiration(validity)
            .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
            .compact();
  }
}
