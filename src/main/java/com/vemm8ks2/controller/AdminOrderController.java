package com.vemm8ks2.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.response.GeneralResponse;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/order")
@RequiredArgsConstructor
public class AdminOrderController {

  private final OrderService orderService;

  @GetMapping
  public ResponseEntity<GeneralResponse<Page<Orders>>> getAllOrders(
      @RequestParam(defaultValue = "0", name = "page") int page,
      @RequestParam(defaultValue = "10", name = "size") int size) {

    Page<Orders> orders = orderService.getAllOrders(page, size);

    String msg = "page: " + page + " | size : " + size + " | 상품 데이터를 가져왔습니다.";
    GeneralResponse<Page<Orders>> response = new GeneralResponse<Page<Orders>>(msg, orders);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
