package com.vemm8ks2.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.dto.SuccessResponse;
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
  public ResponseEntity<SuccessResponse> saveOrder(@RequestHeader("Authorization") String jwt,
      @RequestBody Orders order) {

    String username = jwtService.extractUsername(jwt.substring(7));

    Users user = userService.getUserByUsername(username);
    Cart cart = cartService.getCartByUser(user.getId());

    List<CartItems> cartItems = cart.getCartItems();

    Orders _order = orderService.createOrder(order);

    orderItemService.createAllOrderItemByCartItemAndOrder(cartItems, _order);

    SuccessResponse response = new SuccessResponse("주문이 완료되었습니다.");

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
