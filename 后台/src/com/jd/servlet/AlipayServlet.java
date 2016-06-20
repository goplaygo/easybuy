package com.jd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.util.AlipaySubmit;
import com.jd.util.TzPayParameter;

public class AlipayServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//֧������
		String payment_type = "1";
		//ҳ����תͬ��֪ͨ  success.jsp
		String return_url="http://localhost/ego/room/seccess.jsp";
		//������
		String out_trade_no = "12321231321";
		//����
		String subject = request.getParameter("subject");
		System.out.println(subject);
		//���
		String total_fee ="0.1";
		//��Ʒ��ҵ�ַ
		String body = subject;
		String show_url = "http://localhost/ego/room/success.jsp";
		
		
		
		//��������
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("service","create_direct_pay_by_user");
		temp.put("partner", TzPayParameter.partner);
		temp.put("seller_email", TzPayParameter.seller_email);
		temp.put("_input_charset", TzPayParameter.input_charset);
		temp.put("payment_type", payment_type);
		temp.put("return_url", return_url);
		temp.put("out_trade_no", out_trade_no);
		temp.put("subject", subject);
		temp.put("total_fee", total_fee);
		temp.put("body", body);
		temp.put("show_url", show_url);
      //��������
		String alihtml = AlipaySubmit.buildRequest(temp, "post", "ȷ��");
		System.out.println(alihtml);
		response.getWriter().print(alihtml);
		//seller_id
		
	}
	
	}


