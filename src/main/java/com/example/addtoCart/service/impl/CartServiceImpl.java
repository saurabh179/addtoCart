package com.example.addtoCart.service.impl;

import com.example.addtoCart.entity.Cart;
import com.example.addtoCart.model.CartDTO;
import com.example.addtoCart.repository.CartRepository;
import com.example.addtoCart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public CartDTO createCart(CartDTO cartDTO)  {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDTO, cart);
        Cart result = cartRepository.save(cart);
        CartDTO resultDTO = new CartDTO();
        BeanUtils.copyProperties(result, resultDTO);
        return resultDTO;
    }



    @Override
    public CartDTO getCartById(String email) {
        Cart result = cartRepository.findOne(email);
        CartDTO resultDTO = new CartDTO();
        BeanUtils.copyProperties(result,resultDTO);
        return resultDTO;
    }

    @Override
    public CartDTO deleteCart(String email) {
        cartRepository.delete(email);
        return null;
    }

    @Transactional
    @Override
    public void deleteParticularProduct(String productId, String variantId, String email) {
        cartRepository.deleteByProductIdAndVariantIdAndEmail(productId,variantId,email);
    }

}
