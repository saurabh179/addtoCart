package com.example.addtoCart.service;


import com.example.addtoCart.model.CartDTO;

public interface CartService {

    CartDTO createCart(CartDTO cartDTO);
    CartDTO getCartById(String email);
    CartDTO deleteCart(String email);
    void deleteParticularProduct(String productId, String variantId, String email);
}
