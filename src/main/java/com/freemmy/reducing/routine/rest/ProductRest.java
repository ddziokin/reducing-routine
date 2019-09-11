package com.freemmy.reducing.routine.rest;

import com.freemmy.reducing.routine.domain.Product;
import com.freemmy.reducing.routine.repository.IProductRepository;
import com.freemmy.reducing.routine.rest.converter.ProductConverter;
import com.freemmy.reducing.routine.rest.gen.api.ProductsApiDelegate;
import com.freemmy.reducing.routine.rest.gen.model.CreatedProductDTO;
import com.freemmy.reducing.routine.rest.gen.model.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Date: 20/08/19
 *
 * @author Dzmitry Dziokin
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductRest implements ProductsApiDelegate {

    private final IProductRepository productRepository;
    private final ProductConverter productConverter;

    public ResponseEntity<Page<CreatedProductDTO>> getProducts(@PageableDefault Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        List<CreatedProductDTO> dtoList = productPage.stream()
                .map(productConverter::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new PageImpl<>(dtoList, productPage.getPageable(), productPage.getTotalElements()));
    }

    public ResponseEntity<CreatedProductDTO> getProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(productConverter.toDto(product));
    }

    public ResponseEntity<CreatedProductDTO> addProduct(@RequestBody ProductDTO product) {
        Product result = productRepository.save(productConverter.toEntity(product));
        return new ResponseEntity<>(productConverter.toDto(result), HttpStatus.CREATED);
    }
}
