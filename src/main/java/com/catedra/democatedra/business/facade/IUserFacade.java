package com.catedra.democatedra.business.facade;


import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.dto.UserValidatedDto;
import com.catedra.democatedra.domain.dto.UserWithTaskDTO;

import java.util.List;

public interface IUserFacade extends IBaseFacade<UserDto,Long> {

    void assignTasks(Long id, List<Long> tasksIds);

    UserWithTaskDTO getUserAndTask(Long userId, Long taskId);
    UserValidatedDto getUserValidated(Long userId);
}
