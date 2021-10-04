package com.dv.reactive.bootstrap.basicdi;

import com.dv.reactive.bootstrap.CustomerService;
import com.dv.reactive.bootstrap.DataSourceUtils;
import com.dv.reactive.bootstrap.Demo;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class Application {

    public static void main(String[] args) {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .build();

        DataSource initDataSource = DataSourceUtils.initializeDdl(dataSource);
        CustomerService service = new DataSourceCustomerService(initDataSource);
        Demo.workWithCustomerService(Application.class, service);
    }
}
