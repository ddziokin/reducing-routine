package com.freemmy.reducing.routine.rest;

import com.freemmy.reducing.routine.domain.Product;
import com.freemmy.reducing.routine.repository.IProductRepository;
import com.freemmy.reducing.routine.rest.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Date: 20/08/19
 *
 * @author Dzmitry Dziokin
 */
@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductRest {

    private final Converter<Product, ProductDTO> domainConverter;
    private final Converter<ProductDTO, Product> dtoConverter;
    private final IProductRepository productRepository;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(@PageableDefault Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        List<ProductDTO> dtoList = productPage.stream()
                .map(domainConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new PageImpl<>(dtoList, productPage.getPageable(), productPage.getTotalElements()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(domainConverter.convert(product));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        Product result = productRepository.save(dtoConverter.convert(product));
        return new ResponseEntity<>(domainConverter.convert(result), HttpStatus.CREATED);
    }
}
