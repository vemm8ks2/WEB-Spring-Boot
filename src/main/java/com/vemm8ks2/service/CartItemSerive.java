package com.vemm8ks2.service;

import java.util.List;
import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.CartItems;

public interface CartItemSerive {

  public CartItems createCartItem(CartItems cartItem);

  public CartItems updateCartItemQuantity(Long cartItemId, int quantity);
  
  public CartItems addCartItem(Cart cart, CartItems cartItem);
  
  public Cart removeCartItem(Long cartId, CartItems cartItem);
  
  public boolean removeAllCartItem(List<CartItems> cartItems);

  public List<CartItems> getCartItemsByCartId(Long cartId);
  
  public CartItems getCartItemById(Long cartItemId);
}
