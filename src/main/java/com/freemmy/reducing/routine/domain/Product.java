package com.freemmy.reducing.routine.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Date: 20/08/19
 *
 * @author Dzmitry Dziokin
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Product extends BaseEntity<Long> {

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private String name;

}
