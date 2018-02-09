package me.zhulin.SecurityWebApp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Represents for the user
// Java Bean implements Serializable
public class UserAccount implements Serializable {
	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";
	
	// private attributes
	private String userName;
	private String gender;
	private String password;
	
	private List<String> roles;
	
	// No-argument constructor
	public UserAccount() {
		
	}
	
	public UserAccount(String userName, String password, String gender, String... roles) {
		this.userName = userName;
		this.gender = gender;
		this.password = password;
		
		this.roles = new ArrayList<>();
		if(roles != null) {
			for(String role : roles) {
				this.roles.add(role);
			}
		}
	}
	
	// Setters / getters
	public String getUserName() {
		return this.userName;
	}
	public String getGender() {
		return this.gender;
	}
	public String getPassword() {
		return this.password;
	}
	public List<String> getRoles() {
		return this.roles;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRoles(List<String> roles) {
		this.roles  = roles;
	}
	
}
