package com.practice.extra.sp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.practice.extra.sp.vo.NameValueBean;

public class NameValueCache {
	
	private static final ConcurrentHashMap<String, List<NameValueBean>> nameValueCache = new ConcurrentHashMap<>();
	
	public static List<NameValueBean> getProductList(String opsStudy){
		return nameValueCache.get(opsStudy);
	}
	
	public static void addProductList(String opsStudy, List<NameValueBean> productList){
		nameValueCache.put(opsStudy, productList);
	}
	
	public static void addProduct(String opsStudy, NameValueBean nameValue){
		if(nameValueCache.containsKey(opsStudy)){
			nameValueCache.get(opsStudy).add(nameValue);
		}else{
			List<NameValueBean> productList = new ArrayList<>();
			productList.add(nameValue);
			nameValueCache.put(opsStudy, productList);
		}
	}
}
