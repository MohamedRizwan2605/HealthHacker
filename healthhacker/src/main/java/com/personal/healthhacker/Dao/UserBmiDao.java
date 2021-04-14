package com.personal.healthhacker.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.healthhacker.Entity.UserBmiEntity;
import com.personal.healthhacker.Entity.UserLevelEntity;

@Repository
public interface UserBmiDao extends CrudRepository<UserBmiEntity, Integer> {

}
