package com.catedra.democatedra.business.service;

import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.domain.entity.User;

import java.util.List;

public interface IUserService extends BaseService<User, UserDto,Long>{

    void validateUserCanAssignService(List<Task> currentTasks, List<Task> tasksToDo);

}
