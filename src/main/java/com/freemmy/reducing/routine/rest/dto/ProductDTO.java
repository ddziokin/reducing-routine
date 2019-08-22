package com.freemmy.reducing.routine.rest.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Date: 8/27/2019
 *
 * @author Dzmitry Dziokin
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProductDTO {

    private Long id;
    private String manufacturer;
    private String name;
}
