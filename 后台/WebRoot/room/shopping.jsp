<%@ page language="java" import="java.util.*,com.jd.service.*,com.jd.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>



<title>information</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<style>
	*{
		margin: 0;
		padding: 0;
	}
a{
		text-decoration: none;
	}
	input{
		outline:0;
		border:1px solid #ddd;
		text-align: center;
	}
	#container {
		width: 1263px;
		margin: 100px auto;
	}
	#container .tour {
		background: #ddd;
		overflow: hidden;
		width: 908px;
		position: relative;
		margin: 0 auto;
	}
	#container .tour img {
		float: left;
	}
	#container .tour figcaption {
		width: 528px;
		height: 230px;
		float: right;
	}
	#container .tour h2{
		font-size: 24px;
		color: #333;
		font-weight: normal;
		padding: 10px 0 10px 25px;
	}
	#container .tour h3{
		font-size: 16px;
		color: #666;
		line-height: 1.5;
		font-weight: normal;
		padding: 10px 0 10px 25px;
	}
	#container .tour .buy {
		padding: 10px 0 10px 25px;
	}
	#container .tour .price {
		color: #f60;
		font-size: 20px;
		padding-top: 5px;
	}
	#container .tour .price strong {
		font-size: 36px;
	}
	#container .tour .price s {
		font-size: 16px;
		color: #999;
	}
	#container .tour .reserve,.cart {
		margin: 10px 0 0 0;
		display: inline-block;
	}
	#container .tour .buy a {
		display: inline-block;
		width: 152px;
		height: 40px;
		line-height: 40px;
		text-align: center;
		border-radius: 4px;
		font-size: 20px;
		color: #fff;
		background-color: #f60;
	}
	#container .tour .buy a:hover {
		color: #000;
	}
	#container .tour .type {
		width: 90px;
		height: 25px;
		line-height: 25px;
		font-size: 14px;
		text-align: center;
		color: #fff;
		background-color: #59b200;
		position: absolute;
		top: 0;
		left: 0;
	}
	#container .tour .disc {
		position: absolute;
		top: 0;
		right: 0;
		width: 52px;
		height: 52px;
	}
	#container .tour .disc span {
		display: block;
		transform: rotate(45deg);
		width: 52px;
		height: 52px;
		padding: 5px 0 0 0;
		text-indent: 7px;
		font-size: 14px;
		color: red;
	}
</style>
</head>
<body>
<% 
	String pro=request.getParameter("pro");
	ProductService ps=new ProductService();
	Produce p=ps.getPro(pro);
	request.getSession().setAttribute("pro", p);
	
%>

<div id="container">
	<figure class="tour">
		<img src="images/${pro.proPic}" alt="芭提雅" width="350px" height="335px">
		<figcaption>
			<article>
				<header>
					<hgroup>
						<h2 id="proName">${pro.proName}</h2>
						<h3>${pro.proDescription}</h3>
					</hgroup>
				</header>
				<div class="buy">
					<form action="">
						<font color= "#666" >数量</font>
						<input type="number" id="num" name="points" min="1" max="10" step="1" value="5">
					</form>
					<div class="price">￥<strong id="price">${pro.proPrice}</strong> <s>¥3980</s></div>
					<div class="reserve"><a href="javascript:void(0)" class="gobuy">立即抢购</a></div>
					<div class="cart"><a href="###">加入购物车</a></div>
				</div>
				<div class="type">最新秒杀</div>
				<div class="disc"><span>4.7折</span></div>
				
			</article>
		</figcaption>
	</figure>
</div>
<div id="result"></div>
<script type="text/javascript">


	$(function(){
		$(".gobuy").click(
			function(){
			
			var num=document.getElementById("num").value;
			var price=document.getElementById("price").innerHTML;
			
			//名称
			var subject=document.getElementById("proName").innerHTML;
			//金额
			var total_fee=num*price;
			var params={subject:subject,total_fee:total_fee};
			$.ajax({
				type:"post",
				data:params,
				url:"../AlipayServlet",
				success:function(data){
					alert(data);
					$("#result").html(data);
				}
			});
			}
		);
	});
	

</script>
</body>
</html>