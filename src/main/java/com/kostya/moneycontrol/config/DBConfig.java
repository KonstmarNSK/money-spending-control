package com.kostya.moneycontrol.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.kostya.moneycontrol.data")
@EntityScan(basePackages = "com.kostya.moneycontrol.data.model")
public class DBConfig {
    @Bean
    public DataSource dataSource() {
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        return dataSourceLookup.getDataSource("java:jboss/datasources/ExampleDS");
    }
}
