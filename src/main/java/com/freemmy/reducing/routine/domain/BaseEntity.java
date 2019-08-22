package com.freemmy.reducing.routine.domain;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Date: 08/08/19
 *
 * @author Dzmitry Dziokin
 */
@Data
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Identifiable<ID> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private ID id;
}
