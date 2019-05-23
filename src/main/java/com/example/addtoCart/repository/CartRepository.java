package com.example.addtoCart.repository;


import com.example.addtoCart.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<CartEntity,String> {


}
