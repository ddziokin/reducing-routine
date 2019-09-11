package com.freemmy.reducing.routine.rest.gen.api;

import org.springframework.stereotype.Controller;

@Controller
public class ProductsApiController implements ProductsApi {

    private final ProductsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductsApiController(ProductsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public ProductsApiDelegate getDelegate() {
        return delegate;
    }
}
