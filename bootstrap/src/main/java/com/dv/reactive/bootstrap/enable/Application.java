package com.dv.reactive.bootstrap.enable;

import com.dv.reactive.bootstrap.CustomerService;
import com.dv.reactive.bootstrap.DataSourceConfiguration;
import com.dv.reactive.bootstrap.Demo;
import com.dv.reactive.bootstrap.SpringUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan
@Import(DataSourceConfiguration.class)
public class Application {

    @Bean
    PlatformTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }
    @Bean
    TransactionTemplate transactionTemplate(PlatformTransactionManager tm) {
        return new TransactionTemplate(tm);
    }

    public static void main(String args[]) {
        ConfigurableApplicationContext applicationContext = SpringUtils
                .run(Application.class, "prod");
        CustomerService customerService = applicationContext
                .getBean(CustomerService.class);
        Demo.workWithCustomerService(Application.class, customerService);
    }
}
