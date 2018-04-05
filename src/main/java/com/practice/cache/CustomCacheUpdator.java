package com.practice.cache;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CustomCacheUpdator {

	private CustomCache customeCache = new CustomCache();
	 
	@SuppressWarnings("null")
	public List<String> getListOfItems(String key) throws SQLException{
		
		if(customeCache.getCache()==null){	
			ResultSet results=null;//getData from database
			//populate data in cache
			ConcurrentHashMap<String, List<String>> map = new ConcurrentHashMap<>();
			
			while(results.next()){
				String state = results.getString("state");
				String city = results.getString("city");
				
				if(map.containsKey(state)){
					map.get(state).add(city);
				}else{
					List<String> cities = new ArrayList<>();
					cities.add(city);
					map.put(state, cities);
				}
			}
			
			//set cache in CustomCache
			customeCache.setCache(map);
		}
		
		return customeCache.getCache().get(key);
	}
	
}
