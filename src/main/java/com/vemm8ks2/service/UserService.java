package com.vemm8ks2.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.vemm8ks2.model.Users;

public interface UserService {

  public Users createUser(Users user);
  
  public Users createAdmin(Users admin);
  
  public Users getUserById(Long userId);
  
  public Users getUserByUsername(String username);
  
  public UserDetailsService userDetailsService();
}
