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
		<script src="${pageContext.request.contextPath }/js/foodquery.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/foodquery.css" />
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
			<dt class="cont special">食谱管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd they special"><a href="${pageContext.request.contextPath }/Recipes/Recipeslist">食谱查询</a></dd>
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
							<img class="laba" src="${pageContext.request.contextPath }/img/laba.png" />
							<span class="weizhi">当前位置：食谱管理 > 食谱查询</span>
						</section>
						<!--当前位置结束-->
					</div>

					<div class="rightBottom1">
						<div class="category">
							<span>后台类目</span>
							<div class="select-menu">
								<div class="select-menu-div">
									<input id="No1" readonly value="${recipestypename}" class="select-menu-input">
									<img src="${pageContext.request.contextPath}/img/jian2.png">
								</div>
								<ul class="select-menu-ul">
									<c:forEach items="${recipestypeList}" var="x">		
									<li>${x.recipestypename}<img src="${pageContext.request.contextPath }/img/hui.png" /></li>								
								</c:forEach>
								</ul>
							</div>
						</div>
						
						
						<div class="fenlei">
							<div class="sku_t pinpai" >
								<label> 状态 </label>
								<div class="pin">
									<div>
										<c:if test="${recipestate == null}">
											<input id="No2" readonly="" value="全部" class="select-menu-input">
										</c:if>
										<c:if test="${recipestate == 1}">
											<input id="No2" readonly="" value="上架" class="select-menu-input">
										</c:if>
										<c:if test="${recipestate == 0}">
											<input id="No2" readonly="" value="下架" class="select-menu-input">
										</c:if>
										<c:if test="${recipestate == 2}">
											<input id="No2" readonly="" value="已提交" class="select-menu-input">
										</c:if>
										<img src="${pageContext.request.contextPath }/img/jian2.png">
									</div>
									<ul>
										<li>全部</li>
										<li>上架</li>
										<li>下架</li>
										<li>已提交</li>
									</ul>
								</div>
							</div>
						</div>	
							
						<div class="chaxun">
							<button id="chaxun"><img src="${pageContext.request.contextPath }/img/fangda.png"/>查询</button>
						</div>
						<c:if test="${recipestate != 1}">
							<div class="shangjia chaxun">
								<button class="btnshangjai"><img src="${pageContext.request.contextPath }/img/piliang.png"/>批量上架</button>
							</div>
						</c:if>
						<c:if test="${not empty recipesList.lists}">
						<div class="goods">
							<ul class="row uls">
								<li>
									<input class="quanbu" type="button" /><img class="xia_sel" src="${pageContext.request.contextPath}/img/xia0.png"/>
									<div class="xia_box">
										<span>全选<input class="q_xuan" type="button"></span><br />
										<span>取消<input class="q_quxiao" type="button"></span>
									</div>
								</li>
								<li>缩略图</li>
								<li>类目</li>
								<li>名称</li>
								<li>状态</li>
								<li>操作</li>
							</ul>
							
							<div class="text">							 
								<c:forEach items="${recipesList.lists}" var="x">
									<ul class="row">
										<li><input class="a" type="button" value="${x.recipesid}"/></li>
										<li><img src="${x.recipesSwiper[0].recipesswiperimg}"/></li>
										<li>${x.recipesType.recipestypename}</li>
										<li class="name">${x.recipestitle}</li>
										<c:if test="${x.recipestypestate == 1}">
											<li>上架</li>
								 		</c:if>
								 		<c:if test="${x.recipestypestate == 2}">
											<li>已提交</li>
								 		</c:if>
								 		<c:if test="${x.recipestypestate == 0}">
											<li>下架</li>
								 		</c:if>
										<li class="xiou">
											<a href="${pageContext.request.contextPath}/Recipes/editPage?recipesId=${x.recipesid}&currentPage=${recipesList.currPage}&recipestypename=${recipestypename}&recipestate=${recipestate}">修改</a><br/>
											<c:if test="${x.recipestypestate == 1}">
												<a href="${pageContext.request.contextPath}/Recipes/unshelveRecipes?recipesId=${x.recipesid}&currentPage=${recipesList.currPage}&recipestypename=${recipestypename}&recipestate=${recipestate}">下架</a><br/>
											</c:if>
											 <c:if test="${x.recipestypestate == 0 || x.recipestypestate == 2}">
												<a href="${pageContext.request.contextPath}/Recipes/putawayRecipes?recipesId=${x.recipesid}&currentPage=${recipesList.currPage}&recipestypename=${recipestypename}&recipestate=${recipestate}">上架</a><br/>
											</c:if>
											<a class="shan" href="${pageContext.request.contextPath}/Recipes/delete?recipesId=${x.recipesid}" onClick="return confirm('确定要删除这条信息吗？');">删除</a>
										</li>
									</ul>
								</c:forEach> 
							</div>
							 	<section class="fenye">
								<c:if test="${recipesList.currPage > 1}">
									<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${recipesList.currPage - 1}&recipestypename=${recipestypename}&recipestate=${recipestate}" class="leftjian"><</a>	
								</c:if>
								<c:if test="${recipesList.currPage == 1}">
									<a class="leftjian"><</a>	
								</c:if>
															
								<c:if test="${recipesList.totalPage > 5}">
									<c:if test="${recipesList.currPage <= 5}">	
										<c:forEach begin="1" end="5" var="pag" step="1">	
											<c:if test="${recipesList.currPage == pag}">										
												<a style="background:rgb(255,132,137);color:#fff" href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
											</c:if>
											<c:if test="${recipesList.currPage != pag}">
												<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
											</c:if>
										</c:forEach>
										<a >...</a>
										<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${recipesList.totalPage}&recipestypename=${recipestypename}&recipestate=${recipestate}">${recipesList.totalPage}</a>
									</c:if>
									
									<c:if test="${recipesList.currPage > 5}">	
										<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=1&recipestypename=${recipestypename}&recipestate=${recipestate}">1</a>
										<a >...</a>
										
										<c:if test="${recipesList.currPage >= recipesList.totalPage -4}">
											<c:forEach begin="${recipesList.totalPage-4}" end="${recipesList.totalPage}" var="pag" step="1">	
												<c:if test="${recipesList.currPage == pag}">										
													<a style="background:rgb(255,132,137);color:#fff" href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
												</c:if>
												<c:if test="${recipesList.currPage != pag}">
													<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
												</c:if>
											</c:forEach>
										</c:if>
										
										<c:if test="${recipesList.currPage < recipesList.totalPage -4}">
											<c:forEach begin="${recipesList.currPage - 2}" end="${recipesList.currPage + 2}" var="pag" step="1">												
												<c:if test="${recipesList.currPage == pag}">
													<a  style="background:rgb(255,132,137);color:#fff" href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
												</c:if>
												<c:if test="${recipesList.currPage != pag}">
													<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
												</c:if>
											</c:forEach>
											<a >...</a>
											<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${recipesList.totalPage}&recipestypename=${recipestypename}&recipestate=${recipestate}">${recipesList.totalPage}</a>
										</c:if>
									</c:if>
								</c:if>
								
								<c:if test="${recipesList.totalPage <= 5}">
									<c:forEach begin="1" end="${recipesList.totalPage}" var="pag" step="1">	
										<c:if test="${recipesList.currPage == pag}">
											<a style="background:rgb(255,132,137);color:#fff" href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${recipesList.currPage}</a>
										</c:if>
										<c:if test="${recipesList.currPage != pag}">
											<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${pag}&recipestypename=${recipestypename}&recipestate=${recipestate}">${pag}</a>
										</c:if>
									</c:forEach>
								</c:if>
								
								<c:if test="${recipesList.currPage < recipesList.totalPage}">
									<a href="${pageContext.request.contextPath }/Recipes/Recipeslist?currentPage=${recipesList.currPage + 1}&recipestypename=${recipestypename}&recipestate=${recipestate}" class="rightjian">></a>
								</c:if>
								<c:if test="${recipesList.currPage >= recipesList.totalPage}">
									<a class="rightjian">></a>
								</c:if>
								
								<div class="tiaozhuan">
									到第<input type="text" class="tiao" />页
								</div>
								<a class="sure">GO</a>
								<input type="hidden" id="totpages" value="${recipesList.totalPage}"/>
								<input type="hidden" id="currentpag" value="${recipesList.currPage}"/>
							</section>
						</div>
					</c:if>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>









