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
		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="${pageContext.request.contextPath }/js/webuploader.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/diyUpload.js"></script>
		<script src="${pageContext.request.contextPath }/js/editfood.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/globle.css" />
		<link rel="stylesheet" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/addfood.css" />
		
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
							<span class="weizhi">当前位置：食谱管理 > 修改食谱</span>
						</section>
						<!--当前位置结束-->
					</div>
					
					<div class="rightBottom1">
						<div class="top">
							<img src="${pageContext.request.contextPath }/img/jia (3).png" />修改食谱
						</div>
						
						<div class="category">
							<span>后台类目</span>
							<div class="select-menu">
								<div class="select-menu-div">
									<input id="No1" readonly value="${recipes.recipesType.recipestypename}" class="select-menu-input">
									<img src="${pageContext.request.contextPath }/img/jian2.png">
								</div>

								<ul class="select-menu-ul">
									<c:forEach items="${recipestypeList}" var="rex">
										<li value1="${rex.recipestypeid}">${rex.recipestypename} <img src="${pageContext.request.contextPath }/img/hui.png" /> </li>
									</c:forEach>
								</ul>
							</div>
						</div>

						<div class="superbig">
							<label class="linelabel">展示图片</label>
							<input type="hidden" name="hxswiperList" value="${recipeImgStr}">
							<ul class="upload-ul clearfix">
								<li class="upload-pick">
								    <img class="img" src="${pageContext.request.contextPath }/img/photo.png">					
									<div class="webuploader-container clearfix" id="goodsUpload0">
										<div class="webuploader-pick"></div>
										<div id="rt_rt_1cdeb3p51dou6ila4e139qlve1" style="position: absolute; top: 0px; left: 0px; width: 118.938px; height: 118.938px; overflow: hidden; bottom: auto; right: auto;">
											<input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="">
											<label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);">
										</label>
										</div>
									</div>
								</li>
							</ul>
							<p><span>食谱标题</span><textarea id="stitle" placeholder="请在此处填写食谱标题">${recipes.recipestitle}</textarea></p>
							
							<p><span>需要材料</span><textarea id="sdata" placeholder="请在此处填写需要的材料">${recipes.recipesdata}</textarea></p>
						</div>
						
						<form action="./updateSave" method="post">
							<div class="top">
								<img src="${pageContext.request.contextPath }/img/jia (3).png" />步骤
							</div>
							
							<div class="buzhou">
								<div class="superbig steps sku_1">							
									<!-- <ul class="upload-ul clearfix"> -->
										<script id="container" name="recipesstep" type="text/plain">${recipes.recipesstep}</script>	
								<!-- 	</ul> -->																						
								</div>
							</div>
							<input type="hidden" name="recipestypeid" value="${recipes.recipesType.recipestypeid}">
							<input type="hidden" name="recipesid" value="${recipes.recipesid}">
							<input type="hidden" name="recipesimg">							
							<input type="hidden" name="recipestitle">
							<input type="hidden" name="recipesdata">
							<input type="hidden" name="recipestypestate">
							<div class="information fot_bottom">
								<button id="btnsave">保存</button>
								<button id="btnpublish">发布</button>
							</div>
					  </form>

					</div>
				</div>
			</div>
		</div>
	</body>
	
    <!-- 配置文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/ued/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/ued/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var ue = UE.getEditor('container');
    </script>

</html>