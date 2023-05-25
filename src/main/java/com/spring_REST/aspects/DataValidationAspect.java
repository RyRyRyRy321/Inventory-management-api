package com.spring_REST.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class DataValidationAspect {

    @Pointcut("execution(* com.spring_REST.controllers.ClientController(com.example.Product, int)) && args(product, quantity)")
    public void getNewProductPointCut(){

    }

    


}
