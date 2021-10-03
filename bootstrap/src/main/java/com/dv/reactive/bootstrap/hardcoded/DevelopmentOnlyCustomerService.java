package com.dv.reactive.bootstrap.hardcoded;

import com.dv.reactive.bootstrap.BaseCustomerService;
import com.dv.reactive.bootstrap.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class DevelopmentOnlyCustomerService extends BaseCustomerService {

    public DevelopmentOnlyCustomerService() {
        super(buildDataSource());
    }

    private static DataSource buildDataSource() {
        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2).build();
        return DataSourceUtils.initializeDdl(dataSource);
    }
}
