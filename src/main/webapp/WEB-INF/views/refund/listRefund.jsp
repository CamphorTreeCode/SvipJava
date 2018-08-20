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
        <script src="${pageContext.request.contextPath }/js/refund.js" type="text/javascript" charset="utf-8"></script>
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
			<dt class="round"><a href="${pageContext.request.contextPath }/admin/maintenance/findMaintenanceMsgList">维修管理</a></dt>
		</dl>
	    <dl class="statistics">
			<dt class="refund special"><a href="${pageContext.request.contextPath }/admin/refund/list">退款管理</a></dt>
		</dl>
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
     	 		<img class="laba" src="${pageContext.request.contextPath }/img/refund3.png"/>
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
        		
        		<form action="./list" method="post" class="topinput clearfix">
        		
        		<div class="topinput_3">
        				<label>退款人姓名</label>
        				<input type="text" id="time" placeholder="输入用户名称以查询" name="name" value="${name}"/>
        			</div>
        			<div class="topinput_1">
        				<label>联系电话</label>
        				<input type="text" class="name_1" name="phone" value="${phone}"  placeholder="输入用户电话以查询"/>
        			</div>
        			
        			
        			<div class="pid">
        				<label style="line-height:60px;">退款状态</label>
        				<select style="line-height:60px; height:60px; padding: 0 2rem; border:0px;outline: none;appearance: none;-webkit-appearance: none; -moz-appearance: none;" name="refundState">
        				   <option <c:if test="${refundState == 0}">selected</c:if> value="0">全部</option>
        				   <option <c:if test="${refundState == 1}">selected</c:if> value="1">待审核</option>
        				   <option <c:if test="${refundState == 3}">selected</c:if> value="3">未通过</option>
        				   <option <c:if test="${refundState == 2}">selected</c:if> value="2">已退款</option>
        				</select>
        			</div>
        			<button class="but"><img class="imgone" src="${pageContext.request.contextPath }/img/fangda.png"/>查询</button>
        		</form>
        			
        			
        		
        		
        		<div class=" boxone row">
        			<div class="col-lg-2">序号</div>
        			<div class="col-lg-2">退款人姓名</div>
        			<div class="col-lg-2">联系电话</div>
        			<div class="col-lg-2">退款金额</div>
        			<div class="col-lg-2">退款理由</div>   
        			<div class="col-lg-2">状态</div>
        			<div class="col-lg-2">操作</div>
        		</div>
        		
        		<c:forEach items="${refundPage.lists}" var="r" varStatus="xs">
        		<div class=" boxtwo row">
        			<div class="col-lg-2">${(refundPage.currPage-1)*5+xs.index+1}</div>
        			<div class="col-lg-2">${r.name}</div>
        			<div class="col-lg-2">
        				${r.phone}
        			</div>
        			<div class="col-lg-2">${r.money}</div>
        			<div class="col-lg-2">${r.refundReason}</div>
        			<div class="col-lg-2">
        				<c:if test="${r.refundState==1}" >
        				<span style="color: #999"> 待审核 </span>
        				</c:if>
        				<c:if test="${r.refundState==2}" >
        				<span style="color: #25A2FE"> 已退款 </span>
        				</c:if>
        				<c:if test="${r.refundState==3}" >
        				<span style="color: #FF3D46"> 不通过 </span>
        				</c:if>
        			</div> 
        			<div class="col-lg-2">
        				<div class="xiugai">
        					<c:if test="${r.refundState==1}">
        						<a href="./updata?refundId=${r.refundId}" class="cha">审核</a>
        					</c:if>
        					<c:if test="${r.refundState==2 || r.refundState==3}">
        						<a href="./delete?refundId=${r.refundId}" class="xiu">删除</a>
        					</c:if>
        				</div>
        			</div>      
        		</div>
        		</c:forEach>
        			
        		<section class="fenye">
							<c:if test="${requestScope.refundPage.currPage > 1}">
								<a href="./list?currentPage=${requestScope.refundPage.currPage-1}&name=${name}&phone=${phone}&refundState=${refundState}" class="leftjian"><</a>	
							</c:if>
							<c:if test="${requestScope.refundPage.totalPage > 5}">
								<c:if test="${requestScope.refundPage.currPage <= 5}">	
									<c:forEach begin="1" end="5" var="pag" step="1">	
										<c:if test="${requestScope.refundPage.currPage == pag}">										
											<a style="background:rgb(255,132,137);color:#fff" href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
										</c:if>
										<c:if test="${requestScope.refundPage.currPage != pag}">
											<a href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
										</c:if>
									</c:forEach>
									<a >...</a>
									<a href="./list?currentPage=${requestScope.refundPage.totalPage}&name=${name}&phone=${phone}&refundState=${refundState}">${requestScope.refundPage.totalPage}</a>
								</c:if>
								
								<c:if test="${requestScope.refundPage.currPage > 5}">	
									<a href="./list?currentPage=1&name=${name}&phone=${phone}&refundState=${refundState}">1</a>
									<a >...</a>
									
									<c:if test="${requestScope.refundPage.currPage >= requestScope.refundPage.totalPage -4}">
										<c:forEach begin="${requestScope.refundPage.totalPage-4}" end="${requestScope.refundPage.totalPage}" var="pag" step="1">	
											<c:if test="${requestScope.refundPage.currPage == pag}">										
												<a style="background:rgb(255,132,137);color:#fff" href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
											</c:if>
											<c:if test="${requestScope.refundPage.currPage != pag}">
												<a href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
											</c:if>
										</c:forEach>
									</c:if>
									
									<c:if test="${requestScope.refundPage.currPage < requestScope.refundPage.totalPage -4}">
										<c:forEach begin="${requestScope.refundPage.currPage - 2}" end="${requestScope.refundPage.currPage + 2}" var="pag" step="1">												
											<c:if test="${requestScope.refundPage.currPage == pag}">
												<a  style="background:rgb(255,132,137);color:#fff" href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
											</c:if>
											<c:if test="${requestScope.refundPage.currPage != pag}">
												<a href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
											</c:if>
										</c:forEach>
										<a >...</a>
										<a href="./list?currentPage=${requestScope.refundPage.totalPage}&name=${name}&phone=${phone}&refundState=${refundState}">${requestScope.refundPage.totalPage}</a>
									</c:if>
								</c:if>
							</c:if>
							
							<c:if test="${requestScope.refundPage.totalPage <= 5}">
								<c:forEach begin="1" end="${requestScope.refundPage.totalPage}" var="pag" step="1">	
									<c:if test="${requestScope.refundPage.currPage == pag}">
										<a style="background:rgb(255,132,137);color:#fff" href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${requestScope.refundPage.currPage}</a>
									</c:if>
									<c:if test="${requestScope.refundPage.currPage != pag}">
										<a href="./list?currentPage=${pag}&name=${name}&phone=${phone}&refundState=${refundState}">${pag}</a>
									</c:if>
								</c:forEach>
							</c:if>
							
							<c:if test="${requestScope.refundPage.currPage < requestScope.refundPage.totalPage}">
								<a href="./list?currentPage=${requestScope.refundPage.currPage + 1}&name=${name}&phone=${phone}&refundState=${refundState}" class="rightjian">></a>
							</c:if>
							<div class="tiaozhuan">
								到第<input type="text" class="tiao" />页
							</div>
							<a class="sure">GO</a>
							<input type="hidden" id="totpages" value="${requestScope.refundPage.totalPage}"/>
						</section>
        	</div>
     	   

<!--rightbottom end-->
			</div>
			</div>
		</div>		
		
	</body>
</html>
