package com.catedra.democatedra.business.service;


import com.catedra.democatedra.common.exeption.UserException;
import com.catedra.democatedra.common.util.constant.UserConstant;
import com.catedra.democatedra.domain.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserValidateAvailabilityToDeleteService {

    public void execute(User user) {

        if(!user.getTasks().isEmpty()){
            throw new UserException(HttpStatus.BAD_REQUEST,
                    String.format(UserConstant.CURRENT_USER_NOT_ALLOW_TO_DELETE, user.getName()));
        }
    }

}
