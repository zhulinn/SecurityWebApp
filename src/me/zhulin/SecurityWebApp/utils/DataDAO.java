package me.zhulin.SecurityWebApp.utils;

import java.util.HashMap;
import java.util.Map;

import me.zhulin.SecurityWebApp.bean.UserAccount;
import me.zhulin.SecurityWebApp.config.SecurityConfig;


public class DataDAO {
	//Simulate a database
	// userName -> User
	 private static final Map<String, UserAccount> mapUsers = new HashMap<>();
	 
	 static {
		 initUser();
	 }
	 
	 private static void initUser() {
		 // User 1 as employee
		 UserAccount emp = new UserAccount("employee1", "123", UserAccount.GENDER_MALE,
				 SecurityConfig.ROLE_EMPLOYEE);
		 
		 // User 2 as employee and manager
		 UserAccount mng = new UserAccount("manager1", "123", UserAccount.GENDER_FEMALE, 
				 SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);
		 
		 mapUsers.put(emp.getUserName(), emp);
		 mapUsers.put(mng.getUserName(), mng);
		 
	 }
	 
	 public static UserAccount findUser(String userName, String password) {
		 UserAccount user = mapUsers.get(userName);
		 if(user != null && user.getPassword().equals(password)) return user;
		 else return null;
	 }
}
