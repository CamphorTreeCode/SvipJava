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
        <%-- <script src="${pageContext.request.contextPath }/js/time.js" type="text/javascript" charset="utf-8"></script>
        <script src="${pageContext.request.contextPath }/js/jquer_shijian.js" type="text/javascript" charset="utf-8"></script> --%>
        <script src="${pageContext.request.contextPath }/js/weixiu-guanli.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/weixiu-guanli.css"/>
		<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/shijian.css"/> --%>
		
	</head>
	<body>  
	
		<%-- <%@include file="../comment/comment.jsp" %> --%>
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
			<dt class="round special"><a href="${pageContext.request.contextPath }/admin/maintenance/findMaintenanceMsgList">维修管理</a></dt>
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
     	 		<span class="weizhi">当前位置：维修管理</span>
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
        					<img src="${pageContext.request.contextPath }/img/yuangon.png"/>
        				    <span>维修管理</span>
        				</div>
        				
        			<!--rb_t_t begin-->
        			</div>
     			<!--rightbottom_top end-->
        		</div>
        		
        		<form action="./findMaintenanceMsgList" method="post" class="topinput clearfix">
        		
        		<div class="topinput_3">
        				<label>机器型号</label>
        				<input type="text" id="time" placeholder="选择机器型号以查询" name="maintenancemodel" value="${maintenancemodel}"/>
        			</div>
        			<div class="topinput_1">
        				<label>名称</label>
        				<input type="text" class="name_1" name="maintenanceName" value="${maintenanceName}"  placeholder="输入用户名称以查询"/>
        			</div>
        			
        			
        			<div class="pid">
        				<label>联系电话</label>
        				<input type="text" class="pdd" name="maintenancePhone" value="${maintenancePhone}" placeholder="输入联系电话以查询"/>
        			</div>
        			<button class="but"><img class="imgone" src="${pageContext.request.contextPath }/img/fangda.png"/>查询</button>
        		</form>
        			
        			
        		
        		
        		<div class=" boxone row">
        			<div class="col-lg-2">机器型号</div>
        			<div class="col-lg-2">姓名</div>
        			<div class="col-lg-2">购买平台</div>
        			<div class="col-lg-2">地址</div>
        			<div class="col-lg-2">联系电话</div>   
        			<div class="col-lg-2">状态</div>
        			<div class="col-lg-2">操作</div>
        		</div>
        		
        		<c:forEach items="${maintenanceMsgList.lists}" var="x" varStatus="xs">
        		<div class=" boxtwo row">
        			<div class="col-lg-2">${x.maintenancemodel}</div>
        			<div class="col-lg-2">${x.maintenancename}</div>
        			<div class="col-lg-2">
        				${x.maintenanceplatform}
        			</div>
        			<div class="col-lg-2">${x.maintenanceaddress}</div>
        			<div class="col-lg-2">${x.maintenancephone}</div>
        			<div class="col-lg-2">
        				<c:if test="${x.maintenancestate==0}" >
        				<span style="color: #999"> 待审核 </span>
        				</c:if>
        				<c:if test="${x.maintenancestate==1}" >
        				<span style="color: #25A2FE"> 已通过 </span>
        				</c:if>
        				<c:if test="${x.maintenancestate==2}" >
        				<span style="color: #FF3D46"> 未通过 </span>
        				</c:if>
        			</div> 
        			<div class="col-lg-2">
        				<div class="xiugai">
        					<c:if test="${x.maintenancestate==0}">
        						<a href="./WyfindMaintenanceMsgDetails?maintenanceId=${x.maintenanceid}&currentPage=${maintenanceMsgList.currPage}&maintenanceName=${maintenanceName}" class="cha">审核</a>
        						<a value=${x.maintenanceid } class="xiu">删除</a>
        					</c:if>
        					<c:if test="${x.maintenancestate==1}">
        						<a value=${x.maintenanceid } class="xiu">删除</a>
        					</c:if>
        					<c:if test="${x.maintenancestate==2}">
        						<a value=${x.maintenanceid } class="xiu">删除</a>
        					</c:if>
        				</div>
        			</div>      
        					
        		</div>
        		</c:forEach>
        			
        		<section class="fenye">
							<c:if test="${requestScope.maintenanceMsgList.currPage > 1}">
								<a href="./findMaintenanceMsgList?currentPage=${requestScope.maintenanceMsgList.currPage-1}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}" class="leftjian"><</a>	
							</c:if>
							<c:if test="${requestScope.maintenanceMsgList.currPage == 1}">
								<a class="leftjian"><</a>	
							</c:if>
														
							<c:if test="${requestScope.maintenanceMsgList.totalPage > 5}">
								<c:if test="${requestScope.maintenanceMsgList.currPage <= 5}">	
									<c:forEach begin="1" end="5" var="pag" step="1">	
										<c:if test="${requestScope.maintenanceMsgList.currPage == pag}">										
											<a style="background:rgb(255,132,137);color:#fff" href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
										</c:if>
										<c:if test="${requestScope.maintenanceMsgList.currPage != pag}">
											<a href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
										</c:if>
									</c:forEach>
									<a >...</a>
									<a href="./findMaintenanceMsgList?currentPage=${requestScope.maintenanceMsgList.totalPage}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${requestScope.maintenanceMsgList.totalPage}</a>
								</c:if>
								
								<c:if test="${requestScope.maintenanceMsgList.currPage > 5}">	
									<a href="./findMaintenanceMsgList?currentPage=1&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">1</a>
									<a >...</a>
									
									<c:if test="${requestScope.maintenanceMsgList.currPage >= requestScope.maintenanceMsgList.totalPage -4}">
										<c:forEach begin="${requestScope.maintenanceMsgList.totalPage-4}" end="${requestScope.maintenanceMsgList.totalPage}" var="pag" step="1">	
											<c:if test="${requestScope.maintenanceMsgList.currPage == pag}">										
												<a style="background:rgb(255,132,137);color:#fff" href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
											</c:if>
											<c:if test="${requestScope.maintenanceMsgList.currPage != pag}">
												<a href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
											</c:if>
										</c:forEach>
									</c:if>
									
									<c:if test="${requestScope.maintenanceMsgList.currPage < requestScope.maintenanceMsgList.totalPage -4}">
										<c:forEach begin="${requestScope.maintenanceMsgList.currPage - 2}" end="${requestScope.maintenanceMsgList.currPage + 2}" var="pag" step="1">												
											<c:if test="${requestScope.maintenanceMsgList.currPage == pag}">
												<a  style="background:rgb(255,132,137);color:#fff" href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
											</c:if>
											<c:if test="${requestScope.maintenanceMsgList.currPage != pag}">
												<a href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
											</c:if>
										</c:forEach>
										<a >...</a>
										<a href="./findMaintenanceMsgList?currentPage=${requestScope.maintenanceMsgList.totalPage}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${requestScope.maintenanceMsgList.totalPage}</a>
									</c:if>
								</c:if>
							</c:if>
							
							<c:if test="${requestScope.maintenanceMsgList.totalPage <= 5}">
								<c:forEach begin="1" end="${requestScope.maintenanceMsgList.totalPage}" var="pag" step="1">	
									<c:if test="${requestScope.maintenanceMsgList.currPage == pag}">
										<a style="background:rgb(255,132,137);color:#fff" href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${requestScope.maintenanceMsgList.currPage}</a>
									</c:if>
									<c:if test="${requestScope.maintenanceMsgList.currPage != pag}">
										<a href="./findMaintenanceMsgList?currentPage=${pag}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}">${pag}</a>
									</c:if>
								</c:forEach>
							</c:if>
							
							<c:if test="${requestScope.maintenanceMsgList.currPage < requestScope.maintenanceMsgList.totalPage}">
								<a href="./findMaintenanceMsgList?currentPage=${requestScope.maintenanceMsgList.currPage + 1}&maintenancemodel=${maintenancemodel}&maintenanceName=${maintenanceName}&maintenancePhone=${maintenancePhone}" class="rightjian">></a>
							</c:if>
							<c:if test="${requestScope.maintenanceMsgList.currPage == requestScope.maintenanceMsgList.totalPage}">
							<a class="rightjian">></a>
							</c:if>
							
							<div class="tiaozhuan">
								到第<input type="text" class="tiao" />页
							</div>
							<a class="sure">GO</a>
							<input type="hidden" id="totpages" value="${requestScope.maintenanceMsgList.totalPage}"/>
						</section>
        	</div>
     	   

<!--rightbottom end-->
			</div>
			</div>
		</div>		
		
	</body>
</html>
