package com.example.addtoCart.repository;


import com.example.addtoCart.entity.Cart;
import com.example.addtoCart.model.CartDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart,String> {
    void deleteByProductIdAndVariantIdAndMerchantIdAndEmail(String ProductId, String VariantId, String merchantId,String email);

    List<Cart> findAllByEmail(String email);

    void deleteAllByEmail(String email);


}
