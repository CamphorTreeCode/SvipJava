<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<script src="${pageContext.request.contextPath }/js/genggai-message.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/globle.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/genggai-message.css" />
		<script type="text/javascript">
		    $(function(){
		    var f=false;
		      $("#old").blur(function(){
		          adminname=$("[name=adminName123]").val();
		          adminpassword=$("[name=old]").val();
		          $.post("${pageContext.request.contextPath }/login/pauduan",{adminname:adminname,adminpassword:adminpassword},function(data){
		             if(data==1){
		               
		                f=true;
		             }else{
		                alert("旧密码不正确")
		                f=false;
		             }
		          
		          })
		      })
		      $("#sub").click(function(){
		          
		          if(f==false){
		             alert("旧密码不正确")
		             return false;
		          }
		        
		      })
		    
		    })
		   
		</script>
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
			<dt class="is"><a href="${pageContext.request.contextPath }/admin/franchiserUser/findFranchiserUserList">账号管理</a></dt>
		</dl>
		
<!-- 		<dl class="statistics">
			<dt class="Order">订单审核</dt>
		</dl> -->
	
		<dl class="statistics">
			<dt class="it"><a href="${pageContext.request.contextPath }/admin/franchiser/findFranchiserList">加盟管理</a></dt>
		</dl>
		<dl class="statistics">
			<dt class="round"><a href="${pageContext.request.contextPath }/admin/maintenance/findMaintenanceMsgList">维修管理</a></dt>
		</dl>
	    <dl class="statistics">
			<dt class="refund"><a href="${pageContext.request.contextPath }/admin/refund/list">退款管理</a></dt>
		</dl>
		<dl class="syetem_management">
			<dt class="sun special">界面管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd you"><a href="${pageContext.request.contextPath }/admin/swiper/indexBanner">首页banner</a></dd>
			<dd class="me"><a href="${pageContext.request.contextPath }/admin/shopType/pre-add">首页展示</a></dd>
			<dd class="my special"><a href="${pageContext.request.contextPath }/admin/about/pre-add">关于我们</a></dd>
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
     	 		    <img class="xia" src="${pageContext.request.contextPath }/img/xia.png"  />     	 		
     	    	</div>
     	    	
	     	 	 <div class="dogegg">
	     	 		<a href="${pageContext.request.contextPath }/login/pre-update">修改信息</a>
	     	 		<a href="${pageContext.request.contextPath }/login/tologin">退出登录</a>
	     	 		
	     	 	</div>
     	 	
     	 </div>
           
			<div class="rightCenter">
        		<!--当前位置  begin-->
     	 	 <section class="current">
     	 		<img class="laba" src="${pageContext.request.contextPath }/img/laba.png"/>
     	 		<span class="weizhi">当前位置：更改信息</span>
     	 	</section>
     	 	<!--当前位置结束-->
     	   </div>
	
	     	
	 		<!--更改-->
	 		<form action="update" method="post">
	 			<div class="top">
				<img src="${pageContext.request.contextPath }/img/yuangon.png"/>
				<span>更改信息</span>
				</div>
				<input type="hidden" name="adminid" value="${user.adminid }">
	    	 	<div class="main">
					<div class="up">
						<div class="head">
							<label>头像 </label>
							<div class="head-img">
								<img class="portrait" src="${pageContext.request.contextPath }/img/viplogo.png" />
							</div>
						</div>
						<div>
							<label>用户名</label>
							<input type="text" name="adminName123" id="user" readonly="readonly" value="${user.adminname }" />
						</div>
						
						<div>
							<label>新用户名</label>
							<input type="text" name="adminname" id="user" value="${user.adminname }" />
						</div>
					</div>
					<div class="down">
						<div>
							<label>旧密码</label>
							<input type="password" name="old" id="old" value=""  />
						</div>
						<div>
							<label>新密码</label>
							<input type="password" name="newPsw" id="newPsw" value=""  />
						</div>
						<div>
							<label>确认新密码</label>
							<input type="password" name="adminpassword" id="sure" value=""  />
						</div>
					</div>
				</div>
				<button class="save" type="submit" id="sub">确认更改</button>

	 		</form>

			</div>
			</div>
		</div>				
	</body>
</html>
