package com.catedra.democatedra.business.service;


import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.domain.entity.User;

import java.util.List;

public interface ITaskService extends BaseService<Task, TaskDto,Long>{
    List<Task> getByIds(List<Long> tasksIds);
}
