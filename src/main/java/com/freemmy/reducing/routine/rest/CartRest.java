package com.freemmy.reducing.routine.rest;

import com.freemmy.reducing.routine.domain.Cart;
import com.freemmy.reducing.routine.domain.Item;
import com.freemmy.reducing.routine.repository.ICartRepository;
import com.freemmy.reducing.routine.rest.converter.CartConverter;
import com.freemmy.reducing.routine.rest.converter.ItemConverter;
import com.freemmy.reducing.routine.rest.gen.api.CartsApiDelegate;
import com.freemmy.reducing.routine.rest.gen.model.CartDTO;
import com.freemmy.reducing.routine.rest.gen.model.ItemDTO;
import com.freemmy.reducing.routine.rest.gen.model.NewItemDTO;
import com.freemmy.reducing.routine.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/**
 * Date: 9/11/2019
 *
 * @author Dzmitry Dziokin
 */
@Component
@RequiredArgsConstructor
public class CartRest implements CartsApiDelegate {

    private final CartConverter cartConverter;
    private final ItemConverter itemConverter;
    private final ICartService cartService;
    private final ICartRepository cartRepository;

    @Override
    public ResponseEntity<ItemDTO> addItem(Long cartId, NewItemDTO newItemDTO) {
        Item item = cartService.addToCart(cartId, itemConverter.toEntity(newItemDTO));
        return ResponseEntity.ok(itemConverter.toDto(item));
    }

    @Override
    public ResponseEntity<CartDTO> getCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(NoSuchElementException::new);
        return ResponseEntity.ok(cartConverter.toDto(cart));
    }
}
