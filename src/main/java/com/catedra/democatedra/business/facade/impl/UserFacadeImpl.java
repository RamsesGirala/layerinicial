package com.catedra.democatedra.business.facade.impl;

import com.catedra.democatedra.business.facade.IUserFacade;
import com.catedra.democatedra.business.mapper.*;
import com.catedra.democatedra.business.service.*;
import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.dto.UserValidatedDto;
import com.catedra.democatedra.domain.dto.UserWithTaskDTO;
import com.catedra.democatedra.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFacadeImpl extends BaseFacadeImpl<User,UserDto,Long> implements IUserFacade {

    private final ITaskService iTaskService;
    private final IUserService iUserService;
    private final UserMapper userMapper;

    public UserFacadeImpl(BaseService<User, UserDto, Long> baseService,
                          BaseMapper<User, UserDto> baseMapper,
                          ITaskService iTaskService,
                          IUserService iUserService,
                          UserMapper userMapper) {
        super(baseService, baseMapper);
        this.iTaskService = iTaskService;
        this.iUserService = iUserService;
        this.userMapper = userMapper;
    }

    public void assignTasks(Long id, List<Long> tasksIds) {

        var user = iUserService.getById(id);

        var tasksToDo = iTaskService.getByIds(tasksIds);

        iUserService.validateUserCanAssignService(new ArrayList<>(user.getTasks()), tasksToDo);

        user.getTasks().addAll(tasksToDo);

        iUserService.update(user);

    }

    public UserWithTaskDTO getUserAndTask(Long userId, Long taskId){
        var user = iUserService.getById(userId);
        var task = iTaskService.getById(taskId);
        return userMapper.toCombinedDto(user,task);
    }

    public UserValidatedDto getUserValidated(Long userId){
        var user = iUserService.getById(userId);
        return  userMapper.toDtoValidated(user);
    }

}
