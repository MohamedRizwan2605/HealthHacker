package com.personal.healthhacker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserWorkoutEntity {
	
	@Id
	private int workoutId;

	private String workoutName;
	
	private String imageUrl;
	
	private String workoutTitle;
	
	private String workoutDescription;
	
	private String workoutType;

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getWorkoutTitle() {
		return workoutTitle;
	}

	public void setWorkoutTitle(String workoutTitle) {
		this.workoutTitle = workoutTitle;
	}

	public String getWorkoutDescription() {
		return workoutDescription;
	}

	public void setWorkoutDescription(String workoutDescription) {
		this.workoutDescription = workoutDescription;
	}

	public String getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(String workoutType) {
		this.workoutType = workoutType;
	}
	
}
