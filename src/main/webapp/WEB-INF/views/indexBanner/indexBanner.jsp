<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="${pageContext.request.contextPath }/">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>超级VIP后台管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/index.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/rem.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/shouye-banner.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/diyUpload.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath }/js/webuploader.min.js"
	type="text/javascript" charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath }/js/jquery.searchableSelect.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/Initialization.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/indexone.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/globle.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/shouye-banner.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.searchableSelect.css" />
</head>
<body>
	<div class="container-fluid">
		<!--页面开始-->
		<div class="row">
			<!--left二级下拉菜单  begin-->
			<div class="left col-lg-1">
				<div class="leftTop">
					<img src="${pageContext.request.contextPath }/img/viplogo.png"
						class="logo" />
					<div class="center">超级VIP后台管理中心</div>
				</div>


				<div class="leftsidebar_box">
					<dl class="system_log">
						<dt class="safa">
							<a href="${pageContext.request.contextPath }/admin/index/index">后台首页</a>
						</dt>
					</dl>

					<dl class="custom">
						<dt class="dtt">
							商品类目管理<img
								src="${pageContext.request.contextPath }/img/xiajiantou.png">
						</dt>
						<dd class="first_dd we">
							<a href="${pageContext.request.contextPath }/admin/shopType/list">添加类目</a>
						</dd>
					</dl>


					<dl class="app">
						<dt class="ddt">
							食谱类目管理<img
								src="${pageContext.request.contextPath }/img/xiajiantou.png">
						</dt>
						<dd class="sencod_dd">
							<a
								href="${pageContext.request.contextPath }/admin/RecipesType/foodTypelist">添加类目</a>
						</dd>
					</dl>

					<dl class="cloudd">
						<dt class="con">
							商品管理<img
								src="${pageContext.request.contextPath }/img/xiajiantou.png">
						</dt>
						<dd class="first_dd us">
							<a href="${pageContext.request.contextPath }/admin/shop/shopList">商品查询</a>
						</dd>
						<dd class="first_dd our">
							<a href="${pageContext.request.contextPath }/admin/shop/addPage">添加商品</a>
						</dd>
					</dl>
					<dl class="cloud">
						<dt class="cont">
							食谱管理<img
								src="${pageContext.request.contextPath }/img/xiajiantou.png">
						</dt>
						<dd class="first_dd they">
							<a href="${pageContext.request.contextPath }/Recipes/Recipeslist">食谱查询</a>
						</dd>
						<dd class="first_dd them">
							<a
								href="${pageContext.request.contextPath }/Recipes/addRecipesPage">添加食谱</a>
						</dd>
					</dl>

					<dl class="source">
						<dt class="is">
							<a
								href="${pageContext.request.contextPath }/admin/franchiserUser/findFranchiserUserList">账号管理</a>
						</dt>
					</dl>

					<dl class="statistics">
						<dt class="it">
							<a
								href="${pageContext.request.contextPath }/admin/franchiser/findFranchiserList">加盟管理</a>
						</dt>
					</dl>
					<dl class="statistics">
						<dt class="round">
							<a
								href="${pageContext.request.contextPath }/admin/maintenance/findMaintenanceMsgList">维修管理</a>
						</dt>
					</dl>
                     <dl class="statistics"><dt class="refund"><a href="${pageContext.request.contextPath }/admin/refund/list">退款管理</a></dt></dl>
					<dl class="syetem_management">
						<dt class="sun special">
							界面管理<img
								src="${pageContext.request.contextPath }/img/xiajiantou.png">
						</dt>
						<dd class="first_dd you special">
							<a
								href="${pageContext.request.contextPath }/admin/swiper/indexBanner">首页banner</a>
						</dd>
						<dd class="me">
							<a
								href="${pageContext.request.contextPath }/admin/shopType/pre-add">首页展示</a>
						</dd>
						<dd class="my">
							<a href="${pageContext.request.contextPath }/admin/about/pre-add">关于我们</a>
						</dd>
						<dd class="out">
							<a
								href="${pageContext.request.contextPath }/admin/franchiseDetails/pre-add">申请加盟</a>
						</dd>
						<dd class="study">
							<a
								href="${pageContext.request.contextPath }/admin/learningWorld/findLearningWorldList">学习天地</a>
						</dd>
					</dl>

					<dl class="source">
						<dt class="off">模板消息</dt>
					</dl>


				</div>
				<!--left二级下拉菜单  end-->
			</div>



			<div class="right col-lg-11">

				<div class="lunbo">
					<div class="lunbo_c">
						<!--<img src="" />-->
						<img class="btncuo"
							src="${pageContext.request.contextPath }/img/cuo.png" /> <img
							class="btnleft"
							src="${pageContext.request.contextPath }/img/left.png" /> <img
							class="btnright"
							src="${pageContext.request.contextPath }/img/right.png" />
					</div>
				</div>

				<div class="rightTop">

					<div class="rightTop_r">
						<img src="${pageContext.request.contextPath }/img/viplogo.png"
							class="user" /> <span class="name">${user.adminname}</span> <img
							class="xia" src="${pageContext.request.contextPath }/img/xia.png" />
					</div>

					<div class="dogegg">
						<a href="${pageContext.request.contextPath }/login/pre-update">更改信息</a>
						<a href="${pageContext.request.contextPath }/login/tologin">退出登录</a>
					</div>

				</div>

				<div class="rightCenter">



					<!--当前位置  begin-->
					<section class="current">
						<img class="laba"
							src="${pageContext.request.contextPath }/img/laba.png" /> <span
							class="weizhi">当前位置：界面管理 > 首页Banner图管理</span>
					</section>
					<!--当前位置结束-->
				</div>

				<div class="rightBottom">




					<div class="top">
						<img src="img/jia3.png" alt="" /> <span>首页Banner图管理</span>
					</div>
					<form action="admin/swiper/insert" method="post" class="Multi">
					<input type="hidden" name="swiperimg">
					<input type="hidden" name="swiperid">
					<input type="hidden" name="location">
						<div class="food">
							<div class="shangchuan">
								<p class="tupian">展示图片1</p>
								<ul class="upload-ul upload-box clearfix"
									style="position:relative;">
									<li class="upload-pick"><img class="img"
										src="${pageContext.request.contextPath }/img/photo.png" />
										<div class="webuploader-container clearfix" id="goodsUpload0"></div>
									</li>
									<div style="position:absolute; left:15rem; top:3rem">
										<select name="selectShopId">
											<c:forEach items="${shopList}" var="sl">
											   <option value="${sl.shopid }">${sl.shoptitle}</option>
											</c:forEach>
										</select>
										
									</div>
									<p style="position:absolute; left:37rem; top:3rem; color:#999;">最佳尺寸，750×340<p>
									<button class="save" type="submit"  index="0">保存</button>

								</ul>
                                  
							</div>
                            
                            <div class="line"></div>
                            <div class="shangchuan">
								<span class="tupian">展示图片2</span>
								<ul class="upload-ul upload-box clearfix"
									style="position:relative;">
									<li class="upload-pick"><img class="img"
										src="${pageContext.request.contextPath }/img/photo.png" />
										<div class="webuploader-container clearfix" id="goodsUpload1"></div>
									</li>
									<div style="position:absolute; left:15rem; top:3rem">
										<select name="selectShopId">
											<c:forEach items="${shopList}" var="sl">
											   <option value="${sl.shopid }">${sl.shoptitle}</option>
											</c:forEach>
										</select>
									</div>
									<p style="position:absolute; left:37rem; top:3rem; color:#999;">最佳尺寸，750×340<p>
									<button class="save" type="submit" index="1">保存</button>

								</ul>
                                  
							</div>
							<div class="line"></div>
                            <div class="shangchuan">
								<span class="tupian">展示图片3</span>
								<ul class="upload-ul upload-box clearfix"
									style="position:relative;">
									<li class="upload-pick"><img class="img"
										src="${pageContext.request.contextPath }/img/photo.png" />
										<div class="webuploader-container clearfix" id="goodsUpload2"></div>
									</li>
									<div style="position:absolute; left:15rem; top:3rem">
										<select name="selectShopId">
											<c:forEach items="${shopList}" var="sl">
											   <option value="${sl.shopid }">${sl.shoptitle}</option>
											</c:forEach>
										</select>
									</div>
									<p style="position:absolute; left:37rem; top:3rem; color:#999;">最佳尺寸，750×340<p>
									<button class="save" type="submit" index="2">保存</button>

								</ul>
                                  
							</div>
							<div class="line"></div>
                            <div class="shangchuan">
								<span class="tupian">展示图片4</span>
								<ul class="upload-ul upload-box clearfix"
									style="position:relative;">
									<li class="upload-pick"><img class="img"
										src="${pageContext.request.contextPath }/img/photo.png" />
										<div class="webuploader-container clearfix" id="goodsUpload3"></div>
									</li>
									<div style="position:absolute; left:15rem; top:3rem">
										<select name="selectShopId">
											<c:forEach items="${shopList}" var="sl">
											   <option value="${sl.shopid }">${sl.shoptitle}</option>
											</c:forEach>
										</select>
									</div>
									<p style="position:absolute; left:37rem; top:3rem; color:#999;">最佳尺寸，750×340<p>
									<button class="save" type="submit" index="3">保存</button>

								</ul>
                                  
							</div>
							<div class="line"></div>
							<div class="shangchuan">
								<span class="tupian">展示图片5</span>
								<ul class="upload-ul upload-box clearfix"
									style="position:relative;">
									<li class="upload-pick"><img class="img"
										src="${pageContext.request.contextPath }/img/photo.png" />
										<div class="webuploader-container clearfix" id="goodsUpload4"></div>
									</li>
									<div style="position:absolute; left:15rem; top:3rem">
										<select name="selectShopId">
											<c:forEach items="${shopList}" var="sl">
											   <option value="${sl.shopid }">${sl.shoptitle}</option>
											</c:forEach>
										</select>
									</div>
									<p style="position:absolute; left:37rem; top:3rem; color:#999;">最佳尺寸，750×340<p>
									<button class="save" type="submit" index="4">保存</button>

								</ul>
                                  
							</div>
						</div>
					</form>
					<input type="hidden" name="hxswiperList" value='${swiperList}'>
				
			</div>
		</div>
	</div>
</body>
</html>

