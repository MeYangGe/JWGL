package com.system.util;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author  JGW
 * @version 1.0
 *
 * Shiro的权限设定  以及放行的数据文件夹
 */
public class FilterChainDefinitionMapBuilter {
	public Map<String, String> filterChainDefinitionMap(){
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("/login.html", "anon");

		linkedHashMap.put("/css/*", "anon");

		linkedHashMap.put("/fonts/*", "anon");

		linkedHashMap.put("/images/*", "anon");

		linkedHashMap.put("/js/*", "anon");

		linkedHashMap.put("/login", "anon");
		
		linkedHashMap.put("/student/*", "roles[student]");

		linkedHashMap.put("/teacher/*", "roles[teacher]");
		
		linkedHashMap.put("/admin/*", "roles[admin]");
		
		linkedHashMap.put("/logout", "logout");
		
		linkedHashMap.put("/**", "authc");
		return linkedHashMap;
	}

}
