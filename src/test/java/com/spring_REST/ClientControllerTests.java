package com.spring_REST;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring_REST.controllers.ClientController;
import com.spring_REST.customer.CustomerRepository;
import com.spring_REST.product.ProductRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;



@WebMvcTest(ClientController.class)
public class ClientControllerTests {
    
    @Autowired
    private MockMvc clientMockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private ProductRepository productRepository;


    String clientControllerRequestMapping = "/client";


    String clientCustomerMapping = "/customer";
    String clientProductMapping = "/product";

    String customerTemplate = clientControllerRequestMapping + clientCustomerMapping;
    String productTemplate = clientControllerRequestMapping + clientProductMapping;

    @Test
    public void testCustomerRequestReturnsStatus200(){

        try {
            clientMockMvc.perform(MockMvcRequestBuilders.get(customerTemplate))
            .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void testCustomerRequestReturnsContentTypeJSON(){

        try {
            clientMockMvc.perform(MockMvcRequestBuilders.get(customerTemplate))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void testProductRequestReturnsStatus200(){

        try {
            clientMockMvc.perform(MockMvcRequestBuilders.get(productTemplate))
            .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Test
    public void testProductRequestReturnsContentTypeJSON(){

        try {
            clientMockMvc.perform(MockMvcRequestBuilders.get(productTemplate))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
