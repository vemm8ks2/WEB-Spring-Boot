package com.vemm8ks2.service;

import com.vemm8ks2.model.Cart;

public interface CartService {

  public Cart createCart(Long userId);

  public Cart getCartByUser(Long userId);
}

