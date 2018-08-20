<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="${pageContext.request.contextPath }/">
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>超级VIP后台管理登录页</title>
		<script src="js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		<script type="text/javascript">
		$(function(){
		
		
			$("#aaa").click(function(){
			        
			        var user_name=$("[name=user_name]").val();
			        var user_password=$("[name=user_password]").val();
			        if(user_name==""){
			           $(".active").html("请输入用户名")
			           $(".active").show(300)
			           return false;
			        }
			        if(user_password==""){
			           $(".active").html("请输入密码")
			           $(".active").show(300)
			           return false;
			        }
			      $.post("login/login",{user_name:user_name,user_password:user_password},function(data){
			         if(data=="login"){
			           $(".active").html("账号/密码错误")
			           $(".active").show(300)
			             return false;
			         }
			         else{
			            window.location.href="admin/index/index"
			         }
			       
			      })
			  
			     return false;
			  })
			  
			 $(".dor input").keydown(function(event){
			     if(event.which==13){
			          
			        var user_name=$("[name=user_name]").val();
			        var user_password=$("[name=user_password]").val();
			        if(user_name==""){
			           $(".active").html("请输入用户名")
			           $(".active").show(300)
			           return false;
			        }
			        if(user_password==""){
			           $(".active").html("请输入密码")
			           $(".active").show(300)
			           return false;
			        }
			      $.post("login/login",{user_name:user_name,user_password:user_password},function(data){
			         if(data=="login"){
			           $(".active").html("账号/密码错误")
			           $(".active").show(300)
			              
			         }
			         else{
			            window.location.href="admin/index/index"
			         }
			       
			      })
			          
			          
			     }
			 })
			  
		})
		</script>
	</head>
	<body>
		<div class="container-fluid">
  			<div class="row">
  				<div class="col-md-12 col-sm-12 col-xs-12">
  					<div class="top">
  						<img src="img/top.png"/>
  						<span>超级vip后台登录系统</span>
  					</div>
  					
  				</div>	
  			</div>
  			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
	  					<div class="login">
							<h3>用户登录 / User login</h3>
							<div class="dor">
								<img src="img/head.png" class="icon-user" />
								<input type="text" class="user" placeholder="请输入用户名" name="user_name" >
							</div>
							<div class="dor">
								<img src="img/password.png" class="icon-password" />
								<input type="password" class="user" name="user_password" placeholder="请输入密码">
							</div>
							<button type="button" id="aaa" class="btn btn-success">登录</button>
							
							<p class="active" style="display: none">账号或密码显示错误</p>
						</div>
  				</div>	
			</div>
		</div>
	</body>
</html>

