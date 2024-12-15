package com.vemm8ks2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.CartItems;

public interface CartItemRepository extends JpaRepository<CartItems, Long> {

  public List<CartItems> findByCartId(Long cartId);
  
  public CartItems findByCartIdAndProductIdAndSize(Long cartId, Long productId, String size);
}
