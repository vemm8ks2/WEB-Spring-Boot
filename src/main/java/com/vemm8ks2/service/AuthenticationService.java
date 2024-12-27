package com.vemm8ks2.service;

import com.vemm8ks2.dto.JwtAuthSuccess;
import com.vemm8ks2.dto.RefreshTokenRequest;
import com.vemm8ks2.model.Users;

public interface AuthenticationService {

  public Users signup(Users user);

  public JwtAuthSuccess signin(Users user);

  public JwtAuthSuccess refreshToken(RefreshTokenRequest refreshTokenRequest);

}
