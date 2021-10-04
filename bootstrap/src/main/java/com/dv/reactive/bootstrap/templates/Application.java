package com.dv.reactive.bootstrap.templates;

import com.dv.reactive.bootstrap.DataSourceUtils;
import com.dv.reactive.bootstrap.Demo;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

public class Application {

    public static void main(String[] args) {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();

        DataSource initDataSource = DataSourceUtils.initializeDdl(dataSource);
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(initDataSource);
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        TransactionTemplateCustomerService customerService =
                new TransactionTemplateCustomerService(
                  initDataSource, transactionTemplate
                );

        Demo.workWithCustomerService(Application.class, customerService);
    }
}
