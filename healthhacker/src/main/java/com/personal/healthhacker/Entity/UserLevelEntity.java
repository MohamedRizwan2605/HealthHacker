package com.personal.healthhacker.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class UserLevelEntity {

	@Id
	private int levelId;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="detail_level_id")
	private List<UserDetailsEntity> userWorkoutDetailsList;

	private String startDate;
	
	private String endDate;

	private int dailyHours;

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getDailyHours() {
		return dailyHours;
	}

	public void setDailyHours(int dailyHours) {
		this.dailyHours = dailyHours;
	}


	public List<UserDetailsEntity> getUserWorkoutDetailsList() {
		return userWorkoutDetailsList;
	}

	public void setUserWorkoutDetailsList(List<UserDetailsEntity> userWorkoutDetailsList) {
		this.userWorkoutDetailsList = userWorkoutDetailsList;
	}

	public void addLevel(UserDetailsEntity userDetailsEntity) {
		if (userWorkoutDetailsList == null) {
			userWorkoutDetailsList = new ArrayList<UserDetailsEntity>();
		}
		userWorkoutDetailsList.add(userDetailsEntity);

	}


}
