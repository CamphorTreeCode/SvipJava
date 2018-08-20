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
		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<script src="${pageContext.request.contextPath }/js/webuploader.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/diyUpload.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/globle.css" />
		<link rel="stylesheet" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/Initialization.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/indexone.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/addgoods.css" />		
		<script src="${pageContext.request.contextPath }/js/addgoods.js"></script>
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
			<dt class="con special">商品管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd us"><a href="${pageContext.request.contextPath }/admin/shop/shopList">商品查询</a></dd>
			<dd class="first_dd our special"><a href="${pageContext.request.contextPath }/admin/shop/addPage">添加商品</a></dd>
		</dl>
		<dl class="cloud">
			<dt class="cont">食谱管理<img src="${pageContext.request.contextPath }/img/xiajiantou.png"></dt>
			<dd class="first_dd they"><a href="${pageContext.request.contextPath }/Recipes/Recipeslist">食谱查询</a></dd>
			<dd class="first_dd them"><a href="${pageContext.request.contextPath }/Recipes/addRecipesPage">添加食谱</a></dd> 
		</dl>
		
		<dl class="source">
			<dt class="is"><a href="${pageContext.request.contextPath }/admin/franchiserUser/findFranchiserUserList">账号管理</a></dt>
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
							<img class="laba" src="img/laba.png" />
							<span class="weizhi">当前位置：商品管理 > 添加商品</span>
						</section>
						<!--当前位置结束-->
					</div>

					<div class="rightBottom1">					
						<div class="top">
							<img src="img/jia (3).png" />添加商品
						</div>
						
						<div class="category">
							<span>后台类目</span>

							<div class="select-menu">
								<div class="select-menu-div">
									<input id="No1" readonly value="${shopTypeDefault.shoptypename}" class="select-menu-input">
									<img src="img/jian2.png">
								</div>
								<ul class="select-menu-ul">
									<c:forEach items="${shopTypeList}" var="shoptyp"> 
										<li value1="${shoptyp.shoptypeid}">${shoptyp.shoptypename}<img src="img/hui.png" /> </li>
									</c:forEach>
								</ul>

							</div>
						</div>
						<div class="top ">
							<img src="img/jia (3).png" />基本信息
						</div>
						<div class="information">
							<p><span>品牌</span><textarea id="shopname"></textarea></p>
						</div>
						<div class="information">
							<p><span>商品标题</span><textarea id="biaoti" placeholder="2-40个汉字长度"></textarea></p>
						</div>
						<div class="information">
							<p><span>型号</span><textarea id="shopmodel"></textarea></p>
						</div>
						<div class="superbig">
							<label class="linelabel">商品组图</label>

							<ul class="upload-ul clearfix">
								<li class="upload-pick">
									<img class="img" src="img/photo.png">
									<div class="webuploader-container clearfix" id="goodsUpload">
										<div class="webuploader-pick"></div>
										<div id="rt_rt_1cdeb3p51dou6ila4e139qlve1" style="position: absolute; top: 0px; left: 0px; width: 118.938px; height: 118.938px; overflow: hidden; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept=""><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div>
									</div>
								</li>
							</ul>
						</div>
				
						<div class="information">
							<p><span>优惠券链接</span><textarea id="shopdisurl"></textarea></p>
						</div>
						<div class="information">
							<p><span>商品链接</span><textarea id="shopurl"></textarea></p>
						</div>
						<div class="information">
							<p><span>优惠券面额</span><textarea id="shopdiscMoney"></textarea></p>
						</div>
						<div class="information">
							<p><span>游客优惠券</span><textarea id="touristShopDiscountUrl"></textarea></p>
						</div>
						<div class="information">
							<p><span>游客优惠面额</span><textarea id="touristShopDiscountMoney"></textarea></p>
						</div>
						<div class="information miaoshu">
							<!--<p>-->
							<span>宝贝描述</span>
							<div class="baobei">
								<div class="active22" style="display: inline-block;">
									<!-- <div class="aa"><input class="aw" value="" placeholder="商品标签"/><img class="enm" src="img/shan.png" /></div>	 -->													
								</div>
								<button class="btn_baobei"><img src="img/jia (2).png"/></button>
							</div>
							<!--</p>-->
						</div>
						<div class="information skustate">
							<p>
								<span>SKU属性</span>
								<div class="content">
									<div class="sku_1">
										<p>
											规格<input type="text" class="shopSUKspec"/>
											SKU<input type="text" class="shopSUK"/>
											价格<input type="text" class="shopSUKpric"/>
											库存<input type="text" class="shopSUKstoc"/>
										</p>
										<img class="imgs btnjia" src="img/jia(5).png" />
										<img class="imgs1 btnshan" src="img/jian.png" />
										<ul class="upload-ul clearfix upaw">
											<li class="upload-pick ">
												<img class="img" src="img/photo.png">
												<div class="webuploader-container clearfix" id="goodsUpload0">
													<div class="webuploader-pick"></div>
													<div id="rt_rt_1cdeivpoa1vsg195511pi1044u4a1" style="position: absolute; top: 0px; left: 0px; width: 118.938px; height: 118.938px; overflow: hidden; bottom: auto; right: auto;">
														<input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept="">
														<label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
													</div>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</p>
						</div>

						<div class="top">
							<img src="img/jia (3).png" />图文详情
						</div>
						<form action="./admin/shop/addSave" method="post">
							<section class="bianji">
								<div class="note-editor note-frame panel panel-default">
									<script id="container" name="shopcontent" type="text/plain" style="height:252px"></script>							
								</div>
							</section>
							
							<div class="top">
								<img src="img/jia (3).png" />商品属性
							</div>
							
							<div class="information shangpin">
								<p class="spshuxing">
									<input  class="propsName" placeholder="属性名"></input>
									<img class="imgs btnjia" src="img/jia(5).png" />
									<img class="imgs1 btnshan" src="img/jian.png" />
									<textarea class="propert" placeholder="商品属性值"></textarea>
								</p>
							</div>						
							<input type="hidden" name="shoptypeid" value="${shopTypeDefault.shoptypeid}">						
							<input type="hidden" name="shopstate">
							<input type="hidden" name="shopname">
							<input type="hidden" name="shoptitle">
							<input type="hidden" name="shopmodel">							
							<input type="hidden" name="shopurl">
							<input type="hidden" name="shopdiscounturl">
							<input type="hidden" name="shopDiscountMoney">						
							<input type="hidden" name="shoplable">
							<input type="hidden" name="shopdetails">
							<input type="hidden" name="shopswires">
							<input type="hidden" name="shopswireslist">
							<input type="hidden" name="touristShopDiscountUrl">
							<input type="hidden" name="touristShopDiscountMoney">
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