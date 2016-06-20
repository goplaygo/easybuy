package com.jd.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jd.bean.User;
import com.jd.util.SqlHelper;


public class UserService {
	//дһ����֤�û��Ƿ�Ϸ��ĺ���
		public boolean checkUser(User ur){

			//ʹ��SqlHelper����ɲ�ѯ����
			String sql="select * from easybuy_user where eu_user_name=?";
			String [] paraments={ur.getUserName()+""};
			ResultSet rs=SqlHelper.executeQuery(sql, paraments);
			try {
				if(rs.next()){
					return true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
			}
			return false;
		}
	 
	public boolean addUser(User user){
		String sql="insert into easybuy_user (eu_user_name,eu_password,eu_address) values(?,?,?)";
		String[] paraments={user.getUserName()+"",user.getPassWord()+"",null};
		try{
		SqlHelper.executUpdate(sql, paraments);
		}catch(Exception e){
			return false;
		}finally{
			SqlHelper.close(SqlHelper.getRs(), SqlHelper.getPs(), SqlHelper.getCt());
		}
		return true;
	}
}
