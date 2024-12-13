package com.vemm8ks2.service;

import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.Users;

public interface CartService {

  public Cart createCart(Users user);

  public Cart getCartByUser(Long userId);
}

