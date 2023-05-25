package com.spring_REST.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring_REST.controllers.ClientController;


@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Pointcut("execution(* com.spring_REST.controllers.ClientController.*.*(..)))")
    public void getProductPointCut(){
        
    }

    @After("getProductPointCut()")
    public void beforePrintLog(){
        logger.info("Customer added to database");
    }
    
}
