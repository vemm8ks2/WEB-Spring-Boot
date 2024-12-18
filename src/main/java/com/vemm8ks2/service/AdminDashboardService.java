package com.vemm8ks2.service;

import java.time.LocalDateTime;
import java.util.List;
import com.vemm8ks2.model.Orders;

public interface AdminDashboardService {

  public Double getTotalPriceBetweenDate(LocalDateTime startDate, LocalDateTime endDate);

  public Number getSignupUsersBetweenDate(LocalDateTime startDate, LocalDateTime endDate);

  public Number getOrdersBetweenDate(LocalDateTime startDate, LocalDateTime endDate);

  public Object[] getMonthlyOrderAmount(LocalDateTime startDate, LocalDateTime endDate);

  public List<Orders> getTop5RecentOrders();
}
