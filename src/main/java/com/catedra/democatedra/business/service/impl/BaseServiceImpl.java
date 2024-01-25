package com.catedra.democatedra.business.service.impl;

import com.catedra.democatedra.business.service.BaseService;
import com.catedra.democatedra.common.exeption.UserException;
import com.catedra.democatedra.common.util.constant.UserConstant;
import com.catedra.democatedra.domain.dto.BaseDto;
import com.catedra.democatedra.domain.entity.Base;
import com.catedra.democatedra.domain.entity.User;
import com.catedra.democatedra.persistence.BaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public abstract class BaseServiceImpl<E extends Base,D extends BaseDto,ID extends Serializable> implements BaseService<E,D, ID> {

    protected BaseRepository<E, ID> baseRepository;
    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public E create(E entity) {
        return baseRepository.save(entity);
    }

    @Override
    public E getById(ID id) {
        var optionalEntity = baseRepository.findById(id);

        if (optionalEntity.isEmpty()){
            throw new RuntimeException();
        }
        return optionalEntity.get();
    }

    @Override
    public List<E> getAll() {
        return baseRepository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public E update(E entity) {
        return baseRepository.save(entity);
    }

}
