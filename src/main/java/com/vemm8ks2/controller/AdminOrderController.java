package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/order")
@RequiredArgsConstructor
public class AdminOrderController {

  private final OrderRepository orderRepository;

  @GetMapping
  public List<Orders> getAllOrders() {
    return orderRepository.findAll();
  }
}
