package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.CartItems;

public interface CartItemSerive {

  public CartItems createCartItem(CartItems cartItem);

  public CartItems updateCartItemQuantity(Long cartItemId, int quantity);

  public String addCartItem(Long cartId, CartItems cart);

  public void removeCartItem(Long cartId, Long cartItemId);

  public List<CartItems> getCartItemsByCartId(Long cartId);
}
