package com.freemmy.reducing.routine.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Date: 9/9/2019
 *
 * @author Dzmitry Dziokin
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Cart extends BaseEntity<Long> {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Item> items;

}
