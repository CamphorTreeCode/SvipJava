<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>超级VIP后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--全局js及样式-->
		<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
        <script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath }/js/index.js" type="text/javascript" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath }/js/rem.js" type="text/javascript" charset="utf-8"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css"/>		
		<script src="${pageContext.request.contextPath }/js/commodity interface.js" type="text/javascript" charset="utf-8"></script>
		<!--本页面样式-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/interface.css"/>
		
	</head>
	<body>
		<div class="container-fluid">
			
			<!--弹出框 start-->		
			<div class="Popup">
				<!--弹框 start-->
				<div class="Eject">
					<!--叉号-->
				    <!--<img src="img/shan.png" class="img"/>-->
				<div class="aa">
					<img src="${pageContext.request.contextPath }/img/shezhi.png" class="phone"/>
				    <span>修改名称</span>
				</div>
				<div class="bb">
					<label>原类目名称</label>
					<div class="primary"></div>
				</div>
				<form action="./update" id="edit" method="post">
				<div class="cc">
					<label>更改为</label>
					<input type="hidden" name="shoptypeid">
					<input type="text" name="shoptypename" class="text" value="" placeholder="请输入更改的类目名称" />
				</div>
				
				<!--弹框按钮-->
				<div>
					<button class="bon">取消修改</button>
				    <button class="btt">确认修改</button>
				</div>		
				<!--弹框 end-->
				</form>
			</div>
			
			<!--弹出框 end-->
			</div>
			
			
			
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
			<dt class="safa"><a href="${pageContext.request.contextPath }/admin/index/index">后台首页</a></dt>
		</dl>
	
		<dl class="custom">
			<dt class="dtt special">商品类目管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd we special"><a href="${pageContext.request.contextPath }/admin/shopType/list">添加类目</a></dd>
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
     	 		<span class="weizhi">当前位置：商品类目管理 > 添加商品类目</span>
     	 	</section>
     	 	<!--当前位置结束-->
     	   </div>
	
<!--rightbottom begin-->
        	<div class="rightBottom clearfix">
        		
        		<!--rightbottom_top begin-->
        		<div class="rightBottom_top">
        			<!--rb_t_t begin-->
        			<div class="rb_t_t">
        				<div class="rb_t_t_t">
        					<img src="${pageContext.request.contextPath }/img/jiasp.png"/>
        				    <span>添加商品类目</span>
        				</div>
        				
        			<!--rb_t_t begin-->
        			</div>
     			<!--rightbottom_top end-->
        		</div>
    
        		<div class="addTo">
        		    <form action="./add" id="add" method="post">
        			<input type="text"  name="shoptypename"  class="Category" value="" placeholder="在此填写您要添加的商品类目名称" />
        			<span class="add" style="cursor: pointer">添加</span>  
        			</form>      			
        		</div>
        		
        		<div class="option">
        		
        		  <div class="row serialNumber">
						<div class="col-lg-1">序号</div>
						<div class="col-lg-10">名称</div>
						<div class="col-lg-1">选项</div>
				  </div>
        		
	        		<c:forEach items="${shopTypeList }" var="x" varStatus="vs" > 
	        		<!-- Parent element start -->
	        		   <section class="row dynamic">
		        		   <div class="col-lg-1">${vs.index+1 }</div>
		        		   <div class="col-lg-10"><p>${x.shoptypename}</p></div>
		        		   <div class="col-lg-1">
			        		   	<span class="xiu" value="${x.shoptypeid }">修改 </span>
			        		   	<span class="shan" value="${x.shoptypeid }"> 删除</span>
		        		   </div>
	        		   </section>
	        		 <!-- Parent element end -->
	        		</c:forEach>   
        		</div>
        			</div>
     	   
				</div>
			</div>
		</div>		
	</body>

</html>