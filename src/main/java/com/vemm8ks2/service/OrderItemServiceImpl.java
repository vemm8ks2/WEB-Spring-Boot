package com.vemm8ks2.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.CartItems;
import com.vemm8ks2.model.OrderItems;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemRepository orderItemRepository;

  @Override
  public OrderItems createOrderItem(OrderItems orderItem) {
    return orderItemRepository.save(orderItem);
  }

  @Override
  public OrderItems createOrderItemByCartItemAndOrder(CartItems cartItem, Orders order) {

    OrderItems orderItem = new OrderItems();

    orderItem.setPrice(cartItem.getProduct().getPrice());
    orderItem.setQuantity(cartItem.getQuantity());
    orderItem.setSize(cartItem.getSize());
    orderItem.setProduct(cartItem.getProduct());
    orderItem.setOrder(order);

    return orderItemRepository.save(orderItem);
  }

  @Override
  public List<OrderItems> createAllOrderItemByCartItemAndOrder(List<CartItems> cartItems,
      Orders order) {

    List<OrderItems> orderItems = new ArrayList<>();

    for (CartItems cartItem : cartItems) {
      OrderItems orderItem = new OrderItems();

      orderItem.setPrice(cartItem.getProduct().getPrice());
      orderItem.setQuantity(cartItem.getQuantity());
      orderItem.setSize(cartItem.getSize());
      orderItem.setProduct(cartItem.getProduct());
      orderItem.setOrder(order);

      orderItems.add(orderItem);
    }

    return orderItemRepository.saveAll(orderItems);
  }

  @Override
  public OrderItems getOrderById(Long orderItemId) {
    return orderItemRepository.findById(orderItemId)
        .orElseThrow(() -> new NotFoundException("주문 기록의 상품을 찾을 수 없습니다."));
  }

  @Override
  public List<OrderItems> getOrderItemsByOrder(Long orderId) {
    return orderItemRepository.findByOrderId(orderId);
  }

}
