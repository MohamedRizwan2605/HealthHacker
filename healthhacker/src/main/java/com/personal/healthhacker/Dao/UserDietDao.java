package com.personal.healthhacker.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.healthhacker.Entity.UserDietEntity;
import com.personal.healthhacker.Entity.UserLevelEntity;

@Repository
public interface UserDietDao extends CrudRepository<UserDietEntity, Integer> {

}
