package com.example.addtoCart.controller;


import com.example.addtoCart.entity.Cart;
import com.example.addtoCart.model.CartDTO;
import com.example.addtoCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

  @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.GET , value="/getCart")
    public CartDTO getCart(@RequestParam String email){
        return cartService.getCartById(email);
    }


    @RequestMapping(method = RequestMethod.GET , value="/getEverythingFromCart")
    public List<Cart> getEverythingFromCart(@RequestParam String email){
        return cartService.getEverythingFromCart(email);
    }


    @RequestMapping(method = RequestMethod.POST , value = "/createCart")
    public boolean createCart(@RequestBody CartDTO cartDTO,@RequestParam String token) {

        return cartService.createCart(cartDTO,token);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProduct")
    public void removeProduct(@RequestParam String productId, @RequestParam String variantId,@RequestParam String merchantId, @RequestParam String email) {
        cartService.deleteParticularProduct(productId, variantId,merchantId, email);
    }



    @RequestMapping(method = RequestMethod.DELETE , value = "/deleteCart")
    public Boolean deleteCart(@RequestParam String email){
        return cartService.deleteCart(email);
    }




    @DeleteMapping(value = "/deleteParticularProductByemail")
    public boolean deleteCartFromOrder(@RequestParam String email ,@RequestParam String productId, @RequestParam String merchantId,@RequestParam String variantId){
     return cartService.deleteParticularProduct(productId, variantId, merchantId,email);
    }

}
