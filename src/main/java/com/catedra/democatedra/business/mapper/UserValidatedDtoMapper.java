package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.UserValidatedDto;
import com.catedra.democatedra.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserValidatedDtoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "puedeConducir", expression = "java(mapCanDrive(user))")
    UserValidatedDto toDto(User user);

    default boolean mapCanDrive(User user) {
        return user.getAge() > 18 && "argentina".equals(user.getCountry().toLowerCase());
    }

}
