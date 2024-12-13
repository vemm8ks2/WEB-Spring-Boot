package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.Orders;

public interface OrderService {

  public Orders createOrder(Orders order);

  public Orders getOrderById(Long orderId);

  public List<Orders> getOrdersByUser(Long userId);
}
