package com.vemm8ks2.service;

import java.time.LocalDateTime;
import java.util.List;
import com.vemm8ks2.model.Orders;

public interface AdminDashboardService {

  public Double getTotalSalesBetweenDate(LocalDateTime startDate, LocalDateTime endDate);

  public Number getSignupUsersBetweenDate(LocalDateTime startDate, LocalDateTime endDate);

  public Number getOrdersBetweenDate(LocalDateTime startDate, LocalDateTime endDate);

  public Object[] getMonthlyOrderAmount(LocalDateTime startDate, LocalDateTime endDate);

  public List<Orders> getTop5RecentOrders();

  public List<Orders> getOrderListBetweenDate(LocalDateTime startDate, LocalDateTime endDate);
}
