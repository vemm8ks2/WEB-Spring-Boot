package com.vemm8ks2.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.repository.OrderRepository;
import com.vemm8ks2.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdminDashboardService {

  private final OrderRepository orderRepository;
  private final UserRepository userRepository;

  @Override
  public Double getTotalPriceBetweenDate(LocalDateTime startDate, LocalDateTime endDate) {
    return (orderRepository.findTotalPriceForDate(startDate, endDate));
  }

  @Override
  public Number getSignupUsersBetweenDate(LocalDateTime startDate, LocalDateTime endDate) {
    return userRepository.getSignupUsersForDate(startDate, endDate);
  }

  @Override
  public Number getOrdersBetweenDate(LocalDateTime startDate, LocalDateTime endDate) {
    return orderRepository.countByDeliveredAtBetween(startDate, endDate);
  }

  @Override
  public Object[] getMonthlyOrderAmount(LocalDateTime startDate, LocalDateTime endDate) {
    return orderRepository.getMonthlyOrderAmount(startDate, endDate);
  }

  @Override
  public List<Orders> getTop5RecentOrders() {
    return orderRepository.findTop5ByOrderByDeliveredAtDesc();
  }

}
