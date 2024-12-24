package com.vemm8ks2.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.vemm8ks2.model.Users;

public interface UserService {
  
  public Users getUserById(Long userId);
  
  public List<Users> getAllUser();

  public Page<Users> getAllUser(int page, int size);
  
  public Users getUserByUsername(String username);
  
  public UserDetailsService userDetailsService();
}
