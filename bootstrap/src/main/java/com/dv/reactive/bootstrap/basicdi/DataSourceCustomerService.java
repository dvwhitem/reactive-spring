package com.dv.reactive.bootstrap.basicdi;

import com.dv.reactive.bootstrap.BaseCustomerService;

import javax.sql.DataSource;

public class DataSourceCustomerService extends BaseCustomerService  {

    public DataSourceCustomerService(DataSource dataSource) {
        super(dataSource);
    }
}
