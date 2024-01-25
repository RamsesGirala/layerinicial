package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<Task,TaskDto>{

    TaskDto toDTO(Task source);

    Task toEntity(TaskDto source);
    List<TaskDto> toDTOsList(List<Task> source);
    List<Task> toEntitiesList(List<TaskDto> source);
}
