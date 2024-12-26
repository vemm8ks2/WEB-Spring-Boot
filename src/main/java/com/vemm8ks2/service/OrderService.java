package com.vemm8ks2.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.model.Users;

public interface OrderService {

  public Orders createOrder(Orders order, Users user);

  public Orders getOrderById(Long orderId);
  
  public List<Orders> getAllOrders();
  
  public Page<Orders> getAllOrders(int page, int size);

  public List<Orders> getOrdersByUser(Long userId);
}
