package com.personal.healthhacker.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.personal.healthhacker.Entity.UserLoginEntity;

@Repository
public interface UserLoginDao extends CrudRepository<UserLoginEntity, String> {

	default void updateLevelLogin() {
		 
	}
}
