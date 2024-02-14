package com.catedra.democatedra.presentation.controller;


import com.catedra.democatedra.business.facade.ITaskFacade;
import com.catedra.democatedra.business.facade.impl.TaskFacadeImpl;
import com.catedra.democatedra.domain.dto.BaseDto;
import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.presentation.controller.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController extends BaseControllerImpl<Task,TaskDto,Long,TaskFacadeImpl> {
    public TaskController(TaskFacadeImpl facade) {
        super(facade);
    }

}
