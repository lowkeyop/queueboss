package com.lowkeyop.fun.utilities.models;

import java.util.UUID;

public class Player implements Person {

	String firstName;
	String lastName;
	int skillLevel;
	String id;
	
	public Player() {
		// TODO Auto-generated constructor stub
		this.firstName = "";
		this.lastName = "";
		this.skillLevel = 0;
		this.id = UUID.randomUUID().toString();
	}

	public Player(String firstName, String lastName, int skillLevel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.skillLevel=skillLevel;
		this.id = UUID.randomUUID().toString();
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

	

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void displayFullInfo() {
		// TODO Auto-generated method stub
		System.out.println(this.firstName + " " + this.lastName);
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player test1 = new Player();
		Player values = new Player("Cordell", "Kennerly", 3);
		System.out.println("The default Player" + test1.getId());
		System.out.println("The constructed one: " + values.getId());
	}
	

	
}
