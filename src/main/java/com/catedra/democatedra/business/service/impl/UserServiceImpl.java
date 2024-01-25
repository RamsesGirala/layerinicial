package com.catedra.democatedra.business.service.impl;

import com.catedra.democatedra.business.service.IUserService;
import com.catedra.democatedra.common.exeption.UserException;
import com.catedra.democatedra.common.util.constant.UserConstant;
import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.entity.Task;
import com.catedra.democatedra.domain.entity.User;
import com.catedra.democatedra.persistence.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDto,Long> implements IUserService {

    public UserServiceImpl(BaseRepository<User, Long> baseRepository) {
        super(baseRepository);
    }

    public void validateUserCanAssignService(List<Task> currentTasks, List<Task> tasksToDo){
        var timeInCurrentTasks = currentTasks.stream()
                .mapToInt(Task::getTimeRequiredToComplete)
                .sum();

        var timeInTasksToDo = tasksToDo.stream()
                .mapToInt(Task::getTimeRequiredToComplete)
                .sum();
        var totalTimeInTasks = timeInCurrentTasks + timeInTasksToDo;
        if(totalTimeInTasks > 8){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.CURRENT_USER_NOT_ALLOW_TO_DO_TASKS, totalTimeInTasks));
        }
    }

    public void validateAvaliabilityToDelete(User user){
        if(!user.getTasks().isEmpty()){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.CURRENT_USER_NOT_ALLOW_TO_DELETE, user.getName()));
        }
    }
}
