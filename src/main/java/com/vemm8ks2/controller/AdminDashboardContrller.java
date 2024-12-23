package com.vemm8ks2.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.SuccessResponse;
import com.vemm8ks2.dto.request._BetweenDateDTO;
import com.vemm8ks2.model.OrderItems;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admin/dashboard")
@RequiredArgsConstructor
@Slf4j
public class AdminDashboardContrller {

  private final AdminDashboardService adminDashboardService;

  @GetMapping("/total-sales-of-this-month")
  public ResponseEntity<SuccessResponse<Double>> getTotalSalesOfThisMonth() {

    LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
    LocalDate today = LocalDate.now();

    Double totalPrice = adminDashboardService.getTotalSalesBetweenDate(startOfMonth.atTime(0, 0),
        today.atTime(LocalTime.now()));

    String msg = startOfMonth + " 부터 " + today + " 까지 총 구매금액입니다.";
    SuccessResponse<Double> response = new SuccessResponse<>(msg, totalPrice);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // 지난 달 첫날부터 오늘 기준으로 한 달 전까지 총 합계를 구합니다.
  @GetMapping("/total-sales-of-last-month")
  public ResponseEntity<SuccessResponse<Double>> getTotalSalesOfLastMonth() {

    LocalDate today = LocalDate.now();
    LocalDate lastMonth = today.minusMonths(1);
    LocalDate firstDayOfLastMonth = lastMonth.withDayOfMonth(1);

    Double totalPrice = adminDashboardService.getTotalSalesBetweenDate(
        firstDayOfLastMonth.atTime(0, 0), lastMonth.atTime(LocalTime.now()));

    String msg = firstDayOfLastMonth + " 부터 " + lastMonth + " 까지 총 구매금액입니다.";
    SuccessResponse<Double> response = new SuccessResponse<>(msg, totalPrice);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/signup-users-of-this-month")
  public ResponseEntity<SuccessResponse<Number>> getSignupUsersOfThisMonth() {

    LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
    LocalDate today = LocalDate.now();

    Number users = adminDashboardService.getSignupUsersBetweenDate(startOfMonth.atTime(0, 0),
        today.atTime(LocalTime.now()));

    String msg = startOfMonth + " 부터 " + today + " 까지 총 회원가입자 수 입니다.";
    SuccessResponse<Number> response = new SuccessResponse<>(msg, users);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // 지난 달 첫날부터 오늘 기준으로 한 달 전까지 총 회원가입 수를 구합니다.
  @GetMapping("/signup-users-of-last-month")
  public ResponseEntity<SuccessResponse<Number>> getSignupUsersOfLastMonth() {

    LocalDate today = LocalDate.now();
    LocalDate lastMonth = today.minusMonths(1);
    LocalDate firstDayOfLastMonth = lastMonth.withDayOfMonth(1);

    Number users = adminDashboardService.getSignupUsersBetweenDate(firstDayOfLastMonth.atTime(0, 0),
        lastMonth.atTime(LocalTime.now()));

    String msg = firstDayOfLastMonth + " 부터 " + lastMonth + " 까지 총 회원가입자 수 입니다.";
    SuccessResponse<Number> response = new SuccessResponse<>(msg, users);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/orders-number-of-this-month")
  public ResponseEntity<SuccessResponse<Number>> getOrdersOfThisMonth() {

    LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
    LocalDate today = LocalDate.now();

    Number orders = adminDashboardService.getOrdersBetweenDate(startOfMonth.atTime(0, 0),
        today.atTime(LocalTime.now()));

    String msg = startOfMonth + " 부터 " + today + " 까지 총 주문 수 입니다.";
    SuccessResponse<Number> response = new SuccessResponse<>(msg, orders);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  // 지난 달 첫날부터 오늘 기준으로 한 달 전까지 총 회원가입 수를 구합니다.
  @GetMapping("/orders-number-of-last-month")
  public ResponseEntity<SuccessResponse<Number>> getOrdersOfLastMonth() {

    LocalDate today = LocalDate.now();
    LocalDate lastMonth = today.minusMonths(1);
    LocalDate firstDayOfLastMonth = lastMonth.withDayOfMonth(1);

    Number orders = adminDashboardService.getOrdersBetweenDate(firstDayOfLastMonth.atTime(0, 0),
        lastMonth.atTime(LocalTime.now()));

    String msg = firstDayOfLastMonth + " 부터 " + lastMonth + " 까지 총 주문 수 입니다.";
    SuccessResponse<Number> response = new SuccessResponse<>(msg, orders);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/order-amount-by-month")
  public ResponseEntity<SuccessResponse<Object[]>> getMonthlyOrderAmount(
      @RequestBody _BetweenDateDTO date) {

    LocalDateTime startDate = date.getStartDate();
    LocalDateTime endDate = date.getEndDate();

    Object[] orderAmount = adminDashboardService.getMonthlyOrderAmount(startDate, endDate);

    String msg = startDate.toLocalDate() + " 부터 " + endDate.toLocalDate() + " 까지 월별 총 주문 합계 입니다.";
    SuccessResponse<Object[]> response = new SuccessResponse<>(msg, orderAmount);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/order-amount-for-last-year")
  public ResponseEntity<SuccessResponse<Object[]>> getOrderAmountForLastYear() {

    LocalDate today = LocalDate.now();
    LocalDate lastYear = today.minusYears(1);
    LocalDate firstDayOfLastYear = lastYear.withDayOfMonth(1);

    Object[] orderAmount = adminDashboardService.getMonthlyOrderAmount(
        firstDayOfLastYear.atTime(0, 0), today.atTime(LocalTime.now()));

    String msg = firstDayOfLastYear + " 부터 " + today + " 까지 월별 총 주문 합계 입니다.";
    SuccessResponse<Object[]> response = new SuccessResponse<>(msg, orderAmount);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/selling-quantity-for-this-month")
  public ResponseEntity<SuccessResponse<Number>> getSellingQuantityForThisMonth() {

    LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
    LocalDate today = LocalDate.now();

    List<Orders> orderList = adminDashboardService
        .getOrderListBetweenDate(startOfMonth.atTime(0, 0), today.atTime(LocalTime.now()));

    Integer totalQuantity = 0;

    for (Orders order : orderList) {
      for (OrderItems item : order.getOrderItems()) {
        totalQuantity += item.getQuantity();
      }
    }

    String msg = startOfMonth + " 부터 " + today + " 까지 총 판매 개수 입니다.";
    SuccessResponse<Number> response = new SuccessResponse<>(msg, totalQuantity);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/selling-quantity-for-last-month")
  public ResponseEntity<SuccessResponse<Number>> getSellingQuantityForLastMonth() {

    LocalDate today = LocalDate.now();
    LocalDate lastMonth = today.minusMonths(1);
    LocalDate firstDayOfLastMonth = lastMonth.withDayOfMonth(1);

    List<Orders> orderList = adminDashboardService.getOrderListBetweenDate(
        firstDayOfLastMonth.atTime(0, 0), lastMonth.atTime(LocalTime.now()));

    Integer totalQuantity = 0;

    for (Orders order : orderList) {
      for (OrderItems item : order.getOrderItems()) {
        totalQuantity += item.getQuantity();
      }
    }

    String msg = firstDayOfLastMonth + " 부터 " + lastMonth + " 까지 총 판매 개수 입니다.";
    SuccessResponse<Number> response = new SuccessResponse<>(msg, totalQuantity);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }


  @GetMapping("/top5-recent-orders")
  public ResponseEntity<SuccessResponse<List<Orders>>> getTop5RecentOrders() {

    List<Orders> orders = adminDashboardService.getTop5RecentOrders();

    SuccessResponse<List<Orders>> response = new SuccessResponse<>("최근 주문 목록 5개입니다.", orders);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
