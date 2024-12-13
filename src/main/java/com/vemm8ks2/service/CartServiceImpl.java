package com.vemm8ks2.service;

import org.springframework.stereotype.Service;
import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.Users;
import com.vemm8ks2.repository.CartRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

  private final CartRepository cartRepository;

  @Override
  public Cart createCart(Users user) {

    Cart _cart = new Cart();

    _cart.setTotalPrice(0);
    _cart.setUser(user);

    return cartRepository.save(_cart);
  }

  @Override
  public Cart getCartByUser(Long userId) {
    return cartRepository.findByUserId(userId);
  }

}
