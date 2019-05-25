package com.example.addtoCart.service;


import com.example.addtoCart.entity.Cart;
import com.example.addtoCart.model.CartDTO;

import java.util.List;

public interface CartService {

    boolean createCart(CartDTO cartDTO,String token);
    CartDTO getCartById(String email);
    Boolean deleteCart(String email);
    boolean deleteParticularProduct(String productId, String variantId, String merchantId,String email);

    List<Cart> getEverythingFromCart(String email);

}
