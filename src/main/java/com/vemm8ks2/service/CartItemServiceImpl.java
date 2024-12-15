package com.vemm8ks2.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.vemm8ks2.exception.NotFoundException;
import com.vemm8ks2.model.Cart;
import com.vemm8ks2.model.CartItems;
import com.vemm8ks2.repository.CartItemRepository;
import com.vemm8ks2.repository.CartRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemSerive {

  private final CartItemRepository cartItemRepository;
  private final CartRepository cartRepository;

  @Override
  public CartItems createCartItem(CartItems cartItem) {

    CartItems _cartItem = new CartItems();

    _cartItem.setQuantity(cartItem.getQuantity());
    _cartItem.setPrice(cartItem.getPrice());
    _cartItem.setTotalPrice(cartItem.getQuantity() * cartItem.getPrice());
    _cartItem.setCart(cartItem.getCart());
    _cartItem.setProduct(cartItem.getProduct());

    return cartItemRepository.save(_cartItem);
  }

  @Override
  public CartItems updateCartItemQuantity(Long cartItemId, int quantity) {

    CartItems cartItem = cartItemRepository.findById(cartItemId)
        .orElseThrow(() -> new NotFoundException("카트 상품이 존재하지 않습니다."));

    cartItem.setQuantity(quantity);

    return cartItemRepository.save(cartItem);
  }

  @Override
  @Transactional
  public Cart addCartItem(Long cartId, CartItems cartItem) {

    Cart cart =
        cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("카트가 존재하지 않습니다."));

    cartItem.setCart(cart);

    CartItems _cartItem = cartItemRepository.save(cartItem);

    cart.getCartItems().add(_cartItem);
    return cartRepository.save(cart);
  }

  @Override
  @Transactional
  public Cart removeCartItem(Long cartId, CartItems cartItem) {

    Cart cart =
        cartRepository.findById(cartId).orElseThrow(() -> new NotFoundException("카트가 존재하지 않습니다."));

    boolean removed = cart.getCartItems().removeIf(items -> items.getId().equals(cartItem.getId()));

    if (!removed) {
      throw new NotFoundException("카트 아이템을 찾을 수 없습니다.");
    }

    cartItemRepository.delete(cartItem);
    return cartRepository.save(cart);
  }

  @Override
  public List<CartItems> getCartItemsByCartId(Long cartId) {
    return cartItemRepository.findByCartId(cartId);
  }

}
