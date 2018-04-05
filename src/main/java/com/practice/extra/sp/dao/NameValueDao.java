package com.practice.extra.sp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.practice.extra.sp.util.NameValueCache;
import com.practice.extra.sp.vo.NameValueBean;

public class NameValueDao {

	public List<NameValueBean> getProductList(String opsStudy) throws SQLException {
		List<NameValueBean> productList = new ArrayList<NameValueBean>();

		String sql = "select name, desc from <table> where opsStudy ="+opsStudy;
		ResultSet results=null;//getData from database
		while(results.next()){
			String name = results.getString("name");
			String desc = results.getString("desc");
			
			NameValueBean nvb = new NameValueBean();
			nvb.setName(name);
			nvb.setDes(desc);
			productList.add(nvb);
		}
		

		return productList;
	}
	
	public List<NameValueBean> getProductListTest(String opsStudy) throws SQLException {
		return NameValueCache.getProductList(opsStudy);
	}
	
	public void initializeNameValueCache() throws SQLException{
		
		String sql = "select opsStudy, name, desc from <table>";

		ResultSet results=null;//getData from database
		while(results.next()){
			String opsStudy = results.getString("opsStudy");
			NameValueBean nvb = new NameValueBean();
			nvb.setName(results.getString("name"));
			nvb.setDes(results.getString("desc"));
			NameValueCache.addProduct(opsStudy, nvb);
		}
	}

}
