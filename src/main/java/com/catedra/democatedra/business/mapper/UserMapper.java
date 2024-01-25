package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.dto.UserValidatedDto;
import com.catedra.democatedra.domain.dto.UserWithTaskDTO;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User,UserDto>{

    UserDto toDTO(User source);

    User toEntity(UserDto source);
    List<UserDto> toDTOsList(List<User> source);
    List<User> toEntitiesList(List<UserDto> source);

    //Implementa mapeo con callback de funcion para calcular una propiedad nueva de un DTO
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "puedeConducir", expression = "java(mapCanDrive(user))")
    UserValidatedDto toDtoValidated(User user);
    default boolean mapCanDrive(User user) {
        return user.getAge() > 18 && "argentina".equals(user.getCountry().toLowerCase());
    }
    //Implementa mapeo a un nuevo DTO desde 2 entidades combinadas(user y task)
    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "user.name", target = "user_name")
    @Mapping(source = "task.id", target = "task_id")
    @Mapping(source = "task.name", target = "task_name")
    UserWithTaskDTO toCombinedDto(User user, Task task);
}
