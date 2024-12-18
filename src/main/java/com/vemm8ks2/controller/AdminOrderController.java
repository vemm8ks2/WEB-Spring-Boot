package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/order")
@RequiredArgsConstructor
public class AdminOrderController {

  private final OrderService orderService;

  @GetMapping
  public List<Orders> getAllOrders() {
    return orderService.getAllOrders();
  }
}
