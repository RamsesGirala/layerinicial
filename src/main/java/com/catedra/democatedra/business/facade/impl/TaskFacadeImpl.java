package com.catedra.democatedra.business.facade.impl;


import com.catedra.democatedra.business.facade.ITaskFacade;
import com.catedra.democatedra.business.mapper.BaseMapper;
import com.catedra.democatedra.business.service.BaseService;
import com.catedra.democatedra.domain.dto.TaskDto;
import com.catedra.democatedra.domain.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskFacadeImpl extends BaseFacadeImpl<Task,TaskDto,Long> implements ITaskFacade {


    public TaskFacadeImpl(BaseService<Task, TaskDto, Long> baseService, BaseMapper<Task, TaskDto> baseMapper) {
        super(baseService, baseMapper);
    }
}
