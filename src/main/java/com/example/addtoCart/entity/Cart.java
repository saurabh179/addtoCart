package com.example.addtoCart.entity;


import javax.persistence.*;

@Entity
@Table(name = "cartTable")
public class Cart {

@Id
@GeneratedValue
private  Integer cartId;

@Column(name = "email")
private String email;


@Column(name = "productId")
private String productId;


@Column(name = "variantId")
private String variantId;


@Column(name="quantity")
private  Integer quantity;

@Column(name = "price")
private Integer price;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
