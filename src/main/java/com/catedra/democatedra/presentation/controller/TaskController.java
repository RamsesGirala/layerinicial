package com.catedra.democatedra.presentation.controller;


import com.catedra.democatedra.business.facade.ITaskFacade;
import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.dto.request.TaskRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final ITaskFacade iTaskFacade;

    public TaskController(ITaskFacade iTaskFacade) {
        this.iTaskFacade = iTaskFacade;
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id){
        return iTaskFacade.getById(id);
    }

    @GetMapping
    public List<TaskDto> getAll() {
        return iTaskFacade.getAll();
    }

    @PostMapping()
    public TaskDto create(@RequestBody TaskRequest taskRequest){
        return
                iTaskFacade.createNew(taskRequest);
    }

    @PutMapping("/{id}")
    public TaskDto edit(@RequestBody TaskRequest taskRequest,
                        @PathVariable Long id){
        return iTaskFacade.update(taskRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        iTaskFacade.deleteById(id);
    }

}
