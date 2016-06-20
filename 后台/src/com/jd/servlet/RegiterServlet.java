package com.jd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.bean.User;
import com.jd.service.UserService;

public class RegiterServlet extends HttpServlet {

	final static int a=0;
	final static int b=1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("user");
		User ue1=new User();
		ue1.setUserName(name);
		UserService us1=new UserService();
		boolean cu1=us1.checkUser(ue1);
		if(cu1){
			out.println(a);
		}else{
			out.println(b);
		}
		
	}

}
