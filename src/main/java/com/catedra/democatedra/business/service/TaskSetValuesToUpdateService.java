package com.catedra.democatedra.business.service;

import com.catedra.democatedra.domain.dto.request.TaskRequest;
import com.catedra.democatedra.domain.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskSetValuesToUpdateService {

    public void execute(TaskRequest request, Task currentTask){
        currentTask.setName(request.getName());
        currentTask.setDescription(request.getDescription());
        currentTask.setTimeRequiredToComplete(request.getTimeRequiredToComplete());
    }

}
