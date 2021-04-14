package com.personal.healthhacker.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserLoginEntity {
	
	@Id
	private String mailId;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_level_entity_level_id")
	private UserLevelEntity userLevelEntity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_bmi_entity_bmi_id")
	private UserBmiEntity userBmiEntity;
	
	private String password;

	private String firstName;
	
	private String lastName;
	
	private boolean isLogged;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public UserBmiEntity getUserBmiEntity() {
		return userBmiEntity;
	}

	public void setUserBmiEntity(UserBmiEntity userBmiEntity) {
		this.userBmiEntity = userBmiEntity;
	}
	
	public UserLevelEntity getUserLevelEntity() {
		return userLevelEntity;
	}

	public void setUserLevelEntity(UserLevelEntity userLevelEntity) {
		this.userLevelEntity = userLevelEntity;
	}
}
