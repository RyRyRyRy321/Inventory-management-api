package com.spring_REST.controllers;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_REST.cart.Cart;
import com.spring_REST.cart.CartRepository;
import com.spring_REST.product.Product;
import com.spring_REST.product.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public ClientController(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("product")
    public Iterable<Product> getProduct(){

        logger.info("All products are fetch in the repository");

        return productRepository.findAll();
    }

    @GetMapping("product/{id}")
    public Product getSpecificProduct(@PathVariable Long id){

        logger.info("A specific product is fetch in the repository");


        return productRepository.findById(id).get();
    }

    @PostMapping("product")
    public ResponseEntity<Map<String,String>> newProduct(@Valid @RequestBody Product product, BindingResult bindingResult){
        
        if (bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }

            logger.error("Invalid creation of Product due to validation errors");

            return ResponseEntity.badRequest().body(errors);
        }
        
        productRepository.save(product);

        logger.info("Successfully created a product");

        
        return ResponseEntity.ok(null);
    }

    @GetMapping("cart")
    public Iterable<Cart> getCart(){
        return cartRepository.findAll();
    }


    @GetMapping("cart/{id}")
    public Cart getSpecificCart(@PathVariable Long id){
        return cartRepository.findById(id).get();
    }

}
