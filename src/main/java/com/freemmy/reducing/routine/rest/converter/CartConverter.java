package com.freemmy.reducing.routine.rest.converter;

import com.freemmy.reducing.routine.domain.Cart;
import com.freemmy.reducing.routine.rest.gen.model.CartDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 9/2/2019
 *
 * @author Dzmitry Dziokin
 */
@Component
public class CartConverter extends AbstractConverter<Cart, CartDTO, CartDTO> {

    @Autowired
    protected CartConverter(ModelMapper mapper) {
        super(mapper, Cart.class, CartDTO.class, CartDTO.class);
    }
}
