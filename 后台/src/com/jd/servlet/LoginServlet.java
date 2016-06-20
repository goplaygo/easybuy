package com.jd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jd.bean.Produce;
import com.jd.bean.User;
import com.jd.service.ProductService;
import com.jd.service.UserService;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String name=request.getParameter("user");
			String password=request.getParameter("password");
			PrintWriter out=response.getWriter();
			User u=new User();
			u.setUserName(name);
			u.setPassWord(password);
			UserService us=new UserService();
			if(us.checkUser(u)){
				request.getSession().setAttribute("username", name);
				//如果登陆成功那么需要绑定首页显示数据
				ProductService ps=new ProductService();
				List<Produce> list=	ps.getproduct();
				request.setAttribute("prolist", list);
				request.getRequestDispatcher("room/index.jsp").forward(request, response);
			//	response.sendRedirect("room/index.jsp");
			}else{
				out.write("<script type='text/javascript'>alert('用户名不存在，请重新登陆！');location.href='login.jsp'</script>");
			}
			
		
	}

}
