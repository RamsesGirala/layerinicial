package com.catedra.democatedra.business.service.impl;


import com.catedra.democatedra.business.service.ITaskService;
import com.catedra.democatedra.common.exeption.UserException;
import com.catedra.democatedra.common.util.constant.TaskConstant;
import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.persistence.BaseRepository;
import com.catedra.democatedra.persistence.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskDto,Long> implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;
    public TaskServiceImpl(BaseRepository<Task, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Task> getByIds(List<Long> tasksIds) {

        return taskRepository.findByIdIn(tasksIds);

    }

    public void validateAvaliabilityToDelete(Task task) {
        if(!task.getUsers().isEmpty()){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(TaskConstant.CURRENT_TASK_NOT_ALLOW_TO_DELETE, task.getId()));
        }
    }

}
