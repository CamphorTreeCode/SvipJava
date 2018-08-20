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
		<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/rem.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/jiameng-shenhe.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/jiameng-shenhe.css"/>
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
			<dt class="safa"><a href="${pageContext.request.contextPath }/admin/index/index">后台首页</a></dt>
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
			<dt class="is special"><a href="${pageContext.request.contextPath }/admin/franchiserUser/findFranchiserUserList">账号管理</a></dt>
		</dl>
	
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
     	 		<span class="weizhi">当前位置：加盟管理 > 审核</span>
     	 	</section>
     	 	<!--当前位置结束-->
     	   </div>
	
	       <div class="rightBottom">
	       	<form action="" method="post">
	       		<div class="top">
				<img src="${pageContext.request.contextPath }/img/shenh.png" alt="" />
				<span>审核</span>
				</div>
				<input type="hidden" name="franchiserid" readonly="readonly" id="zhanghao"  />
				<div class="main">
					<label>姓名</label>
					<input type="text" name="franchisename" readonly="readonly" id="zhanghao" value="${franchiser.franchisename}" placeholder="赵日天"/>
				</div>
				<div class="main">
					<label>消费平台</label>
					<input type="hidden" name="franchiseconsumption" readonly="readonly" id="name" value="${franchiser.franchiseconsumption}" placeholder="淘宝"/>
					<c:if test="${franchiser.franchiseconsumption == 1}">
					  <input type="text"  readonly="readonly" id="name" value="淘宝" placeholder="淘宝"/>
					</c:if>
					<c:if test="${franchiser.franchiseconsumption == 0}">
					  <input type="text"  readonly="readonly" id="name" value="天猫" placeholder="淘宝"/>
					</c:if>
				</div>
				<div class="main">
					<label>订单号</label>
					<input type="text" name="franchiseordernmuber" readonly="readonly" id="password" value="${franchiser.franchiseordernmuber}" placeholder="123456789123"/>
				</div>
				<div class="main">
					<label>联系电话</label>
					<input type="text" name="franchisephone" readonly="readonly" id="taobao" value="${franchiser.franchisephone}" placeholder="18866668888"/>
				</div>
				<div class="reason">
					<label class="team">申请理由</label>
					<textarea name="franchiseapplyreason" id="liyou" readonly="readonly"  <%-- value="${franchiser.franchiseapplyreason} --%>" placeholder="一那份i啊三月份啊阿斯蒂芬">${franchiser.franchiseapplyreason}</textarea>
				</div>

					<%-- <input type="hidden" name="currentPage"  value="${currentPage}"/> --%>
				<button id="pass" class="save" type="submit">通过</button>
				<button id="fail" class="cancel se">不通过</button>
	       	</form>
	       	
	      <script type="text/javascript">
	     	 	
	     	 	$("#pass").click(function(){
	      			location.href="./auditSuccess?franchiserId=${franchiser.franchiserid}&currentPage=${currentPage}&franchiserName=${franchiserName}"
	      				return false;
	   			  })
	    		$("#fail").click(function(){
	      			location.href="./auditFail?franchiserId=${franchiser.franchiserid}&currentPage=${currentPage}&franchiserName=${franchiserName}"
	      				return false;
	  			  }) 
	     	 	</script>
	     	 	
     	   </div>
		</div>
			</div>
		</div>				
	</body>
</html>
