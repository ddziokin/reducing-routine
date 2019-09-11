package com.freemmy.reducing.routine.rest.gen.api;

import com.freemmy.reducing.routine.rest.gen.model.CreatedProductDTO;
import com.freemmy.reducing.routine.rest.gen.model.ErrorDTO;
import com.freemmy.reducing.routine.rest.gen.model.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/** * A delegate to be called by the {@link ProductsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface ProductsApiDelegate {

    /**     * @see ProductsApi#addProduct
     */
    ResponseEntity<CreatedProductDTO
> addProduct(ProductDTO productDTO);

    /**     * @see ProductsApi#getProduct
     */
    ResponseEntity<CreatedProductDTO
> getProduct(Long productId);

    /**     * @see ProductsApi#getProducts
     */
    ResponseEntity<Page<CreatedProductDTO>
> getProducts(Pageable pageable);

}
