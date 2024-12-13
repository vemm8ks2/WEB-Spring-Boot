package com.vemm8ks2.service;

import com.vemm8ks2.model.Users;

public interface UserService {

  public Users createUser(Users user);
  
  public Users createAdmin(Users admin);
  
  public Users getUserById(Long userId);
}
