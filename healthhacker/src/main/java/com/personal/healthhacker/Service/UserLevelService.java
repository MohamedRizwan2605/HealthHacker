package com.personal.healthhacker.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.healthhacker.Dao.UserLevelDao;
import com.personal.healthhacker.Dao.UserLoginDao;
import com.personal.healthhacker.Entity.UserLevelEntity;
import com.personal.healthhacker.Entity.UserLoginEntity;

@Service
public class UserLevelService {

	@Autowired
	private UserLevelDao userLevelDao;

	@Autowired
	private UserLoginDao userLoginDao;

	public List<UserLoginEntity> saveLevelEntity(UserLevelEntity userLevelEntity, String mailId) {
//		userLevelDao.save(userLevelEntity);
		
		Optional<UserLoginEntity> loginOpt = userLoginDao.findById(mailId);
		List<UserLoginEntity> loginList=convertToList(loginOpt);
		if(!loginList.isEmpty()) {
			UserLoginEntity userLoginEntity= loginList.get(0);
			userLoginEntity.setUserLevelEntity(userLevelEntity);
			userLoginDao.save(userLoginEntity);
		}
		
		Optional<UserLoginEntity> loginsavedOpt = userLoginDao.findById(mailId);
		List<UserLoginEntity> loginSavedList=convertToList(loginsavedOpt);
		
		return loginSavedList;
	}

	public List<UserLoginEntity> findAllValues(String mailId) {
		Optional<UserLoginEntity> loginLevelOpt = userLoginDao.findById(mailId);
		List<UserLoginEntity> loginList=convertToList(loginLevelOpt);
		if(!loginList.isEmpty()) {
			return loginList;
		}
		return null;
	}

	public static <T> List<T> convertToList(Optional<T> opt) {
		return opt
				.map(Collections::singletonList)
				.orElseGet(Collections::emptyList);
	}

	public void delAllValues() {
		userLevelDao.deleteAll();
	}

	public void delLvlById(int lvlId) {
		Optional<UserLoginEntity> loginOpt = userLoginDao.findById("bismillah");
		List<UserLoginEntity> logList= convertToList(loginOpt);
		userLoginDao.delete(logList.get(0));
	}
}
