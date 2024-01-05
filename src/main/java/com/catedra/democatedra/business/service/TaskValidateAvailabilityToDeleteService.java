package com.catedra.democatedra.business.service;

import com.catedra.democatedra.common.exeption.UserException;
import com.catedra.democatedra.common.util.constant.TaskConstant;
import com.catedra.democatedra.domain.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskValidateAvailabilityToDeleteService {

    public void execute(Task task) {

        if(!task.getUsers().isEmpty()){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(TaskConstant.CURRENT_TASK_NOT_ALLOW_TO_DELETE, task.getId()));
        }
    }

}
