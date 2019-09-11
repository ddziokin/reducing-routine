package com.freemmy.reducing.routine.service.impl;

import com.freemmy.reducing.routine.domain.Cart;
import com.freemmy.reducing.routine.domain.Item;
import com.freemmy.reducing.routine.repository.ICartRepository;
import com.freemmy.reducing.routine.service.ICartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 9/9/2019
 *
 * @author Dzmitry Dziokin
 */
@Service
@Transactional(rollbackFor = Throwable.class)
@Slf4j
@RequiredArgsConstructor
public class CartService implements ICartService {

    private final ICartRepository cartRepository;

    @Override
    public Item addToCart(long cartId, Item item) {
        Cart userCart = getOrCreateCart(cartId);
        if (CollectionUtils.isEmpty(userCart.getItems())) {
            List<Item> items = new ArrayList<>();
            items.add(item);
            userCart.setItems(items);
        } else {
            userCart.getItems().add(item);
        }
        List<Item> items = cartRepository.save(userCart).getItems();
        Item createdItem = items.get(items.size() - 1);
        log.info("Item [{}] successfully added to the cart [{}]", createdItem, userCart);
        return createdItem;
    }

    private Cart getOrCreateCart(long cartId) {
        return cartRepository.findById(cartId).orElseGet(() -> createCart(cartId));
    }

    private Cart createCart(long cartId) {
        Cart cart = new Cart();
        cart.setId(cartId);
        Cart savedCart = cartRepository.save(cart);
        log.info("New cart is created: [{}]", cart);
        return savedCart;
    }
}
