package com.vemm8ks2.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.vemm8ks2.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

  public List<Orders> findByUserId(Long userId);

  @Query("SELECT SUM(o.totalPrice) FROM Orders o WHERE o.deliveredAt >= :startOfDate AND o.deliveredAt <= :endOfDate")
  public Double findTotalPriceForDate(@Param("startOfDate") LocalDateTime startOfDate,
      @Param("endOfDate") LocalDateTime endOfDate);

  public Number countByDeliveredAtBetween(LocalDateTime startOfDate, LocalDateTime endOfDate);
  
  public List<Orders> findTop5ByOrderByDeliveredAtDesc();

  @Query("SELECT EXTRACT(YEAR FROM o.deliveredAt) AS year, EXTRACT(MONTH FROM o.deliveredAt) AS month, SUM(o.totalPrice) "
      + "FROM Orders o " + "WHERE o.deliveredAt BETWEEN :startOfDate AND :endOfDate "
      + "GROUP BY EXTRACT(YEAR FROM o.deliveredAt), EXTRACT(MONTH FROM o.deliveredAt) "
      + "ORDER BY year DESC, month DESC")
  public Object[] getMonthlyOrderAmount(@Param("startOfDate") LocalDateTime startOfDate,
      @Param("endOfDate") LocalDateTime endOfDate);
}
