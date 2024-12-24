package com.vemm8ks2.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
  public Users getUserById(Long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("유저가 존재하지 않습니다."));
  }

  @Override
  public List<Users> getAllUser() {
    return userRepository.findAll();
  }

  @Override
  public Page<Users> getAllUser(int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("createdAt")));
    return userRepository.findAll(pageable);
  }

  @Override
  public UserDetailsService userDetailsService() {
    return username -> userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("유저가 존재하지 않습니다."));
  }

  @Override
  public Users getUserByUsername(String username) {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("유저가 존재하지 않습니다."));
  }

}
