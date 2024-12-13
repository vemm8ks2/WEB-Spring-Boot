package com.vemm8ks2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

  public Cart findByUserId(Long userId);
}
