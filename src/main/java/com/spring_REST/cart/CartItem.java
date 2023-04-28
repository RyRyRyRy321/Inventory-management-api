package com.spring_REST.cart;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.spring_REST.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToMany
    @JoinColumn(name = "cartId", nullable = false)
    private List<Cart> cart;

    
    @ManyToMany
    @JoinColumn(name = "productId", nullable = false)
    private List<Product> product;

    private int quantity;
    private BigDecimal price;
    
    @CreationTimestamp
    private Date createdTimeStamp;

    @UpdateTimestamp
    private Date updatedTimeStamp;

        
    public CartItem() {
    }

    

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Date getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(Date updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }



    public List<Cart> getCart() {
        return cart;
    }



    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }



    public List<Product> getProduct() {
        return product;
    }



    public void setProduct(List<Product> product) {
        this.product = product;
    }

}
