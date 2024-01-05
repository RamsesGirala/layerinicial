package com.catedra.democatedra.business.service;


import com.catedra.democatedra.domain.dto.request.UserRequest;
import com.catedra.democatedra.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserSetValuesToUpdateService {

    public void execute(UserRequest request, User currentUser){
        currentUser.setName(request.getName());
        currentUser.setAge(request.getAge());
        currentUser.setCountry(request.getCountry());
    }

}
