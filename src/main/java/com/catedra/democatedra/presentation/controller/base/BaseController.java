package com.catedra.democatedra.presentation.controller.base;

import com.catedra.democatedra.domain.dto.BaseDto;

import java.io.Serializable;
import java.util.List;

public interface BaseController <D extends BaseDto, ID extends Serializable>{

    D getById(ID id);
    List<D> getAll();
    D create(D entity);
    D edit(D entity);
    void deleteById(ID id);

}
