package com.personal.healthhacker.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.healthhacker.Dao.UserBmiDao;
import com.personal.healthhacker.Dao.UserLoginDao;
import com.personal.healthhacker.Entity.UserBmiEntity;
import com.personal.healthhacker.Entity.UserLevelEntity;
import com.personal.healthhacker.Entity.UserLoginEntity;

@Service
public class UserBmiService {

	@Autowired
	private UserBmiDao userBmiDao;

	@Autowired
	private UserLoginDao userLoginDao;

	UserLoginEntity userLoginEntity = new UserLoginEntity();

	public List<UserLoginEntity> saveBmiEntity(UserBmiEntity userBmiEntity, String mailId) {
//		userBmiDao.save(userBmiEntity);
		Optional<UserLoginEntity> loginOpt = userLoginDao.findById(mailId);
		List<UserLoginEntity> loginList=convertToList(loginOpt);
		if(!loginList.isEmpty()) {
			UserLoginEntity userLoginEntity= loginList.get(0);
			userLoginEntity.setUserBmiEntity(userBmiEntity);
			userLoginDao.save(userLoginEntity);
		}
		Optional<UserLoginEntity> loginsavedOpt = userLoginDao.findById(mailId);
		List<UserLoginEntity> loginSavedList=convertToList(loginsavedOpt);
		
		return loginSavedList;
	}

	public static <T> List<T> convertToList(Optional<T> opt) {
		return opt
				.map(Collections::singletonList)
				.orElseGet(Collections::emptyList);
	}

	public List<UserLoginEntity> findAllValues(String mailId) {
		// TODO Auto-generated method stub
		Optional<UserLoginEntity> loginLevelOpt = userLoginDao.findById(mailId);
		List<UserLoginEntity> loginList=convertToList(loginLevelOpt);
		if(!loginList.isEmpty()) {
			return loginList;
		}
		return null;
	}

	public void delAllValues() {
		// TODO Auto-generated method stub
		userBmiDao.deleteAll();
	}

	public void delBmiById(int bmiId) {
		Optional<UserLoginEntity> loginOpt = userLoginDao.findById("bismillah");
		List<UserLoginEntity> logList= convertToList(loginOpt);
		userLoginDao.delete(logList.get(0));
	}
}
