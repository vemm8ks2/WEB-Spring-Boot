package com.vemm8ks2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.CartItems;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.service.CartItemSerive;
import com.vemm8ks2.service.CartService;
import com.vemm8ks2.service.JwtService;
import com.vemm8ks2.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user/cart-item")
@RequiredArgsConstructor
public class CartItemController {

  private final UserService userService;
  private final CartService cartService;
  private final CartItemSerive cartItemSerive;
  private final JwtService jwtService;

  @PutMapping
  public ResponseEntity<Cart> addCartItem(@RequestHeader("Authorization") String jwt,
      @RequestBody CartItems cartItem) {

    String username = jwtService.extractUsername(jwt.substring(7));

    Users user = userService.getUserByUsername(username);
    Cart cart = cartService.getCartByUser(user.getId());

    cart = cartItemSerive.addCartItem(cart.getId(), cartItem);

    return ResponseEntity.ok(cart);
  }
}
