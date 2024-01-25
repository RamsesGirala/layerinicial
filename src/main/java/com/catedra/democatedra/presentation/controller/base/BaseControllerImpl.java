package com.catedra.democatedra.presentation.controller.base;

import com.catedra.democatedra.business.facade.impl.BaseFacadeImpl;
import com.catedra.democatedra.domain.dto.BaseDto;
import com.catedra.democatedra.domain.entity.Base;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseControllerImpl<E extends Base,D extends BaseDto, ID extends Serializable, F extends BaseFacadeImpl<E,D,ID>> implements BaseController<D,ID>  {

    protected F facade;
    public BaseControllerImpl(F facade){
        this.facade = facade;
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable ID id){
        return facade.getById(id);
    }

    @GetMapping
    public List<D> getAll() {
        return facade.getAll();
    }

    @PostMapping()
    public D create(@RequestBody D entity){
        return facade.createNew(entity);
    }

    @PutMapping("/{id}")
    public D edit(@RequestBody D entity, @PathVariable ID id){
        return facade.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id){
        facade.deleteById(id);
    }

}
