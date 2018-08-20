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
		<script src="${pageContext.request.contextPath }/js/zhanshitu.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/diyUpload.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath }/js/webuploader.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/globle.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/zhanshitu.css"/>
		
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
			<dt class="sun special">界面管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd you"><a href="${pageContext.request.contextPath }/admin/swiper/indexBanner">首页banner</a></dd>
			<dd class="me special"><a href="${pageContext.request.contextPath }/admin/shopType/pre-add">首页展示</a></dd>
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
     	 		<span class="weizhi">当前位置：界面管理 > 首页展示图</span>
     	 	</section>
     	 	<!--当前位置结束-->
     	   </div>
	
	       <div class="rightBottom">
	       		<div class="top">
				<img src="${pageContext.request.contextPath }/img/jia3.png" alt="" />
				<span>首页展示图管理</span>
				</div>
			    <form action="" method="post" class="Multi">
			    	<div class="item clearfix">
			    		<p class="lei">后台类目</p> 
			    		
			    		<div class="kuang">
			    			<span></span>
			    			<img src="${pageContext.request.contextPath }/img/jian2.png"/>
			    		</div>
			    		<ul class="jiqi" >
			    		<c:forEach items="${shopTypeList }" var="x"  > 
		    			<li>
		    				
		    				<span name="shoptypeid" value="${x.shoptypeid }">${x.shoptypename}</span>	
		    				<img src="${pageContext.request.contextPath }/img/hui.png" alt="" />
		    				
		    			</li>
		    			</c:forEach>
		    			<%-- <li>
		    				<span>洗碗机</span>
		    				<img src="${pageContext.request.contextPath }/img/hui.png" alt="" />
		    			</li>
		    			<li>
		    				<span>净水器</span>
		    				<img src="${pageContext.request.contextPath }/img/hui.png" alt="" />
		    			</li>
		    			<li>
		    				<span>酸奶机</span>
		    				<img src="${pageContext.request.contextPath }/img/hui.png" alt="" />
		    			</li>
		    			<li>
		    				<span>机器人</span>
		    				<img src="${pageContext.request.contextPath }/img/hui.png" alt="" />
		    			</li>
		    			<li>
		    				<span>护理机</span>
		    				<img src="${pageContext.request.contextPath }/img/hui.png" alt="" />
		    			</li>
		    		 --%>
		    		 </ul>
			    	</div>
			    	
		    		
		    		
		        	<div class="food">           		
		        		<div class="shangchuan">
		        			<p class="tupian">展示图片</p>
			        		<ul class="upload-ul upload-box clearfix">
								<li class="upload-pick">
									<img class="img" src="${pageContext.request.contextPath }/img/photo.png" />
									<div class="webuploader-container clearfix" id="goodsUpload"></div>
							    </li>
						    </ul>      			
		        		</div>
		        		
		        		<input type="hidden" name="dcshoptypeid" value="${shoptype.shoptypeid}">
		        		<input type="hidden" name="shoptypeimg" value="${shoptype.shoptypeimg}">
					    <div class="bigbox clearfix">					    	
					    		<p>最佳尺寸为690px*340px</p>
		        			<!--bigbox end-->
						</div>
		        	</div>	
		   			<!--rightbottom end-->
			        		<button class="save" type="submit">保存</button>
			        	
			        </footer>
		        </form>
	     	 	
     	   </div>
		</div>
			</div>
		</div>				
	</body>
</html>
