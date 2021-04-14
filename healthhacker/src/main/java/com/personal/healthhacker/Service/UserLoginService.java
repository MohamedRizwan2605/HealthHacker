package com.personal.healthhacker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.healthhacker.Dao.UserBmiDao;
import com.personal.healthhacker.Dao.UserLoginDao;
import com.personal.healthhacker.Entity.UserBmiEntity;
import com.personal.healthhacker.Entity.UserLevelEntity;
import com.personal.healthhacker.Entity.UserLoginEntity;

@Service
public class UserLoginService {

	@Autowired
	private UserLoginDao userLoginDao;
	
	public String saveLoginEntity(UserLoginEntity userLoginEntity) {
		userLoginDao.save(userLoginEntity);
		return "Saved Login";
	}
	
	public Iterable<UserLoginEntity> delAllValues() {
		// TODO Auto-generated method stub
		userLoginDao.deleteAll();
		return null;
	}
}
