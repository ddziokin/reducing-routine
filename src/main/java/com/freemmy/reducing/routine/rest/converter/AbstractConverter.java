package com.freemmy.reducing.routine.rest.converter;

import com.freemmy.reducing.routine.domain.Identifiable;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.util.Objects;

/**
 * Date: 15/08/19
 *
 * @author Dzmitry Dziokin
 */
public abstract class AbstractConverter<E extends Identifiable<Long>, DTO_IN, DTO_OUT>
        implements IConverter<E, DTO_IN, DTO_OUT> {

    private final ModelMapper mapper;

    private final Class<E> entityClass;
    private final Class<DTO_IN> dtoInClass;
    private final Class<DTO_OUT> dtoOutClass;

    AbstractConverter(ModelMapper mapper, Class<E> entityClass, Class<DTO_IN> dtoInClass,
            Class<DTO_OUT> dtoOutClass) {
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoInClass = dtoInClass;
        this.dtoOutClass = dtoOutClass;
        mapper.createTypeMap(dtoInClass, entityClass)
                .addMappings(mapping -> mapping.skip(E::setId));
        mapper.createTypeMap(entityClass, dtoOutClass);
    }

    @Override
    public E toEntity(DTO_IN dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, entityClass);
    }

    @Override
    public DTO_OUT toDto(E entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, dtoOutClass);
    }

    ModelMapper getMapper() {
        return mapper;
    }

    TypeMap<DTO_IN, E> getToEntityTypeMap() {
        return mapper.getTypeMap(dtoInClass, entityClass);
    }

    TypeMap<E, DTO_OUT> getToDtoTypeMap() {
        return mapper.getTypeMap(entityClass, dtoOutClass);
    }
}
