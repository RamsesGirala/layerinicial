package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.BaseDto;
import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.entity.Base;
import com.catedra.democatedra.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

public interface BaseMapper<E extends Base,D extends BaseDto>{
    D toDTO(E source);

    E toEntity(D source);
    List<D> toDTOsList(List<E> source);
    List<E> toEntitiesList(List<D> source);
}