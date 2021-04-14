package com.personal.healthhacker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.healthhacker.Dao.UserBmiDao;
import com.personal.healthhacker.Dao.UserDietDao;
import com.personal.healthhacker.Entity.UserBmiEntity;
import com.personal.healthhacker.Entity.UserDietEntity;
import com.personal.healthhacker.Entity.UserLoginEntity;

@Service
public class UserDietService {

	@Autowired
	private UserDietDao userDietDao;
	
	public String saveDietEntity(UserDietEntity userDietEntity) {
		userDietDao.save(userDietEntity);
		return "Saved Diet Alhamdulillah";
	}
}
