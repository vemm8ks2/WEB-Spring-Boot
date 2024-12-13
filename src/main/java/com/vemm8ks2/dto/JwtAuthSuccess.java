package com.vemm8ks2.dto;

import com.vemm8ks2.model.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthSuccess {

  private String token;
  private String refreshToken;
  private Users user;
}
