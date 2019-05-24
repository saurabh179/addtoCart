package com.example.addtoCart.repository;


import com.example.addtoCart.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,String> {
    void deleteByProductIdAndVariantIdAndEmail(String ProductId, String VariantId, String email);
}
