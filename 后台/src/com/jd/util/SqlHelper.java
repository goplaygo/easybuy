package com.jd.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class SqlHelper {
	//�������ݿ�
	//������Ҫ�ı���
		private static	Connection ct=null;
		private static	ResultSet rs=null;
		private static	PreparedStatement ps=null;
		//�������ݿ����
		private static String url="";
		private static String user="";
		private static String pwd="";
		private static String driver="";
		//�������ļ���Ϣ
		private static  Properties pp=null;
		//����������ֻ��һ��
		static{
			try{
				//ʵ���������ļ��ļ�����
				pp= new Properties();
				//�õ������ļ���������
				//�õ������������
				ClassLoader cl = SqlHelper.class.getClassLoader();
				//ͨ�������������õ�ָ����Դ���ֽ���
				InputStream in = cl.getResourceAsStream("dbinfo.properties");
				//�������ļ������������ؽ�pp����
				pp.load(in);
				url=pp.getProperty("url");
				user=pp.getProperty("user");
				pwd=pp.getProperty("pwd");
				driver=pp.getProperty("driver");
				Class.forName(driver);
			}catch(Exception e){
				
			}finally{
				
			}
			
		}
		//�������
		public static Connection getConnection(){
			try{
			ct=DriverManager.getConnection(url, user, pwd);
			}catch(Exception e){
				
			}
			return ct;
		}
		//ͳһ��select
		//resulet--Arrylist
		public static ResultSet executeQuery(String sql,String[] paraments){
			
			try {
				ct=getConnection();
				ps=ct.prepareStatement(sql);
				if( paraments!=null&& !(paraments.equals(""))){
					for(int i=0;i<paraments.length;i++){
						ps.setString(i+1, paraments[i]);
					}
				}
				rs=ps.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		//��дһ��update/delete/insert
		//update ���� set �ֶ���=��where �ֶ�=��
		//paramentsӦ����{��123����23}
		public static void executUpdate(String sql,String[] paraments){
			//����һ��ps
			try {
				ct=getConnection();
				ps=ct.prepareStatement(sql);
				if( paraments!=null){
					for(int i=0;i<paraments.length;i++){
						ps.setString(i+1, paraments[i]);
					}
				}
				ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally{
			//�ر���Դ
			close(rs,ps,ct);
		}
		}
		//�ر���Դ����
		public static void close(ResultSet rs,PreparedStatement ps,Connection ct){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ct!=null){
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public static Connection getCt(){
			return ct;
		}
		public static PreparedStatement getPs(){
			return ps;
		}
		public static ResultSet getRs(){
			return rs;
		}
}
