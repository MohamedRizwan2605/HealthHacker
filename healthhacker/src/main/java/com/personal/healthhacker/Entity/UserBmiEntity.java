package com.personal.healthhacker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBmiEntity {
	
	@Id
	private int bmiId;
	
//	@OneToOne(mappedBy = "userBmiEntity")
//	private UserLoginEntity userLoginEntity;
	
	private double height;
	
	private double weight;
	
	private int age;

	public int getBmiId() {
		return bmiId;
	}

	public void setBmiId(int bmiId) {
		this.bmiId = bmiId;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
