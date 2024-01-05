package com.catedra.democatedra.business.mapper;

import com.catedra.democatedra.domain.dto.request.TaskRequest;
import com.catedra.democatedra.domain.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskRequestMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    Task toDomain(TaskRequest request);

}
