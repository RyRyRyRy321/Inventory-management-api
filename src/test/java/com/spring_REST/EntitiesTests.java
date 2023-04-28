package com.spring_REST;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class EntitiesTests {
    

    private CustomSequenceGenerator customSequenceGenerator = new CustomSequenceGenerator();
    

    @Test
    public void testCustomSequenceGeneratorGenerateIsNotNull(){

        Object object = new Object();

        String uuid = (String) customSequenceGenerator.generate(null, object);

        assertNotNull(uuid);

    }

    @Test
    public void testCustomSequenceGeneratorGenerateReturnsStringClass(){
        Object object = new Object();

        String uuid = (String) customSequenceGenerator.generate(null, object);

        assertTrue(uuid instanceof String);
    }

    

}
