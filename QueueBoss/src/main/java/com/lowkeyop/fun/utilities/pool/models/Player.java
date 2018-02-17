package com.lowkeyop.fun.utilities.pool.models;

import java.util.UUID;

public class Player {
	private String firstName, lastName, uid;
	private int skillLevel, timeouts;

	public Player(String firstName, String lastName, int skillLevel) {
		super();
		this.setUid(UUID.randomUUID().toString());
		this.firstName = firstName;
		this.lastName = lastName;
		this.skillLevel = skillLevel;
		if(this.skillLevel <4) {
			this.setTimeouts(2);
		} else
			this.setTimeouts(1);
	}

	public Player() {
		super();
		this.firstName = "";
		this.lastName = "";
		this.skillLevel = 4;
		this.setTimeouts(1);
		// TODO Auto-generated constructor stub
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public int getTimeouts() {
		return timeouts;
	}

	public void setTimeouts(int timeouts) {
		this.timeouts = timeouts;
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}
}
