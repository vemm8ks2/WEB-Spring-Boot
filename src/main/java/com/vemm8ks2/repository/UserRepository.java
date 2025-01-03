package com.vemm8ks2.repository;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.vemm8ks2.model.UserRole;
import com.vemm8ks2.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

  Optional<Users> findByUsername(String username);

  Users findByRole(UserRole role);

  @Query("SELECT COUNT(u) FROM Users u WHERE u.createdAt >= :startOfDate AND u.createdAt <= :endOfDate")
  public Number getSignupUsersForDate(@Param("startOfDate") LocalDateTime startOfDate,
      @Param("endOfDate") LocalDateTime endOfDate);

}
