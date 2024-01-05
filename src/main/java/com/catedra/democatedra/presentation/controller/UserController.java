package com.catedra.democatedra.presentation.controller;


import com.catedra.democatedra.business.facade.IUserFacade;
import com.catedra.democatedra.domain.dto.UserDto;
import com.catedra.democatedra.domain.dto.request.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserFacade iUserFacade;

    public UserController(IUserFacade iUserFacade) {

        this.iUserFacade = iUserFacade;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id){

        return iUserFacade.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll() {

        return iUserFacade.getAll();
    }

    @PostMapping()
    public UserDto create(@RequestBody UserRequest taskRequest){

        return iUserFacade.createNew(taskRequest);
    }

    @PutMapping("/{id}")
    public UserDto userEdit(@RequestBody UserRequest taskRequest,
                            @PathVariable Long id){
        return
                iUserFacade.update(taskRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){

        iUserFacade.deleteById(id);
    }

    @PostMapping("/{id}/tasks")
    public void assignTasks(@PathVariable Long id ,
                            @RequestParam List<Long> tasksIds){
        iUserFacade.assignTasks(id, tasksIds);
    }

}
