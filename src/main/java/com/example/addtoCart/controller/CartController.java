package com.example.addtoCart.controller;


import com.example.addtoCart.model.CartDTO;
import com.example.addtoCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

  @Autowired
    CartService cartService;

    @RequestMapping("/addToCart")
    public CartDTO getEmployee(@RequestParam String email){
        return cartService.getCartById(email);
    }


    @PostMapping("/addToCart")
    public CartDTO createEmployee(@RequestBody CartDTO cartDTO){
        try {
            return cartService.createCart(cartDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PutMapping("/addToCart")
    public CartDTO updateEmployee(@RequestBody CartDTO employeeDTO){
        return cartService.updateCart(employeeDTO);
    }

    @DeleteMapping("/addToCart")
    public CartDTO deleteEmployee(@RequestParam String email){
        return cartService.deleteCart(email);
    }

}
