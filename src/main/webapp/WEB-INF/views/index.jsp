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
		<title>超级VIP后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/rem.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/globle.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css"/>
	</head>
	<body>
		<div class="container-fluid">
			<!--页面开始-->
		<div class="row">
				<!--left二级下拉菜单  begin-->
	        <div class="left col-lg-1">
              <div class="leftTop">
    	        <img src="${pageContext.request.contextPath }/img/viplogo.png" class="logo" />
    	        <div class="center">超级VIP后台管理中心</div>
	           </div>

    
	<div class="leftsidebar_box">
		<dl class="system_log">
			<dt class="safa special"><a href="${pageContext.request.contextPath }/admin/index/index">后台首页</a></dt>
		</dl>
	
		<dl class="custom">
			<dt class="dtt">商品类目管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd we"><a href="${pageContext.request.contextPath }/admin/shopType/list">添加类目</a></dd>
		</dl>
	
	
		<dl class="app">
			<dt class="ddt">食谱类目管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="sencod_dd"><a href="${pageContext.request.contextPath }/admin/RecipesType/foodTypelist">添加类目</a></dd>
		</dl>
	
		<dl class="cloudd">
			<dt class="con">商品管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd us"><a href="${pageContext.request.contextPath }/admin/shop/shopList">商品查询</a></dd>
			<dd class="first_dd our"><a href="${pageContext.request.contextPath }/admin/shop/addPage">添加商品</a></dd>
		</dl>
		<dl class="cloud">
			<dt class="cont">食谱管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd they"><a href="${pageContext.request.contextPath }/Recipes/Recipeslist">食谱查询</a></dd>
			<dd class="first_dd them"><a href="${pageContext.request.contextPath }/Recipes/addRecipesPage">添加食谱</a></dd>
		</dl>
		
		<dl class="source">
			<dt class="is"><a href="${pageContext.request.contextPath }/admin/franchiserUser/findFranchiserUserList">账号管理</a></dt>
		</dl>
		
		<!-- <dl class="statistics">
			<dt class="Order">订单审核</dt>
		</dl> -->
	
		<dl class="statistics">
			<dt class="it"><a href="${pageContext.request.contextPath }/admin/franchiser/findFranchiserList">加盟管理</a></dt>
		</dl>
		<dl class="statistics">
			<dt class="round"><a href="${pageContext.request.contextPath }/admin/maintenance/findMaintenanceMsgList">维修管理</a></dt>
		</dl>
		
	     <dl class="statistics"><dt class="refund"><a href="${pageContext.request.contextPath }/admin/refund/list">退款管理</a></dt></dl>
		<dl class="syetem_management">
			<dt class="sun">界面管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd you"><a href="${pageContext.request.contextPath }/admin/swiper/indexBanner">首页banner</a></dd>
			<dd class="me"><a href="${pageContext.request.contextPath }/admin/shopType/pre-add">首页展示</a></dd>
			<dd class="my"><a href="${pageContext.request.contextPath }/admin/about/pre-add">关于我们</a></dd>
			<dd class="out"><a href="${pageContext.request.contextPath }/admin/franchiseDetails/pre-add">申请加盟</a></dd>
			<dd class="study"><a href="${pageContext.request.contextPath }/admin/learningWorld/findLearningWorldList">学习天地</a></dd>
		</dl>
	
		<dl class="source">
			<dt class="off">模板消息</dt>
		</dl>
	
	
	</div>
<!--left二级下拉菜单  end-->
    </div>
			
			
			
		<div class="right col-lg-11">					
					
			<div class="rightTop">
					
     	 	     <div class="rightTop_r">
     	 		   	<img src="${pageContext.request.contextPath }/img/viplogo.png" class="user"/>
     	 		    <span class="name">${user.adminname}</span>
     	 		    <img class="xia" src="${pageContext.request.contextPath }/img/xia.png"/>     	 		
     	    	</div>
     	    	
     	 	 <div class="dogegg">
     	 		<a href="${pageContext.request.contextPath }/login/pre-update">更改信息</a>
     	 		<a href="${pageContext.request.contextPath }/login/tologin">退出登录</a>
     	 	</div>
     	 	
     	 </div>
           
	<div class="rightCenter">
        		<!--当前位置  begin-->
     	 	 <section class="current">
     	 		<img class="laba" src="${pageContext.request.contextPath }/img/laba.png"/>
     	 		<span class="weizhi">当前位置：店铺首页</span>
     	 	</section>
     	 	<!--当前位置结束-->
     	   </div>
	
	     	   <div class="rightBottom">
     	 	<ul>
     	 		<li class="lione">
     	 			<div class="b_one">
     	 				<img src="${pageContext.request.contextPath }/img/mini.png"/>
     	 				<span>小程序信息</span>
     	 			</div>
     	 			<img class="logo2" src="${pageContext.request.contextPath }/img/viplogo.png"/>
     	 			<div class="wenben">
     	 				<p>超级VIP后台管理中心</p>
     	 				<p>Super VIP Background management center</p>
     	 			</div>
     	 		</li>
     	 		<li class="litwo">
     	 			<div class="b_one">
     	 				<img src="${pageContext.request.contextPath }/img/xinxi.png"/>
     	 				<span>联系信息</span>
     	 			</div>
     	 			<p class="ss">上海申肃网络科技有限公司</p>     	 			
     	 			<p>传手小程序开发平台</p>    	 			
     	 		</li>
     	 		
     	 		<li class="lithree">
     	 			<div class="b_one">
     	 				<img src="${pageContext.request.contextPath }/img/tixing.png"/>
     	 				<span>消息提醒</span>
     	 			</div>
     	 			
     	 			<div class="vip" style = "cursor: pointer" >
     	 			    <a href="./admin/franchiser/findFranchiserList" class='change'>
	     	 				<img class="vips" src="${pageContext.request.contextPath }/img/bai.png"/>
	     	 				<p class="pink">申请加盟</p>
	     	 				<div class="yuan">${requestScope.franchiserUnRead}</div>
	     	 			</a>
     	 			</div>
     	 			
     	 			<div class="baoming" style = "cursor: pointer" >
     	 			    <a href="./admin/maintenance/findMaintenanceMsgList" class='change'>
	     	 				<img class="huiyuan" src="${pageContext.request.contextPath }/img/weixiu.png"  />
	     	 				<p class="pink">维修管理</p>
	     	 				<div class="yuan">${requestScope.maintenanceUnRead}</div>
     	 				</a>
     	 			</div>
     	 		</li>
     	 		
     	 		
     	 		<li class="lifour">
     	 			<div class="b_one">
     	 				<img src="${pageContext.request.contextPath }/img/phone-in-talk.png"/>
     	 				<span>联系电话</span>
     	 			</div>
     	 			<p class="mala">021-57630970</p>
     	 			<div class="four4">
     	 				<img class="bb" src="${pageContext.request.contextPath }/img/dizhi.png"/>
     	 				<span class="cc">联系地址</span>
     	 		</div>
     	 	    <p class="gps">上海市松江区茸兴路茸407创意园2F222室</p>
     	 		</li>    	 		
     	 	</ul>
     	   </div>
		</div>
			</div>
		</div>				
	</body>
</html>

