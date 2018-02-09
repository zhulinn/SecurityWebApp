package me.zhulin.SecurityWebApp.utils;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import me.zhulin.SecurityWebApp.config.SecurityConfig;

// check if a request is required to be logged in or not, 
//and whether such request is suitable for the role of user logged or not.  
public class SecurityUtils {
	
	// check whether request is required to login or not
	public static boolean isSecurityPage(HttpServletRequest request) {
		String urlPattern = UrlPatternUtils.getUrlPattern(request);
		
		Set<String> roles = SecurityConfig.getAllAppRoles();
		
		for(String role : roles) {
			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if(urlPatterns != null && urlPatterns.contains(urlPattern)) {
				return true;
			}
		}
		return false;
	}
	
	// Check whether the request has a valid role?
	public static boolean hasPermissin(HttpServletRequest request) {
		String urlPattern = UrlPatternUtils.getUrlPattern(request);
		
		Set<String> allRoles = SecurityConfig.getAllAppRoles();
		
		for(String role : allRoles) {
			if(!request.isUserInRole(role)) continue;
			
			List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);
			if(urlPatterns != null && urlPattern.contains(urlPattern)) return true;
			
		}
		
		return false;
	}
}
