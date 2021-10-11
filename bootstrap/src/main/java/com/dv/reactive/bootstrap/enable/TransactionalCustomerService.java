package com.dv.reactive.bootstrap.enable;

import com.dv.reactive.bootstrap.BaseCustomerService;
import com.dv.reactive.bootstrap.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Collection;

@Service
@Transactional
public class TransactionalCustomerService extends BaseCustomerService {

    public TransactionalCustomerService(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Collection<Customer> save(String... names) {
        return super.save(names);
    }

    @Override
    public Customer findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Collection<Customer> findAll() {
        return super.findAll();
    }
}
