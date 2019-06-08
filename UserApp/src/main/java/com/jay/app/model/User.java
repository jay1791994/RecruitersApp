package com.jay.app.model;

import java.util.List;
import java.util.Random;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserDocument")
public class User {
	
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getVisaStatus() {
		return VisaStatus;
	}
	public void setVisaStatus(String visaStatus) {
		VisaStatus = visaStatus;
	}
	public boolean isOpentorelocation() {
		return Opentorelocation;
	}
	public void setOpentorelocation(boolean opentorelocation) {
		Opentorelocation = opentorelocation;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public List<String> getPreffredLocation() {
		return preffredLocation;
	}
	public void setPreffredLocation(List<String> preffredLocation) {
		this.preffredLocation = preffredLocation;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	private String name ;
	private int age;
	private String email;
	private String expertise;
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	private String VisaStatus;
	private String currentLocation;
	private boolean Opentorelocation;
	private int experience;
    private List<String> preffredLocation;
	
	
	@Id
	private String userId = getRandomeUserId();;
	
	public String getName() {
		return name;
	}
	private static String getRandomeUserId() {
		
	   Random ren = new Random();
	   String charArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcedefghijklmnopqrstuvwxyz";
	   String newId= "";
	   
	   for(int i=0 ; i < 12 ; i++) {
		   newId = newId +charArr.charAt(ren.nextInt(62));
	   }
	   
	   
	   
	   return newId;
	   
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void changeMyId() {
	 
		 this.userId = getRandomeUserId();
	}
	
	
	
	
}
