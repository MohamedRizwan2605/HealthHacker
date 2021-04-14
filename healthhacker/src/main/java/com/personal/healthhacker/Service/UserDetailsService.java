package com.personal.healthhacker.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.healthhacker.Dao.UserDetailsDao;
import com.personal.healthhacker.Dao.UserLevelDao;
import com.personal.healthhacker.Entity.UserDetailsEntity;
import com.personal.healthhacker.Entity.UserLevelEntity;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	@Autowired
	private UserLevelDao userLevelDao;
	
	public String saveDetailsEntitiy(UserDetailsEntity userDetailsEntity, Integer levelId) {
		Optional<UserLevelEntity> valOpt = userLevelDao.findById(levelId);
		List<UserLevelEntity> levelList=convertToList(valOpt);
		if(!levelList.isEmpty()) {
			UserLevelEntity userLevelEntity = levelList.get(0);
			userLevelEntity.addLevel(userDetailsEntity);
			userLevelDao.save(userLevelEntity);
		}
		return "Saved Details";
	}
	
	public static <T> List<T> convertToList(Optional<T> opt) {
		return opt
				.map(Collections::singletonList)
				.orElseGet(Collections::emptyList);
	}

	public List<UserLevelEntity> fetchDetailsEntitiy(Integer levelId) {
		// TODO Auto-generated method stub
		Optional<UserLevelEntity> levelValOpt = userLevelDao.findById(levelId);
		List<UserLevelEntity> levelList=convertToList(levelValOpt);
		if(!levelList.isEmpty()) {
			return levelList;
		}
		
		return null;
	}
}
