package me.zhulin.SecurityWebApp.utils;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class UrlPatternUtils {
	// check whether the url is urlPattern
	private static boolean hasUrlPattern(ServletContext servletContext, String urlPattern) {
		
		Map<String, ? extends ServletRegistration> map = servletContext.getServletRegistrations();
		
		for(String servletName : map.keySet()) {
			ServletRegistration sr = map.get(servletName);  // every servlet
			
			Collection<String> mappings = sr.getMappings();  // all urlPattern of a servlet
			if( mappings.contains(urlPattern)) return true;
		}
		return false;
	}
	
	public static String getUrlPattern(HttpServletRequest request) {
		ServletContext servletContext = request.getServletContext();
		
		// http://localhost:8080/contextPath/servletPath/pathInfo?queryString
	
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		
		String urlPattern = null;
		
		// http://localhost:8080/contextPath/servletPath/pathInfo
		if(pathInfo != null) {
			urlPattern = servletPath + "/";
			return urlPattern; //  servletPath/
		}
		
		// http://localhost:8080/contextPath/servletPath
		urlPattern = servletPath;
		
		boolean has = hasUrlPattern(servletContext, urlPattern);
		if(has) return urlPattern;  //  servletPath
		
		// http://localhost:8080/contextPath/servletPath.do

		int i = servletPath.lastIndexOf(".");
		if(i != -1) {
			String extra = servletPath.substring(i + 1); // "do"
			urlPattern = "." + extra;
			has = hasUrlPattern(servletContext, urlPattern); //".do"
			
			if(has) return urlPattern;  // .do
		}
		return "/";
		
		
	}
}
