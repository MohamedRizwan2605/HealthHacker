package com.personal.healthhacker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.healthhacker.Dao.UserBmiDao;
import com.personal.healthhacker.Dao.UserDietDao;
import com.personal.healthhacker.Dao.UserWorkoutDao;
import com.personal.healthhacker.Entity.UserBmiEntity;
import com.personal.healthhacker.Entity.UserDietEntity;
import com.personal.healthhacker.Entity.UserLoginEntity;
import com.personal.healthhacker.Entity.UserWorkoutEntity;

@Service
public class UserWorkoutService {

	@Autowired
	private UserWorkoutDao userWorkoutDao;
	
	public String saveWorkoutEntity(UserWorkoutEntity userWorkoutEntity) {
		userWorkoutDao.save(userWorkoutEntity);
		return "Saved Workout Alhamdulillah";
	}
}
