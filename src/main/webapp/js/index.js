$(function(){
	//left二级下拉菜单
	$(".leftsidebar_box dd").hide();
	//top修改信息
	$(".xia").on('click',function(){
		$(".dogegg").fadeToggle(500);
	});
	
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#111","border-left":"5px solid #111","color":"#abb8c1"});
		$(this).css({"background-color": "#000","border-left":"5px solid #ff8489","color":"#fff"});
        $(this).siblings('dd').slideToggle()
		$(".leftsidebar_box dd").not($(this).siblings('dd')).slideUp();
	});
	
	$(".leftsidebar_box dd").click(function(){
		$(".leftsidebar_box dd").css({"background-color":"#111","border-left":"5px solid #111","color":"#abb8c1"});
		$(this).css({"background-color": "#000","border-left":"5px solid #ff8489","color":"#fff"});

	});
	
	
	//后台首页
	$(".safa").on('click',function(){		
     each();
        $(this).removeClass("safa");
        $(this).addClass("safas");
	})
	
    //商品类目管理
	$(".dtt").on('click',function(){
	 each();
		$(this).removeClass("dtt");
		$(this).addClass("dtts");
	})
	$(".con").on('click',function(){
		  each();
		$(this).removeClass("con");
		$(this).addClass("cons");
	})
	
	//添加类目
	$(".we").on('click',function(){
	 each();
		$(this).removeClass("we");
		$(this).addClass("wes");
	})
	$(".sencod_dd").on('click',function(){
	 each();
		$(this).removeClass("sencod_dd");
		$(this).addClass("sencod_dds");
	})
	
	//食谱类目管理
	$(".ddt").on('click',function(){
	 each();
		$(this).removeClass("ddt");
		$(this).addClass("ddts");
	})
	$(".cont").on('click',function(){
	 each();
		$(this).removeClass("cont");
		$(this).addClass("conts");
	})
	
	//商品查询
	$(".us").on('click',function(){
	 each();
	    $(this).removeClass("us");
		$(this).addClass("uss");		
	})
	$(".they").on('click',function(){
	 each();
	    $(this).removeClass("they");
		$(this).addClass("theys");		
	})
	
	//添加商品
	$(".our").on('click',function(){
	 each();
		$(this).removeClass("our");
		$(this).addClass("ours");
	})
	$(".them").on('click',function(){
	 each();
		$(this).removeClass("them");
		$(this).addClass("thems");
	})
	
	//账户管理
	$(".is").on('click',function(){
	 each();
		$(this).removeClass("is");
		$(this).addClass("iss");
	})
	
	//订单审核
	$(".Order").on('click',function(){
	 each();
		$(this).removeClass("Order");
		$(this).addClass("Orders");
	})
	
	//加盟管理
	$(".it").on('click',function(){
	 each();
		$(this).removeClass("it");
		$(this).addClass("its");
	})
	
	//维修管理
	$(".round").on('click',function(){
		  each();
		$(this).removeClass("round");
		$(this).addClass("rounds");
	})
	
	
	
	
	//界面管理
	$(".sun").on('click',function(){
		  each();
		$(this).removeClass("sun");
		$(this).addClass("suns");
	})
	
	//首页banner
	$(".you").on('click',function(){
		  each();
		$(this).removeClass("you");
		$(this).addClass("yous");
	})
	
	//首页展示
	$(".me").on('click',function(){
		  each();
		$(this).removeClass("me");
		$(this).addClass("mes");
	})
	
	//申请加盟
	$(".out").on('click',function(){
		  each();
		$(this).removeClass("out");
		$(this).addClass("outs");
	})
	
	//关于我们
	$(".my").on('click',function(){
		  each();
		$(this).removeClass("my");
		$(this).addClass("mys");
	})
	
	//学习天地
	$(".study").on('click',function(){
	 each();
		$(this).removeClass("study");
		$(this).addClass("studys");
	})
	
	//模板消息
	$(".off").on('click',function(){
		  each();
		$(this).removeClass("off");
		$(this).addClass("offs");
	})
	
	
	function each(){
		//后台首页
		$(".safas").removeClass("safas").addClass("safa");
		//商品类目管理
		$(".dtts").removeClass("dtts").addClass("dtt");
		//添加类目
		$(".wes").removeClass("wes").addClass("we");
		//添加类目
		$(".sencod_dds").removeClass("sencod_dds").addClass("sencod_dd");
		//食谱类目管理
		$(".ddts").removeClass("ddts").addClass("ddt");
		$(".conts").removeClass("conts").addClass("cont");		
		//商品管理
		$(".cons").removeClass("cons").addClass("con");
		
		//商品查询
		$(".uss").removeClass("uss").addClass("us");
		$(".theys").removeClass("theys").addClass("they");
		//添加商品
		$(".ours").removeClass("ours").addClass("our");
		$(".thems").removeClass("thems").addClass("them");
		//订单审核
		$(".Orders").removeClass("Orders").addClass("Order");		
		//账号管理
		$(".iss").removeClass("iss").addClass("is");
		//加盟管理
		$(".its").removeClass("its").addClass("it");
		//维修管理
		$(".rounds").removeClass("rounds").addClass("round");	
		
		//界面管理
		$(".suns").removeClass("suns").addClass("sun");
		//首页banner
		$(".yous").removeClass("yous").addClass("you");
		//首页展示
		$(".mes").removeClass("mes").addClass("me");
		//申请加盟
		$(".outs").removeClass("outs").addClass("out");
		//关于我们
		$(".mys").removeClass("mys").addClass("my");
		//学习天地
		$(".studys").removeClass("studys").addClass("study");
		//模板消息
		$(".offs").removeClass("offs").addClass("off");
	};	
	
	
	
})