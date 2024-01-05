package com.catedra.democatedra.business.service.impl;

import com.catedra.democatedra.business.service.IUserService;
import com.catedra.democatedra.common.exeption.UserException;
import com.catedra.democatedra.common.util.constant.UserConstant;
import com.catedra.democatedra.domain.entity.User;
import com.catedra.democatedra.persistence.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {

        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        var optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()){
            throw new UserException(HttpStatus.NOT_FOUND,
                    String.format(UserConstant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
        }

        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {

        return userRepository.save(user);
    }

}
