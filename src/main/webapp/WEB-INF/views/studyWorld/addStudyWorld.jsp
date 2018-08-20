<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String qz="${pageContext.request.contextPath }/";
%>
<base href="${pageContext.request.contextPath }/"> 
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>超级VIP后台管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/rem.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/Initialization.css" />
		<link rel="stylesheet" type="text/css" href="css/indexone.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link href="css/studyadd.css" type="text/css" rel="stylesheet" />
		<link href="css/iconfont.css" rel="stylesheet" type="text/css" />
		<link href="css/fileUpload.css" rel="stylesheet" type="text/css">
		<link href="css/globle.css" rel="stylesheet" type="text/css" />
		
		<!-- <style>
			.buttons{
	overflow:hidden;
}
.buttons>span{
	padding: 0.5rem 0;
	float: left;
	width: 10%;
	text-align: center;
	display: inline-block;
	
}
.buttons button{
	border:0;
	border-radius:0.3rem;
	background: rgb(255,132,137);
	color:#fff;
	padding: 0.5rem 2rem;
	margin-right: 1rem;
}
		</style> -->
	</head>
	
	<body>
		<div class="container-fluid">
			<!--页面开始-->
			<div class="row">
				<!--left二级下拉菜单  begin-->
				<div class="left col-lg-1">
					<div class="leftTop">
						<img src="img/viplogo.png" class="logo" />
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
			<dt class="round"><a href="${pageContext.request.contextPath }/admin/maintenance/findMaintenanceMsgList">维修管理</a></dt>
		</dl>
		
             <dl class="statistics"><dt class="refund"><a href="${pageContext.request.contextPath }/admin/refund/list">退款管理</a></dt></dl>
			<dl class="syetem_management">
				<dt class="sun">界面管理<img src="img/xiajiantou.png"></dt>
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
							<span class="weizhi">当前位置：界面管理 > 学习天地 > 添加</span>
						</section>
						<!--当前位置结束-->
					</div>

					<div class="rightBottom">
						<div class="top">
							<img src="img/jia3.png" />添加
						</div>

						<form action="admin/learningWorld/addsave" method="post" class="Multi">
						    <input type="hidden" name="learningworldstate">
                            <input type="hidden" name="studyList"/>
                            <input type="hidden" name="learningworldvideourl"/>
                            <input type="hidden" name="learningworldvideoimgurl"/>
                            <input type="hidden" name="draftstate"/>
							<div class="title">
								<span>标题</span>
								<textarea placeholder="请在此添加动态标题" name="learningworldtitle"></textarea>
								<!--<input placeholder="请在此添加动态标题" />-->
							</div>
							<div class="article">
								<span>添加正文</span>
								<textarea placeholder="请在此添加动态正文" name="learningworldcontent"></textarea>
								<!--<input  class="bta" placeholder="请在此添加动态正文" />-->
							</div>
							
							<div class="buttons">
							     <span>选择上传类型</span>
							     <div>
							          <button class="phone">图片</button>
							          <button class="video">视频</button>
							     </div>							     
							</div>
							
							<div class="superbig">
								<label class="linelabel">上传图片</label>
	
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
							
							<div class="superbig">
								<label class="linelabel">上传视频</label>
	
								<ul class="upload-ul clearfix">
									<li class="upload-pick">
										<img class="img" src="img/photo.png">
										<div class="webuploader-container clearfix" id="badsUpload">
											<div class="webuploader-pick"></div>
											<div id="rt_rt_1cdeb3p51dou6ila4e139qlve1" style="position: absolute; top: 0px; left: 0px; width: 118.938px; height: 118.938px; overflow: hidden; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept=""><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div>
										</div>
									</li>
								</ul>
								
								<label class="linelabel">上传视频封面</label>
	
								<ul class="upload-ul clearfix">
									<li class="upload-pick">
										<img class="img" src="img/photo.png">
										<div class="webuploader-container clearfix" id="badsUploadimg">
											<div class="webuploader-pick"></div>
											<div id="rt_rt_1cdeb3p51dou6ila4e139qlve1" style="position: absolute; top: 0px; left: 0px; width: 118.938px; height: 118.938px; overflow: hidden; bottom: auto; right: auto;"><input type="file" name="file" class="webuploader-element-invisible" multiple="multiple" accept=""><label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label></div>
										</div>
									</li>
								</ul>
							</div>
							
							<div class="head_bot">
								<button class="btn">发布</button>
								<button class="cgxbtn">存入稿箱</button>
								<button class="qxbtn">取消</button>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
<!--	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>-->
<!--	<script type="text/javascript" src="js/fileUpload.js"></script>-->
    <script src="js/diyUpload.js"></script>
	<script src="js/webuploader.min.js"></script>
	<script src="js/addStudyWorld.js"></script>

</html>



<!--记得设置图片和视频的格式-->
<!--记得设置图片和视频的格式-->
<!--记得设置图片和视频的格式-->
<!--记得设置图片和视频的格式-->
<!--记得设置图片和视频的格式-->
<!--记得设置图片和视频的格式-->
<!--记得设置图片和视频的格式-->
