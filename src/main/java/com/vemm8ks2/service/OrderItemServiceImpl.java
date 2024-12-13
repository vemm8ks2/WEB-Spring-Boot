package com.vemm8ks2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.OrderItems;
import com.vemm8ks2.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemRepository orderItemRepository;

  @Override
  public OrderItems createOrderItem(OrderItems orderItem) {

    OrderItems _orderItems = new OrderItems();

    _orderItems.setQuantity(orderItem.getQuantity());
    _orderItems.setPrice(orderItem.getPrice());
    _orderItems.setSize(orderItem.getSize());
    _orderItems.setOrder(orderItem.getOrder());
    _orderItems.setProduct(orderItem.getProduct());

    return orderItemRepository.save(_orderItems);
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
