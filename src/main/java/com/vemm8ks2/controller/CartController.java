package com.vemm8ks2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.service.CartService;
import com.vemm8ks2.service.JwtService;
import com.vemm8ks2.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user/cart")
@RequiredArgsConstructor
public class CartController {

  private final CartService cartService;
  private final UserService userService;
  private final JwtService jwtService;

  @GetMapping
  public ResponseEntity<Cart> getCart(@RequestHeader("Authorization") String jwt) {

    String username = jwtService.extractUsername(jwt.substring(7));

    Users user = userService.getUserByUsername(username);
    Cart cart = cartService.getCartByUser(user.getId());

    return ResponseEntity.ok(cart);
  }
}
