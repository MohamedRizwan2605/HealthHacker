package com.personal.healthhacker.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UserDetailsEntity {

	@Id
	private String workDtlName;
	
	private String workoutTimer;
	
	private int progressPercent;
	
	private int caloriesBurnt;
	
	private int weightPredictor;
	
	private Date prcDate;

	public String getWorkDtlName() {
		return workDtlName;
	}

	public void setWorkDtlName(String workDtlName) {
		this.workDtlName = workDtlName;
	}

	public String getWorkoutTimer() {
		return workoutTimer;
	}

	public void setWorkoutTimer(String workoutTimer) {
		this.workoutTimer = workoutTimer;
	}

	public int getProgressPercent() {
		return progressPercent;
	}

	public void setProgressPercent(int progressPercent) {
		this.progressPercent = progressPercent;
	}

	public int getCaloriesBurnt() {
		return caloriesBurnt;
	}

	public void setCaloriesBurnt(int caloriesBurnt) {
		this.caloriesBurnt = caloriesBurnt;
	}

	public int getWeightPredictor() {
		return weightPredictor;
	}

	public void setWeightPredictor(int weightPredictor) {
		this.weightPredictor = weightPredictor;
	}


	public Date getPrcDate() {
		return prcDate;
	}

	public void setPrcDate(Date prcDate) {
		this.prcDate = prcDate;
	}	
	
	
}
