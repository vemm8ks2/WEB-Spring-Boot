package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.OrderItems;

public interface OrderItemService {

  public OrderItems createOrderItem(OrderItems orderItem);

  public OrderItems getOrderById(Long orderItemId);

  public List<OrderItems> getOrderItemsByOrder(Long orderId);
}
