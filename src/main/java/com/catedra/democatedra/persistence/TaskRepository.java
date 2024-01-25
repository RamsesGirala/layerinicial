package com.catedra.democatedra.persistence;

import com.catedra.democatedra.domain.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepository<Task, Long> {
    List<Task> findByIdIn(List<Long> tasksIds);
}