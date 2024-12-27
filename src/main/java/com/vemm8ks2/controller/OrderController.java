package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.response.GeneralResponse;
import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.CartItems;
import com.vemm8ks2.model.Orders;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.service.CartService;
import com.vemm8ks2.service.JwtService;
import com.vemm8ks2.service.OrderItemService;
import com.vemm8ks2.service.OrderService;
import com.vemm8ks2.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user/order")
@RequiredArgsConstructor
public class OrderController {

  private final JwtService jwtService;
  private final CartService cartService;
  private final UserService userService;
  private final OrderService orderService;
  private final OrderItemService orderItemService;

  @PostMapping
  @Transactional
  public ResponseEntity<GeneralResponse<?>> saveOrder(@RequestHeader("Authorization") String jwt,
      @RequestBody Orders order) {

    String username = jwtService.extractUsername(jwt.substring(7));

    Users user = userService.getUserByUsername(username);
    Cart cart = cartService.getCartByUser(user.getId());

    List<CartItems> cartItems = cart.getCartItems();

    Orders _order = orderService.createOrder(order, user);

    orderItemService.createAllOrderItemByCartItemAndOrder(cartItems, _order);

    GeneralResponse<?> response = new GeneralResponse<>("주문이 완료되었습니다.");

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/history")
  public ResponseEntity<GeneralResponse<List<Orders>>> getOrderHistory(
      @RequestHeader("Authorization") String jwt) {

    String username = jwtService.extractUsername(jwt.substring(7));

    Users user = userService.getUserByUsername(username);
    List<Orders> orders = orderService.getOrdersByUser(user.getId());

    GeneralResponse<List<Orders>> response = new GeneralResponse<>("주문 내역을 성공적으로 불러왔습니다.", orders);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
