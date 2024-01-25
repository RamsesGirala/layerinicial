package com.catedra.democatedra.business.service;

import com.catedra.democatedra.domain.dto.BaseDto;
import com.catedra.democatedra.domain.entity.Base;
import com.catedra.democatedra.domain.entity.Task;

import java.io.Serializable;
import java.util.List;

public interface BaseService <E extends Base, D extends BaseDto, ID extends Serializable>{
    E create(E user);
    E getById(ID id);
    List<E> getAll();
    void deleteById(ID id);
    E update(E user);
    void validateAvaliabilityToDelete(E entity);
}
