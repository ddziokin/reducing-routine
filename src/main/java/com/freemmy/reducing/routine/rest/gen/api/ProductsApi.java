/*** NOTE: This class is auto generated by the swagger code generator program (3.3.4).
* https://github.com/swagger-api/swagger-codegen
* Do not edit the class manually.
*/
package com.freemmy.reducing.routine.rest.gen.api;

import com.freemmy.reducing.routine.rest.gen.model.CreatedProductDTO;
import com.freemmy.reducing.routine.rest.gen.model.ErrorDTO;
import com.freemmy.reducing.routine.rest.gen.model.ProductDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
    import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

    import javax.validation.Valid;
    import javax.validation.constraints.*;
import java.util.List;

@Api(value = "Products", description = "the Products API")
public interface ProductsApi {
    ProductsApiDelegate getDelegate();

    @ApiOperation(value = "Create a product", nickname = "addProduct", notes = "", response = CreatedProductDTO.class, tags={ "products", })

    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "OK", response = CreatedProductDTO.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
        consumes = { "application/json" },
    method = RequestMethod.POST)
    default ResponseEntity<CreatedProductDTO
> addProduct(
@ApiParam(value = "" ,required=true )  @Valid @RequestBody ProductDTO productDTO) {
        return getDelegate().addProduct(productDTO);
    }


    @ApiOperation(value = "Get prodcut by its ID", nickname = "getProduct", notes = "", response = CreatedProductDTO.class, tags={ "products", })

    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Requested product.", response = CreatedProductDTO.class),
        @ApiResponse(code = 404, message = "Product not found.", response = ErrorDTO.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorDTO.class) })
    @RequestMapping(value = "/products/{product_id}",
        produces = { "application/json" }, 
    method = RequestMethod.GET)
    default ResponseEntity<CreatedProductDTO
> getProduct(
@ApiParam(value = "ID of the product.",required=true) @PathVariable("product_id") Long productId) {
        return getDelegate().getProduct(productId);
    }


    @ApiOperation(value = "List all products", nickname = "getProducts", notes = "", response = CreatedProductDTO.class, responseContainer = "List", tags={ "products", })
        @ApiImplicitParams({
        @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
        value = "Results page you want to retrieve (0..N)."),
        @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
        value = "Number of records per page."),
        @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
        value = "Sorting criteria in the format: property(,asc|desc). " +
        "Default sort order is ascending. Multiple sort criteria are supported.")
        })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A paged array of products", response = CreatedProductDTO.class, responseContainer = "List"),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorDTO.class) })
    @RequestMapping(value = "/products",
        produces = { "application/json" }, 
    method = RequestMethod.GET)
    default ResponseEntity<Page<CreatedProductDTO>
> getProducts(@ApiIgnore @PageableDefault final Pageable pageable) {
        return getDelegate().getProducts(pageable);
    }

}
