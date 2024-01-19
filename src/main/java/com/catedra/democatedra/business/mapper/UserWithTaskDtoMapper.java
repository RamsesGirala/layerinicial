package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.UserWithTaskDTO;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserWithTaskDtoMapper {

    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "user.name", target = "user_name")
    @Mapping(source = "task.id", target = "task_id")
    @Mapping(source = "task.name", target = "task_name")
    UserWithTaskDTO toCombinedDto(User user, Task task);
}
