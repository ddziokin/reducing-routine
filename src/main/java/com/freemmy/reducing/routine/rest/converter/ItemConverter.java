package com.freemmy.reducing.routine.rest.converter;

import com.freemmy.reducing.routine.domain.Item;
import com.freemmy.reducing.routine.domain.Product;
import com.freemmy.reducing.routine.rest.gen.model.ItemDTO;
import com.freemmy.reducing.routine.rest.gen.model.NewItemDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Date: 9/3/2019
 *
 * @author Dzmitry Dziokin
 */
@Component
public class ItemConverter extends AbstractConverter<Item, NewItemDTO, ItemDTO> {

    @Autowired
    public ItemConverter(ModelMapper mapper) {
        super(mapper, Item.class, NewItemDTO.class, ItemDTO.class);
    }

    @PostConstruct
    private void adjustMapping() {
        getToEntityTypeMap()
                .addMappings(mapping -> mapping.skip(Item::setCart))
                .addMappings(mapping -> mapping
                        .using(productConverter())
                        .map(NewItemDTO::getProductId, Item::setProduct));
    }

    private static Converter<Long, Product> productConverter() {
        return context -> {
            Product product = new Product();
            product.setId(context.getSource());
            return product;
        };
    }
}
