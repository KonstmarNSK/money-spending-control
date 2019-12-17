package com.kostya.moneycontrol.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = "com.kostya.moneycontrol.data")
@EntityScan(basePackages = "com.kostya.moneycontrol.data.model")
public class DBConfig {
/*    @Autowired
    @Bean
    public SessionFactory getSessionFactoryBean(EntityManagerFactory emFactory) {
        SessionFactory sessionFactory = emFactory.unwrap(SessionFactory.class);
        if (sessionFactory == null) {
            throw new IllegalStateException("No hibernate session factory in the context");
        }

        return sessionFactory;
    }*/
}
