<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta>

<meta name="Keywords" content="">
<meta name="Description" content="">
<title>login</title>
<link rel="stylesheet" href="css/login.css" type="text/css">
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" >
	var count=5;
	window.onload=function(){
		setInterval(function(){
			count--;
			if(count<=0)window.location.href="index.jsp";
			document.getElementById("count").innerHTML="<b>"+count+"</b>";
		},1000);
	};


</script>
</head>
<body>
	<!-- start top -->
	<div class="top">
		<a href="index.html">
			<img src="images/logo.gif" />
			<h1>登陆成功!!!<span id="count"></span>秒之后，跳转到主页...</h1>
		</a>
	</div>
	<!-- end top -->
	<div class="bg"></div>

</body>
</html>
