package com.freemmy.reducing.routine.rest.converter;

import com.freemmy.reducing.routine.domain.Product;
import com.freemmy.reducing.routine.rest.gen.model.CreatedProductDTO;
import com.freemmy.reducing.routine.rest.gen.model.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Date: 9/2/2019
 *
 * @author Dzmitry Dziokin
 */
@Component
public class ProductConverter extends AbstractConverter<Product, ProductDTO, CreatedProductDTO> {

    @Autowired
    protected ProductConverter(ModelMapper mapper) {
        super(mapper, Product.class, ProductDTO.class, CreatedProductDTO.class);
    }
}
