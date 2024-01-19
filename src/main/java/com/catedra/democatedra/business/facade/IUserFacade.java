package com.catedra.democatedra.business.facade;


import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.dto.UserValidatedDto;
import com.catedra.democatedra.domain.dto.UserWithTaskDTO;
import com.catedra.democatedra.domain.dto.request.UserRequest;

import java.util.List;

public interface IUserFacade {

    UserDto createNew(UserRequest request);
    UserDto getById(Long id);
    List<UserDto> getAll();
    void deleteById(Long id);
    UserDto update(UserRequest request, Long id);
    void assignTasks(Long id, List<Long> tasksIds);

    UserWithTaskDTO getUserAndTask(Long userId, Long taskId);
    UserValidatedDto getUserValidated(Long userId);
}
