package com.catedra.democatedra.business.facade.impl;


import com.catedra.democatedra.business.facade.ITaskFacade;
import com.catedra.democatedra.business.mapper.TaskDtoMapper;
import com.catedra.democatedra.business.mapper.TaskRequestMapper;
import com.catedra.democatedra.business.service.ITaskService;
import com.catedra.democatedra.business.service.TaskSetValuesToUpdateService;
import com.catedra.democatedra.business.service.TaskValidateAvailabilityToDeleteService;
import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.dto.request.TaskRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskFacade implements ITaskFacade {

    private final ITaskService iTaskService;
    private final TaskRequestMapper taskRequestMapper;
    private final TaskDtoMapper taskDtoMapper;
    private final TaskValidateAvailabilityToDeleteService taskValidateAvailabilityToDeleteService;
    private final TaskSetValuesToUpdateService taskSetValuesToUpdateService;
    public TaskFacade(ITaskService iTaskService,
                      TaskRequestMapper taskRequestMapper,
                      TaskDtoMapper taskDtoMapper,
                      TaskValidateAvailabilityToDeleteService taskValidateAvailabilityToDeleteService, TaskSetValuesToUpdateService taskSetValuesToUpdateService) {
        this.iTaskService = iTaskService;
        this.taskRequestMapper = taskRequestMapper;
        this.taskDtoMapper = taskDtoMapper;
        this.taskValidateAvailabilityToDeleteService = taskValidateAvailabilityToDeleteService;
        this.taskSetValuesToUpdateService = taskSetValuesToUpdateService;
    }

    public TaskDto createNew(TaskRequest request){
// Convierte a entidad
        var taskToCreate = taskRequestMapper.toDomain(request);
// Graba una entidad
        var taskCreated = iTaskService.create(taskToCreate);
// convierte a Dto para devolver
        return taskDtoMapper.toDto(taskCreated);
    }

    public TaskDto getById(Long id){
// Busca una yarea por Id
        var task = iTaskService.getById(id);
// convierte la entidad a DTO
        return taskDtoMapper.toDto(task);
    }

    public List<TaskDto> getAll(){
        // trae una entidad de lista de tareas
        var tasks = iTaskService.getAll();
        //  devuelve una lista de DTO
        return tasks
                .stream()
                .map(taskDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){

        var task = iTaskService.getById(id);

        taskValidateAvailabilityToDeleteService.execute(task);

        iTaskService.deleteById(id);
    }

    public TaskDto update(TaskRequest request, Long id){

        var taskToUpdate = taskRequestMapper.toDomain(request);

        taskSetValuesToUpdateService.execute(request, taskToUpdate);

        var taskUpdated = iTaskService.update(taskToUpdate);

        return taskDtoMapper.toDto(taskUpdated);
    }

}
