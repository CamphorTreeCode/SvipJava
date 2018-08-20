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
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/rem.js" type="text/javascript" charset="utf-8"></script>
		<!-- <script src="js/baomingbiao.js" type="text/javascript" charset="utf-8"></script> -->
		<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/Initialization.css" />
		<link rel="stylesheet" type="text/css" href="css/indexone.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" type="text/css" href="css/shijian.css"/>
		<link href="css/studyday.css" type="text/css" rel="stylesheet" />
		
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
		
		<dl>
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
							<span class="weizhi">当前位置：界面管理 > 学习天地 > 草稿箱</span>
						</section>
						<!--当前位置结束-->
					</div>
					
					<div class="rightBottom">
						<div class="top">
							<img src="img/xuexi3.png" />草稿箱
						</div>
						<div class="head">
							<form action="admin/learningWorld/findLearningWorldDraftList" method="get">
							<span>时间</span>
							<p>
								<input type="text" id="input15" class="learningWorldCreatTime" name="learningWorldCreatTime"  value="${learningWorldCreatTime}" placeholder="选择时间以查询"/><img src="img/rili.png" />
							</p>
							<button><img src="img/fangda.png" />查询</button>
							</form>
						</div>
						<!--<div class="head_bot">
							<button><img src="img/jia.png" />添加</button>
							<button><img src="img/laji.png" />草稿箱</button>
						</div>-->
						<div class="name">
							<span>序号</span>
							<span>标题</span>
							<span>正文</span>
							<span>图片或视频(缩略图)</span>
							<span>发布时间</span>
							<span>状态</span>
							<span>操作</span>
						</div>
						<c:forEach items="${learningWorldList.lists}" var="lw" varStatus="xb">
						<div class="text">
							<div class="content">
									<ul>
										<li>${(requestScope.learningWorldList.currPage-1)*10+xb.index+1}</li>
										<li>${lw.learningworldtitle }</li>
										<li>${lw.learningworldcontent }</li>
										<!-- 如果有图显示第一张没图没视频    出现占位图start -->
										<!-- 有图显示第一张图 -->
										<c:if test="${lw.learningWorldImg!='[]'}">
											<c:forEach items="${lw.learningWorldImg }" var="limg" begin="0" end="0">
											<li><img src="${limg.learningworldimgurl }"/></li>
											</c:forEach>
										</c:if>
										<!-- 有视频显示图片 -->
										<c:if test="${lw.learningworldvideourl!=''}">
											<li><img src="${lw.learningworldvideoimgurl }"/></li>
										</c:if>
										<!-- 没图没视频出现占位图片 -->
										<c:if test="${lw.learningWorldImg=='[]' && lw.learningworldvideourl==''}">
											<li><img src="img/meitu.jpg"/></li>
										</c:if>
										<!-- 如果有图显示第一张没图    出现占位图end -->
										<li>${lw.learningworldcreattime}</li>
										<c:if test="${lw.learningworldstate==1}"><li id="sj">上架</li></c:if>
										<c:if test="${lw.learningworldstate==0}"><li id="sj">下架</li></c:if>
										<li>
											<a href="admin/learningWorld/HXLearningWorldDetails?learningWorldId=${lw.learningworldid }">修改与查看</a> <br />
											<c:if test="${lw.learningworldstate==0}"><a href="admin/learningWorld/putawayLearningWorldDraft?learningWorldId=${lw.learningworldid}">上架</a> <br /></c:if>
											<a href="admin/learningWorld/deleteLearningWorld?learningWorldId=${lw.learningworldid}" class="shanchu">删除</a>
										</li>
									</ul>
								</div>
								
						</div>
						</c:forEach>
						
			<section class="fenye">
				<c:if test="${requestScope.learningWorldList.currPage > 1}">
					<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${requestScope.learningWorldList.currPage-1}&learningWorldCreatTime=${learningWorldCreatTime}" class="leftjian"><</a>	
				</c:if>
				<c:if test="${requestScope.learningWorldList.currPage == 1}">
					<a class="leftjian"><</a>	
				</c:if>
											
				<c:if test="${requestScope.learningWorldList.totalPage > 5}">
					<c:if test="${requestScope.learningWorldList.currPage <= 5}">	
						<c:forEach begin="1" end="5" var="pag" step="1">	
							<c:if test="${requestScope.learningWorldList.currPage == pag}">										
								<a style="background:rgb(255,132,137);color:#fff" href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
							</c:if>
							<c:if test="${requestScope.learningWorldList.currPage != pag}">
								<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
							</c:if>
						</c:forEach>
						<a >...</a>
						<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${requestScope.learningWorldList.totalPage}&learningWorldCreatTime=${learningWorldCreatTime}">${requestScope.learningWorldList.totalPage}</a>
					</c:if>
					
					<c:if test="${requestScope.learningWorldList.currPage > 5}">	
						<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=1&learningWorldCreatTime=${learningWorldCreatTime}">1</a>
						<a >...</a>
						
						<c:if test="${requestScope.learningWorldList.currPage >= requestScope.learningWorldList.totalPage -4}">
							<c:forEach begin="${requestScope.learningWorldList.totalPage-4}" end="${requestScope.learningWorldList.totalPage}" var="pag" step="1">	
								<c:if test="${requestScope.learningWorldList.currPage == pag}">										
									<a style="background:rgb(255,132,137);color:#fff" href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
								</c:if>
								<c:if test="${requestScope.learningWorldList.currPage != pag}">
									<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
								</c:if>
							</c:forEach>
						</c:if>
						
						<c:if test="${requestScope.learningWorldList.currPage <requestScope.learningWorldList.totalPage -4}">
							<c:forEach begin="${requestScope.learningWorldList.currPage - 2}" end="${requestScope.learningWorldList.currPage + 2}" var="pag" step="1">												
								<c:if test="${requestScope.learningWorldList.currPage == pag}">
									<a  style="background:rgb(255,132,137);color:#fff" href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
								</c:if>
								<c:if test="${requestScope.learningWorldList.currPage != pag}">
									<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
								</c:if>
							</c:forEach>
							<a >...</a>
							<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${requestScope.learningWorldList.totalPage}&learningWorldCreatTime=${learningWorldCreatTime}">${requestScope.learningWorldList.totalPage}</a>
						</c:if>
					</c:if>
				</c:if>
				
				<c:if test="${requestScope.learningWorldList.totalPage <= 5}">
					<c:forEach begin="1" end="${requestScope.learningWorldList.totalPage}" var="pag" step="1">	
						<c:if test="${requestScope.learningWorldList.currPage == pag}">
							<a style="background:rgb(255,132,137);color:#fff"  href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${requestScope.learningWorldList.currPage}</a>
						</c:if>
						<c:if test="${requestScope.learningWorldList.currPage != pag}">
							<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${pag}&learningWorldCreatTime=${learningWorldCreatTime}">${pag}</a>
						</c:if>
					</c:forEach>
				</c:if>
				
				<c:if test="${requestScope.learningWorldList.currPage < requestScope.learningWorldList.totalPage}">
					<a href="admin/learningWorld/findLearningWorldDraftList?currentPage=${requestScope.learningWorldList.currPage + 1}&learningWorldCreatTime=${learningWorldCreatTime}" class="rightjian">></a>
				</c:if>
				<c:if test="${requestScope.learningWorldList.currPage == requestScope.learningWorldList.totalPage}">
				<a class="rightjian">></a>
				</c:if>
				
				<div class="tiaozhuan">
					到第<input type="text" class="tiao" />页
				</div>
				<a class="sure">GO</a>
				<input type="hidden" id="totpages" value="${requestScope.learningWorldList.totalPage}"/>
		</section>
					
					</div>
				</div>
			</div>
		</div>
	</body>
	
	<script src="js/jquer_shijian.js"></script>
	<script type="text/javascript">
		//默认点击显示
		$("#input15").shijian();
		$(".shanchu").click(function(){
		         
		        var a=confirm("确定要删除这条信息吗？")
		        
		        if(a){
		          return true;
		        }else{
		           return false;
		        }
		        
		        
	 
		     

		     })
		     
		     //点击going按钮跳转
	 $(document).on('click', '.sure', function() {

		 var currentPage = $(".tiao").val().trim();
		
		 var learningWorldCreatTime = $(".learningWorldCreatTime").val().trim();

		 var totalpages = $("#totpages").val();
		 
		 var tempcunt = parseInt(currentPage);

		 var temptotl = parseInt(totalpages);
		 
		 if(tempcunt <= 0 || tempcunt > temptotl) {
			 alert("你输入的数据超出页面范围！");
			 return false;
		 } 
		 
		if(currentPage == ""){
			return false;
		}
			 
		if(currentPage != "") {
			currentPage = "&currentPage=" + currentPage;
		 }
		
		if(learningWorldCreatTime != "") {
			learningWorldCreatTime = "&learningWorldCreatTime=" + learningWorldCreatTime;
		 }
		
		 window.location.href="admin/learningWorld/findLearningWorldDraftList?" + currentPage + learningWorldCreatTime;

	 })

	</script>

</html>