package com.jd.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jd.bean.Produce;
import com.jd.bean.User;
import com.jd.util.SqlHelper;

public class ProductService {
	
	public  ArrayList getproduct(){
		ArrayList<Produce> list=new ArrayList<Produce>();
		String sql="select * from easybuy_product" ;
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		//¶þ´Î·â×°
		try {
			while(rs.next()){
				Produce u=new Produce();
				u.setProId(rs.getInt(1));
				
				u.setProName(rs.getString(2));
				u.setProPrice(rs.getString(3));
				u.setTypeId(rs.getInt(4));
				u.setProPic(rs.getString(5));
				u.setProDescription(rs.getString(6));
				
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return list;
	}
	public  Produce getPro(String id){
		Produce u=new Produce();
		String sql="select * from easybuy_product where ep_id=?" ;
		String [] paraments={id+""};
		ResultSet rs=SqlHelper.executeQuery(sql, paraments);
		try {
			while(rs.next()){
				
				u.setProId(rs.getInt(1));
				
				u.setProName(rs.getString(2));
				u.setProPrice(rs.getString(3));
				u.setTypeId(rs.getInt(4));
				u.setProPic(rs.getString(5));
				u.setProDescription(rs.getString(6));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return u;
	}
	
}
