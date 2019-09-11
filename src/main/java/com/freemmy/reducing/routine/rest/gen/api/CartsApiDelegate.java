package com.freemmy.reducing.routine.rest.gen.api;

import com.freemmy.reducing.routine.rest.gen.model.CartDTO;
import com.freemmy.reducing.routine.rest.gen.model.ItemDTO;
import com.freemmy.reducing.routine.rest.gen.model.NewItemDTO;
import org.springframework.http.ResponseEntity;

/**
 * A delegate to be called by the {@link CartsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface CartsApiDelegate {

    /**
     * @see CartsApi#addItem
     */
    ResponseEntity<ItemDTO> addItem(Long cartId, NewItemDTO newItemDTO);

    /**
     * @see CartsApi#getCart
     */
    ResponseEntity<CartDTO> getCart(Long cartId);

}
