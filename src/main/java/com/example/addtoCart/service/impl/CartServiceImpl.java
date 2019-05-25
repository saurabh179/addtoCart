package com.example.addtoCart.service.impl;

import com.example.addtoCart.entity.Cart;
import com.example.addtoCart.model.CartDTO;
import com.example.addtoCart.repository.CartRepository;
import com.example.addtoCart.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public boolean createCart(CartDTO cartDTO,String token) {
        String ctoken = token;
        String cemail = cartDTO.getEmail();

        final String uri = "http://localhost:8081/checktoken?token="+ctoken+"&email="+cemail;

        RestTemplate restTemplate = new RestTemplate();
        boolean status = restTemplate.getForObject(uri, boolean.class);

        if (status == true) {
            Cart cart = new Cart();
            BeanUtils.copyProperties(cartDTO, cart);
            Cart result = cartRepository.save(cart);
            return true;
        } else {
            return false;
        }
    }



    @Override
    public CartDTO getCartById(String email) {
        Cart result = cartRepository.findOne(email);
        CartDTO resultDTO = new CartDTO();
        BeanUtils.copyProperties(result,resultDTO);
        return resultDTO;
    }

    @Transactional
    @Override
    public Boolean deleteCart(String email) {
        cartRepository.deleteAllByEmail(email);
        System.out.println("Deleteing entries for " + email);;
        return true;
    }

    @Transactional
    @Override
    public boolean deleteParticularProduct(String productId, String variantId, String merchantId,String email) {
         cartRepository.deleteByProductIdAndVariantIdAndMerchantIdAndEmail(productId,variantId,merchantId,email);
         return true;
    }

    @Override
    public List<Cart> getEverythingFromCart(String email) {
        return cartRepository.findAllByEmail(email);
    }

}
