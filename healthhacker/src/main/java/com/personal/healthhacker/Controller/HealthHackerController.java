package com.personal.healthhacker.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.healthhacker.Entity.UserBmiEntity;
import com.personal.healthhacker.Entity.UserDetailsEntity;
import com.personal.healthhacker.Entity.UserDietEntity;
import com.personal.healthhacker.Entity.UserLevelEntity;
import com.personal.healthhacker.Entity.UserLoginEntity;
import com.personal.healthhacker.Entity.UserWorkoutEntity;
import com.personal.healthhacker.Service.UserBmiService;
import com.personal.healthhacker.Service.UserDetailsService;
import com.personal.healthhacker.Service.UserDietService;
import com.personal.healthhacker.Service.UserLevelService;
import com.personal.healthhacker.Service.UserLoginService;
import com.personal.healthhacker.Service.UserWorkoutService;

@RestController
@EntityScan("com.personal.healthhacker.Entity")
@EnableJpaRepositories("com.personal.healthhacker.Dao")
@RequestMapping(path ="/hack")
@CrossOrigin(origins = "http://localhost:3000")
public class HealthHackerController {
	
	@Autowired
	private UserLevelService userLevelService;
	
	@Autowired
	private UserWorkoutService userWorkoutService;
	
	@Autowired
	private UserDietService userDietService;
	
	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private UserBmiService userBmiService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping(path="/addLevel")
	public @ResponseBody List<UserLoginEntity> addNewUser (@RequestBody UserLevelEntity userLevelEntity,
			@RequestParam String mailId) {
		return userLevelService.saveLevelEntity(userLevelEntity,mailId);
	}
	
	@GetMapping(path="/getLevel")
	public @ResponseBody List<UserLoginEntity> getAllUsers(@RequestParam String mailId) {
		return userLevelService.findAllValues(mailId);
	}
	
	@DeleteMapping(path="/deleteAllLevels")
	public @ResponseBody void delAllUsers() {
		 userLevelService.delAllValues();
	}
	
	@DeleteMapping(path="/deleteLevel")
	public @ResponseBody void delLevelById(@RequestParam int lvlId) {
		userLevelService.delLvlById(lvlId);
	}
 
	@PostMapping(path="/addBmi") 
	public @ResponseBody List<UserLoginEntity> addBmi (@RequestBody UserBmiEntity userBmiEntity,
			@RequestParam String mailId) throws Exception {
		return userBmiService.saveBmiEntity(userBmiEntity,mailId);
	}
	
	@GetMapping(path="/getBmi")
	public @ResponseBody List<UserLoginEntity> getAllBmi(@RequestParam String mailId) {
		return userBmiService.findAllValues(mailId);
	}
	
	@DeleteMapping(path="/deleteAllBmi")
	public @ResponseBody void delAllBmi() {
		 userBmiService.delAllValues();
	}
	
	@DeleteMapping(path="/deleteBmi")
	public @ResponseBody void delBmi(@RequestParam int bmiId) {
		 userBmiService.delBmiById(bmiId);
	}
	
	@PostMapping(path="/addWorkout")
	public @ResponseBody String addWorkout (@RequestBody UserWorkoutEntity userWorkoutEntity) {
		return userWorkoutService.saveWorkoutEntity(userWorkoutEntity);
	}
	
	@PostMapping(path="/addDiet")
	public @ResponseBody String addDiet (@RequestBody UserDietEntity userDietEntity) {
		return userDietService.saveDietEntity(userDietEntity);
	}
	
	@PostMapping(path="/addDetails/{levelId}")
	public @ResponseBody String addDetails (@RequestBody UserDetailsEntity userDetailsEntity, @PathVariable Integer levelId) {
		return userDetailsService.saveDetailsEntitiy(userDetailsEntity,levelId);
	}
	
	@GetMapping(path="/getDetails/{levelId}")
	public @ResponseBody List<UserLevelEntity> getDetails ( @PathVariable Integer levelId) {
		return userDetailsService.fetchDetailsEntitiy(levelId);
	}
	
	
	@PostMapping(path="/addLogin")
	public @ResponseBody String addLogin (@RequestBody UserLoginEntity userLoginEntity) {
		return userLoginService.saveLoginEntity(userLoginEntity);
	}
	
	@DeleteMapping(path="/deleteAllLoginLevels")
	public @ResponseBody Iterable<UserLoginEntity> delAllLoginUsers() {
		return userLoginService.delAllValues();
	}

	
	
//	public @ResponseBody List<> 
}
