package com.spring_REST.cart;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import com.spring_REST.customer.Customer;


    /**
     * Cart is an Entity class to represent in a relational database. Each customer has a single cart, and it can store multiple cartItem 
     */

@Entity
public class Cart {

    /**
     * This represents the primary ID for the cart
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer Customer;

    /**
     * refers to the status of the cart and the value is related to {@code com.spring_REST.cart.ShoppingCartStatus}
     */
    @NotNull
    @Enumerated(EnumType.STRING)
    private ShoppingCartStatus status;

    @NotNull
    @CreationTimestamp
    private Date createdTimeStamp;

    @NotNull
    @UpdateTimestamp
    private Date updatedTimeStamp;

    /**
     * Constructs an empty cart
     */

    public Cart() {

    }

    /**
     * Constructs a cart with user-defined values
     * 
     * @param customer the entity class {@code com.spring_REST.customer}
     * @param status the status of the shopping cart
     * @param createdTimeStamp the date and time when the object is created
     * @param updatedTimeStamp the date and time when the object is modified
     */

    public Cart(com.spring_REST.customer.Customer customer, ShoppingCartStatus status, Date createdTimeStamp,
            Date updatedTimeStamp) {
        Customer = customer;
        this.status = status;
        this.createdTimeStamp = createdTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }



    /**
     * Returns the primary ID of the cart.
     */

    public Long getCartId() {
        return cartId;
    }

    /**
     * Sets the primary ID of the cart.
     * 
     * @param cartId The new cartId for the cart.
     */

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }

    public ShoppingCartStatus getStatus() {
        return status;
    }

    public void setStatus(ShoppingCartStatus status) {
        this.status = status;
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

    
}
