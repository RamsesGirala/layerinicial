package com.catedra.democatedra.business.facade;

import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.dto.request.TaskRequest;

import java.util.List;

public interface ITaskFacade {

    TaskDto createNew(TaskRequest request);
    TaskDto getById(Long id);
    List<TaskDto> getAll();
    void deleteById(Long id);
    TaskDto update(TaskRequest request, Long id);

}
