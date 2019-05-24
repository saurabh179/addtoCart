package com.example.addtoCart.controller;


import com.example.addtoCart.model.CartDTO;
import com.example.addtoCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

  @Autowired
    CartService cartService;

    @RequestMapping(method = RequestMethod.GET , value="/getCart")
    public CartDTO getCart(@RequestParam String email){
        return cartService.getCartById(email);
    }


    @RequestMapping(method = RequestMethod.POST , value = "/createCart")
    public CartDTO createCart(@RequestBody CartDTO cartDTO) {
        return cartService.createCart(cartDTO);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/removeProduct")
    public void removeProduct(@RequestParam String productId, @RequestParam String variantId, @RequestParam String email) {
        cartService.deleteParticularProduct(productId, variantId, email);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/deleteCart")
    public CartDTO deleteCart(@RequestParam String email){
        return cartService.deleteCart(email);
    }

}
