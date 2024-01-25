package com.catedra.democatedra.business.facade.impl;

import com.catedra.democatedra.business.facade.IBaseFacade;
import com.catedra.democatedra.business.mapper.BaseMapper;
import com.catedra.democatedra.business.service.BaseService;
import com.catedra.democatedra.domain.dto.BaseDto;
import com.catedra.democatedra.domain.entity.Base;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseFacadeImpl<E extends Base,D extends BaseDto,ID extends Serializable> implements IBaseFacade<D,ID> {

    protected BaseService<E,D,ID> baseService;
    protected BaseMapper<E,D> baseMapper;

    public BaseFacadeImpl(BaseService<E,D,ID> baseService, BaseMapper<E,D> baseMapper) {
        this.baseService = baseService;
        this.baseMapper = baseMapper;
    }

    public D createNew(D request){
        // Convierte a entidad
        var entityToCreate = baseMapper.toEntity(request);
        // Graba una entidad
        var entityCreated = baseService.create(entityToCreate);
        // convierte a Dto para devolver
        return baseMapper.toDTO(entityCreated);
    }

    public D getById(ID id){
        // Busca una yarea por Id
        var entity = baseService.getById(id);
        // convierte la entidad a DTO
        return baseMapper.toDTO(entity);
    }

    public List<D> getAll(){
        // trae una entidad de lista de tareas

        var entities = baseService.getAll();
        //  devuelve una lista de DTO
        return entities
                .stream()
                .map(baseMapper::toDTO)
                .collect(Collectors.toList());

    }

    public void deleteById(ID id){
        var entity = baseService.getById(id);
        baseService.validateAvaliabilityToDelete(entity);
        baseService.deleteById(id);
    }

    public D update(D request, ID id){
        var entityToUpdate = baseMapper.toEntity(request);
        var entityUpdated = baseService.update(entityToUpdate);
        return baseMapper.toDTO(entityUpdated);
    }

}
