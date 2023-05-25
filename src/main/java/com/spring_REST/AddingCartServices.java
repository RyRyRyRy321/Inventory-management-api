package com.spring_REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring_REST.cart.Cart;
import com.spring_REST.cart.CartRepository;
import com.spring_REST.cart.ShoppingCartStatus;
import com.spring_REST.customer.Customer;
import com.spring_REST.customer.CustomerRepository;

@Service
@Transactional
public class AddingCartServices {
    
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;


    public AddingCartServices(){

    }
    
    
    public void addCustomer(Customer customer, Cart cart){
        customerRepository.save(customer);
        cartRepository.save(cart);        
    }




}
