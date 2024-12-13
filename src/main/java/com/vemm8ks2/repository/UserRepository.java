package com.vemm8ks2.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.UserRole;
import com.vemm8ks2.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByUsername(String username);
  
  Users findByRole(UserRole role);
}
