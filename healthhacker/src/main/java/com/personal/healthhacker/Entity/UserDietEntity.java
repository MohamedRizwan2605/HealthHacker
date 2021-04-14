package com.personal.healthhacker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDietEntity {
	
	@Id
	private int dietId;

	private String dietName;
	
	private String imageUrl;
	
	private String dietTitle;
	
	private String dietDescription;
	
	private String dietType;

	public int getDietId() {
		return dietId;
	}

	public void setDietId(int dietId) {
		this.dietId = dietId;
	}

	public String getDietName() {
		return dietName;
	}

	public void setDietName(String dietName) {
		this.dietName = dietName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDietTitle() {
		return dietTitle;
	}

	public void setDietTitle(String dietTitle) {
		this.dietTitle = dietTitle;
	}

	public String getDietDescription() {
		return dietDescription;
	}

	public void setDietDescription(String dietDescription) {
		this.dietDescription = dietDescription;
	}

	public String getDietType() {
		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}

}
