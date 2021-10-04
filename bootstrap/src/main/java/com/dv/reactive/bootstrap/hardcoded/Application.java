package com.dv.reactive.bootstrap.hardcoded;

import com.dv.reactive.bootstrap.Demo;

public class Application {

    public static void main(String[] args) {
        DevelopmentOnlyCustomerService customerService = new
                DevelopmentOnlyCustomerService();
        Demo.workWithCustomerService(Application.class, customerService);
    }
}
