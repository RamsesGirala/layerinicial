package com.catedra.democatedra.business.mapper;


import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    // Recibe objeto convierte a Json
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    UserDto toDto(User domain);

}
