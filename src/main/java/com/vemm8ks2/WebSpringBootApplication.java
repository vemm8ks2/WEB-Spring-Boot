package com.vemm8ks2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.vemm8ks2.model.UserGender;
import com.vemm8ks2.model.UserRole;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.UserRepository;

@SpringBootApplication
public class WebSpringBootApplication implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(WebSpringBootApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Users admin = userRepository.findByRole(UserRole.ADMIN);

    if (admin == null) {
      Users newAdmin = new Users();

      newAdmin.setUsername("admin");
      newAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));
      newAdmin.setGender(UserGender.OTHER);
      newAdmin.setRole(UserRole.ADMIN);

      userRepository.save(newAdmin);
    }
  }

}
