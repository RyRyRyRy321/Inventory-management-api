package com.spring_REST;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import com.spring_REST.cart.Cart;
import com.spring_REST.cart.ShoppingCartStatus;
import com.spring_REST.customer.Customer;

public class CartTests {
    
    @Test
    public void testCartEmptyInstantiationNotNull(){
        
        Cart cart = new Cart();

        assertNotNull(cart);
    }

    @Test
    public void testCartInstantiatingNotNull(){
        
        Customer customer = new Customer("firstName","lastName","user@example.com","address","123456789");

        Cart cart = new Cart(customer,ShoppingCartStatus.ACTIVE,Date.valueOf("2022-01-01"),Date.valueOf("2022-01-01"));

        assertNotNull(cart);
    }
}
