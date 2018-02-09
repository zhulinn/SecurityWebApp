package me.zhulin.SecurityWebApp.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// configure url for different roles
public class SecurityConfig {
	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	
	// map Role to its urlPatterns
	private static final Map<String, List<String>> mapConfig = new HashMap<>();
	
	static {
		init();
	}
	
	private static void init() {
		
		//urls for Employee
		List<String> urls_Emp = new ArrayList<>();
		urls_Emp.add("/userInfo");
		urls_Emp.add("/employeeTask");
		mapConfig.put(ROLE_EMPLOYEE, urls_Emp);
		
		//urls for Manager
		List<String> urls_Man = new ArrayList<>();
		urls_Man.add("/userInfo");
		urls_Man.add("/managerTask");
		mapConfig.put(ROLE_MANAGER, urls_Man);
		
	}
	
	public static Set<String> getAllAppRoles(){
		return mapConfig.keySet();
	}
	
	public static List<String> getUrlPatternsForRole(String role) {
		return mapConfig.get(role);
	}
}
