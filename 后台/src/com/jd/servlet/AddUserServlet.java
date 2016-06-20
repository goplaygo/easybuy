package com.jd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.bean.User;
import com.jd.service.UserService;

public class AddUserServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			PrintWriter out=response.getWriter();
			String name=request.getParameter("user");
			String password=request.getParameter("password");
			User ue=new User();
			ue.setUserName(name);
			ue.setPassWord(password);
			UserService us=new UserService();
			
			
			if(us.checkUser(ue)){
				out.write("<script type='text/javascript'>alert('用户已存在！');location.href='login.jsp'</script>");
			}else{
				if(us.addUser(ue)){
					request.getSession().setAttribute("username",name);
					//定时跳转
					response.sendRedirect("room/sucess.jsp");
				}else{
					out.write("<script type='text/javascript'>alert('添加用户失败！');location.href='login.jsp'</script>");
				}
			}
			
			
			
	}

}
