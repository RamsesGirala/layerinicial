package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.request.UserRequest;
import com.catedra.democatedra.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    // recibe el json convierte a objeto
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    User toDomain(UserRequest request);
}
