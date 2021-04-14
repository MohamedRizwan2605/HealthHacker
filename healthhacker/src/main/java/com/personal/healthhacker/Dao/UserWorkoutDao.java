package com.personal.healthhacker.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.healthhacker.Entity.UserWorkoutEntity;

@Repository
public interface UserWorkoutDao extends CrudRepository<UserWorkoutEntity, Integer> {

}
