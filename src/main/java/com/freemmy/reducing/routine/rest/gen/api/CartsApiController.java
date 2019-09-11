package com.freemmy.reducing.routine.rest.gen.api;

import org.springframework.stereotype.Controller;

@Controller
public class CartsApiController implements CartsApi {

    private final CartsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public CartsApiController(CartsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public CartsApiDelegate getDelegate() {
        return delegate;
    }
}
