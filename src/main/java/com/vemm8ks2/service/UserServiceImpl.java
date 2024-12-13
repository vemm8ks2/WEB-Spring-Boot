package com.vemm8ks2.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.UserRole;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public Users createUser(Users user) {

    Users _user = new Users();

    _user.setUsername(user.getUsername());
    _user.setPassword(user.getPassword());
    _user.setGender(user.getGender());
    _user.setBirthDate(user.getBirthDate());
    _user.setRole(UserRole.USER);

    userRepository.save(_user);

    return _user;
  }

  @Override
  public Users createAdmin(Users admin) {

    Users _admin = new Users();

    _admin.setUsername(admin.getUsername());
    _admin.setPassword(admin.getPassword());
    _admin.setRole(UserRole.ADMIN);

    userRepository.save(_admin);

    return _admin;
  }

  @Override
  public Users getUserById(Long userId) {

    Optional<Users> optional = userRepository.findById(userId);

    if (optional.isEmpty()) {
      throw new NotFoundException("유저가 존재하지 않습니다.");
    }

    return optional.get();
  }

}
