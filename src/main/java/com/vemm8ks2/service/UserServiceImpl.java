package com.vemm8ks2.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Users createUser(Users user) {
    return userRepository.save((new Users()).buildUser(user));
  }

  @Override
  public Users createAdmin(Users admin) {
    return userRepository.save((new Users()).buildAdmin(admin));
  }

  @Override
  public Users getUserById(Long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("유저가 존재하지 않습니다."));
  }

  @Override
  public UserDetailsService userDetailsService() {
    return username -> userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("유저가 존재하지 않습니다."));
  }

}
