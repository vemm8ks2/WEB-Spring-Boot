package com.vemm8ks2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems, Long> {

}
