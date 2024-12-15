package com.vemm8ks2.service;

import org.springframework.stereotype.Service;
import com.vemm8ks2.exception.NotFoundException;
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

    _cart.setUser(user);

    return cartRepository.save(_cart);
  }

  @Override
  public Cart getCartByUser(Long userId) {
    return cartRepository.findByUserId(userId);
  }

  @Override
  public Cart getCartById(Long cartId) {
    return cartRepository.findById(cartId)
        .orElseThrow(() -> new NotFoundException("카트가 존재하지 않습니다."));
  }

}
