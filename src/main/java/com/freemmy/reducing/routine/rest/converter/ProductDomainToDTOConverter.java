package com.freemmy.reducing.routine.rest.converter;

import com.freemmy.reducing.routine.domain.Product;
import com.freemmy.reducing.routine.rest.dto.ProductDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Date: 8/27/2019
 *
 * @author Dzmitry Dziokin
 */
@Component
public class ProductDomainToDTOConverter implements Converter<Product, ProductDTO> {

    @Override
    public ProductDTO convert(Product source) {
        ProductDTO target = new ProductDTO();
        target.setId(source.getId());
        target.setManufacturer(source.getManufacturer());
        target.setName(source.getName());
        return target;
    }
}
