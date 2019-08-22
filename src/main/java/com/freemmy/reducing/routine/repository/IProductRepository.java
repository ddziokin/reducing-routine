package com.freemmy.reducing.routine.repository;

import com.freemmy.reducing.routine.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Date: 12/08/19
 *
 * @author Dzmitry Dziokin
 */
@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

}
