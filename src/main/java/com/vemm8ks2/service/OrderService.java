package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.model.Users;

public interface OrderService {

  public Orders createOrder(Orders order, Users user);

  public Orders getOrderById(Long orderId);
  
  public List<Orders> getAllOrders();

  public List<Orders> getOrdersByUser(Long userId);
}
