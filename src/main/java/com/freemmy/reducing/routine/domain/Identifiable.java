package com.freemmy.reducing.routine.domain;

import java.io.Serializable;

/**
 * Date: 08/08/19
 *
 * @author Dzmitry Dziokin
 */
public interface Identifiable<ID extends Serializable> {

    ID getId();

    void setId(ID id);
}
