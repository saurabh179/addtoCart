package com.example.addtoCart.service;


import com.example.addtoCart.model.CartDTO;

public interface CartService {

    CartDTO createCart(CartDTO employeeDTO) throws Exception;
    CartDTO getCartById(String email);
    CartDTO deleteCart(String email);
    CartDTO updateCart(CartDTO employeeDTO);
}
