package com.freemmy.reducing.routine.rest.converter;

import com.freemmy.reducing.routine.domain.Identifiable;

import java.io.Serializable;

/**
 * Date: 15/08/19
 *
 * @author Dzmitry Dziokin
 */
public interface IConverter<E extends Identifiable<? extends Serializable>, DTO_IN, DTO_OUT> {

    E toEntity(DTO_IN dto);

    DTO_OUT toDto(E entity);
}
