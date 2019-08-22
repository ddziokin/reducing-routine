package com.freemmy.reducing.routine.rest.converter;

import static org.junit.Assert.assertEquals;

import com.freemmy.reducing.routine.domain.Product;
import com.freemmy.reducing.routine.rest.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link ProductDomainToDTOConverter}.
 * <p/>
 * 8/27/2019
 *
 * @author Dzmitry Dziokin
 */
@RunWith(SpringRunner.class)
public class ProductDomainToDTOConverterTest {

    private ProductDomainToDTOConverter converter = new ProductDomainToDTOConverter();

    @Test
    public void shouldConvert() {
        assertEquals("Conversion result should be as expected", buildProductDTO(), converter.convert(buildProduct()));
    }

    private Product buildProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setManufacturer("manufacturer");
        product.setName("name");
        return product;
    }

    private ProductDTO buildProductDTO() {
        ProductDTO product = new ProductDTO();
        product.setId(1L);
        product.setManufacturer("manufacturer");
        product.setName("name");
        return product;
    }
}
