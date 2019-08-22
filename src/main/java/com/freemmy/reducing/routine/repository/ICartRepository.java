package com.freemmy.reducing.routine.repository;

import com.freemmy.reducing.routine.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Date: 8/27/2019
 *
 * @author Dzmitry Dziokin
 */
@Repository
public interface ICartRepository extends CrudRepository<Cart, Long> {

}
