package com.catedra.democatedra.presentation.controller;


import com.catedra.democatedra.business.facade.IUserFacade;
import com.catedra.democatedra.business.facade.impl.UserFacadeImpl;
import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.dto.UserValidatedDto;
import com.catedra.democatedra.domain.dto.UserWithTaskDTO;
import com.catedra.democatedra.domain.entity.User;
import com.catedra.democatedra.presentation.controller.base.BaseControllerImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends BaseControllerImpl<User,UserDto,Long, UserFacadeImpl> {

    private final IUserFacade iUserFacade;

    public UserController(IUserFacade iUserFacade,UserFacadeImpl facade) {
        super(facade);
        this.iUserFacade = iUserFacade;
    }


    @GetMapping("/{userId}/{taskId}")
    public UserWithTaskDTO getUserAndTask(@PathVariable Long userId,@PathVariable Long taskId){
        return iUserFacade.getUserAndTask(userId,taskId);
    }

    @GetMapping("/isValid/{userId}")
    public UserValidatedDto getUserValidated(@PathVariable Long userId){
        return iUserFacade.getUserValidated(userId);
    }

    //REVISAR ESTO
    @Override
    public UserDto edit(UserDto entity) {
        return null;
    }
}
