package com.catedra.democatedra.persistence;


import com.catedra.democatedra.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}