package com.spring_REST;

import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


public class CustomSequenceGenerator implements IdentifierGenerator {


    public CustomSequenceGenerator() {

    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
    
}