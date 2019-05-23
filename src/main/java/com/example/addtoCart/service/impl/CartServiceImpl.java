package com.example.addtoCart.service.impl;

import com.example.addtoCart.entity.CartEntity;
import com.example.addtoCart.model.CartDTO;
import com.example.addtoCart.repository.CartRepository;
import com.example.addtoCart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public CartDTO createCart(CartDTO cartDTO)  {


        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(cartDTO, cartEntity);
        CartEntity result = cartRepository.save(cartEntity);
        CartDTO resultDTO = new CartDTO();
        BeanUtils.copyProperties(result, resultDTO);
        return resultDTO;


    }



    @Override
    public CartDTO getCartById(String email) {
        CartEntity result = cartRepository.findOne(email);
        CartDTO resultDTO = new CartDTO();
        BeanUtils.copyProperties(result,resultDTO);
        return resultDTO;
    }

    @Override
    public CartDTO deleteCart(String email) {
        cartRepository.delete(email);
        return null;
    }

    @Override
    public CartDTO updateCart(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        BeanUtils.copyProperties(cartDTO,cartEntity);
        CartEntity result = cartRepository.save(cartEntity);
        CartDTO resultDTO = new CartDTO();
        BeanUtils.copyProperties(result,resultDTO);
        return resultDTO;
    }
}
