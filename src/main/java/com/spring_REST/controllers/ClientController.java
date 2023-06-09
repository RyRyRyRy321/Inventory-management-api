package com.spring_REST.controllers;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_REST.AddingCartServices;
import com.spring_REST.cart.Cart;
import com.spring_REST.cart.CartRepository;
import com.spring_REST.cart.ShoppingCartStatus;
import com.spring_REST.customer.Customer;
import com.spring_REST.customer.CustomerRepository;
import com.spring_REST.product.Product;
import com.spring_REST.product.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ProductRepository productRepository;
    private CartRepository cartRepository;

    @Autowired
    AddingCartServices addingCartServices;

    public ClientController(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping("product")
    public Iterable<Product> getProduct(){


        return productRepository.findAll();
    }

    @GetMapping("product/{id}")
    public Product getSpecificProduct(@PathVariable Long id){



        return productRepository.findById(id).get();
    }

    @PostMapping("product")
    public ResponseEntity<Map<String,String>> newProduct(@Valid @RequestBody Product product, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
    
            for(FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
    
            return ResponseEntity.badRequest().body(errors);
        }


        productRepository.save(product);
        System.out.println("Product created");

        return ResponseEntity.ok(null);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Map<String,String>> updateProduct(@PathVariable(value = "id") String productId, @Valid @RequestBody Product product, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
    
            for(FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
    
            return ResponseEntity.badRequest().body(errors);
        }

        Long updateProductId = Long.parseLong(productId);

        Product foundProduct = productRepository.findById(updateProductId).get();

        // productName
        // category
        // productDesc
        // stockAlertQuantity
        // unitPrice
        // discount
        // quantity
        // productPrice

        foundProduct.setProductName(product.getProductName());
        foundProduct.setCategory(product.getCategory());
        foundProduct.setProductDesc(product.getProductDesc());
        foundProduct.setStockAlertQuantity(product.getStockAlertQuantity());
        foundProduct.setUnitPrice(product.getUnitPrice());
        foundProduct.setDiscount(product.getDiscount());
        foundProduct.setQuantity(product.getQuantity());
        foundProduct.setProductPrice(product.getProductPrice());


        productRepository.save(foundProduct);
        System.out.println("Product updated");

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable(value = "id") String productId){
        productRepository.deleteById(Long.parseLong(productId));
        System.out.println("Product deleted");
    }
    
    @GetMapping("cart/{id}")
    public Cart getSpecificCart(@PathVariable Long id){
        return cartRepository.findById(id).get();
    }


    @PostMapping("customer")
    public ResponseEntity<Map<String,String>> addCustomer(@Valid @RequestBody Customer customer, BindingResult result){
        
        @Valid Cart cart = new Cart(customer, ShoppingCartStatus.ACTIVE);

        if (result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
    
            for(FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
    
            return ResponseEntity.badRequest().body(errors);
        }


        addingCartServices.addCustomer(customer, cart);

        return ResponseEntity.ok(null);
    }

}
