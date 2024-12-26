package com.vemm8ks2.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public Orders createOrder(Orders order, Users user) {
    order.setUser(user);
    return orderRepository.save(order);
  }

  @Override
  public Orders getOrderById(Long orderId) {
    return orderRepository.findById(orderId)
        .orElseThrow(() -> new NotFoundException("주문 기록을 찾을 수 없습니다."));
  }

  @Override
  public List<Orders> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Page<Orders> getAllOrders(int page, int size) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("deliveredAt")));
    return orderRepository.findAll(pageable);
  }

  @Override
  public List<Orders> getOrdersByUser(Long userId) {
    return orderRepository.findByUserId(userId);
  }

}
