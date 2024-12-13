package com.vemm8ks2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vemm8ks2.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

  public List<Orders> findByUserId(Long userId);
}
