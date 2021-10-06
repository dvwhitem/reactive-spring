package com.dv.reactive.bootstrap.context;

import com.dv.reactive.bootstrap.CustomerService;
import com.dv.reactive.bootstrap.DataSourceConfiguration;
import com.dv.reactive.bootstrap.Demo;
import com.dv.reactive.bootstrap.SpringUtils;
import com.dv.reactive.bootstrap.templates.TransactionTemplateCustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@Import(DataSourceConfiguration.class)
public class Application {

    @Bean
    PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    TransactionTemplateCustomerService customerService(DataSource dataSource, TransactionTemplate template) {
        return new TransactionTemplateCustomerService(dataSource, template);
    }

    @Bean
    TransactionTemplate transactionTemplate(PlatformTransactionManager tm) {
        return new TransactionTemplate(tm);
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringUtils.run(Application.class, "prod");

        CustomerService service = applicationContext.getBean(CustomerService.class);
        Demo.workWithCustomerService(Application.class, service);
    }
}
