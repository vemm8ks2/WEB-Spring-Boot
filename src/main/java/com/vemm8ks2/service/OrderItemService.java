package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.CartItems;
import com.vemm8ks2.model.OrderItems;
import com.vemm8ks2.model.Orders;

public interface OrderItemService {

  public OrderItems createOrderItem(OrderItems orderItem);

  public OrderItems getOrderById(Long orderItemId);

  public List<OrderItems> getOrderItemsByOrder(Long orderId);

  public OrderItems createOrderItemByCartItemAndOrder(CartItems cartItem, Orders order);

  public List<OrderItems> createAllOrderItemByCartItemAndOrder(List<CartItems> cartItems,
      Orders order);
}
