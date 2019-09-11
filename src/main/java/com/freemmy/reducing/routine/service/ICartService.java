package com.freemmy.reducing.routine.service;

import com.freemmy.reducing.routine.domain.Item;

/**
 * Date: 9/9/2019
 *
 * @author Dzmitry Dziokin
 */
public interface ICartService {

    Item addToCart(long cartId, Item item);
}
