package com.catedra.democatedra.business.mapper;


import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    TaskDto toDto(Task domain);

}
