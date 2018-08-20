     $(function() {
    	
    	 /*查询按钮事件*/
    	 $(document).on('click', '#btnchaxun', function() {
    	 		var retype = $("#No1").val().trim();
		 		var restatus = $("#No2").val().trim();
		 		var shoptit = $("#shoptitle").val().trim();
		 		var shopnam = $("#shopname").val().trim();
		 	
		 		var revalue ="";
		 		if(restatus == "上架"){
		 			revalue = "&shopState=1";
		 		} else if(restatus == "下架"){
		 			revalue = "&shopState=0";
		 		} else if(restatus == "已提交"){
		 			revalue = "&shopState=2";
		 		} 
		 		
		 		var shopName ="";
		 		if(shopnam !="") {
		 			shopName = "&shopName=" + shopnam;
		 		}
		 		
		 		var shopTitle="";
		 		if(shoptit !="") {
		 			shopTitle = "&shopTitle=" + shoptit;
		 		}
		 		window.location.href="shopList?shopTypeName=" + retype + revalue + shopName + shopTitle;
    	 	})
    	 	
    	 	//给每一页跳转的a加样式
    	 	/*$(document).on('click','.fenye a',function(){
    	 		$('.fenye a').css({"background":"rgb(255,255,255)","color":"#999"})
    	 		$(this).css({"background":"rgb(255,132,137)","color":"rgb(255,255,255)"})
    	 	})*/
    	 	
    	 	
    	 	//点击going按钮跳转
    	 	 $(document).on('click', '.sure', function() {
    	 		 
    	 		 var currentPage = $(".tiao").val().trim();
    	 	
    	 		 var shopTypeName = $("#No1").val().trim();

    	 		 var shopState = $("#No2").val().trim();
  
    	 		 var shopName = $("#shopname").val().trim();

    	 		 var shopTitle = $("#shoptitle").val().trim();
    	
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
    	 		if(shopTypeName != "") {
    	 			shopTypeName = "&shopTypeName=" + shopTypeName;
    	 		 }
    	 		
    	 		if(shopState !="") {
    	 			if(shopState == "上架"){
    	 				shopState = "&shopState=1";
    		 		} else if(shopState == "下架"){
    		 			shopState = "&shopState=0";
    		 		} else if(shopState == "已提交"){
    		 			shopState = "&shopState=2";
    		 		} else{
    		 			shopState = "";
    		 		}
    	 		 }
    	 		
    	 		if(shopName != "") {
    	 			shopName = "&shopName=" + shopName;
    	 		 }
    	 		if(shopTitle != "") {
    	 			shopTitle = "&shopTitle=" + shopTitle;
    	 		 }
    
    	 		 window.location.href="shopList?" + currentPage + shopTypeName + shopState + shopName + shopTitle;

    	 	 })


			//全选按钮
    	 	 var arrshu=[0,0,0,0,0];
			$(".text").on('click', '.a', function() {
				var sp=$(this).val();
				var ss = $(this).parent().parent().index();
				if( arrshu[ss] != 0) {
					arrshu[ss] = 0;
					$(".a").eq(ss).css({
						"background": "url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)",
						"background-size": "contain"
					});

				} else if(arrshu[ss] == 0) {
					arrshu[ss] = sp;
					$(".a").eq(ss).css({
						"background": "url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)",
						"background-size": "contain"
					});
				}
				
			})

			//商品批量上架按钮
			$(document).on('click', '.btnshangjai', function() {
				
				var choseStr = "&choseStr=" + arrshu.join("-");
				var currentPage = "currentPage=" + $("#currentpag").val();
				var shopTypeName = $("#No1").val().trim();
	   	 		var shopState = $("#No2").val().trim();
	   	 		var shopName = $("#shopname").val().trim();
	   	 		var shopTitle = $("#shoptitle").val().trim();
		   	 	if(shopTypeName != "") {
		 			shopTypeName = "&shopTypeName=" + shopTypeName;
		 		 }
		 		
		 		if(shopState !="") {
		 			if(shopState == "上架"){
		 				shopState = "&shopState=1";
			 		} else if(shopState == "下架"){
			 			shopState = "&shopState=0";
			 		} else if(shopState == "已提交"){
			 			shopState = "&shopState=2";
			 		} else{
			 			shopState = "";
			 		}
		 		 }
		 		
		 		if(shopName != "") {
		 			shopName = "&shopName=" + shopName;
		 		 }
		 		if(shopTitle != "") {
		 			shopTitle = "&shopTitle=" + shopTitle;
		 		 }
		
				 window.location.href="batchPutawayShop?" + currentPage + shopTypeName + shopState + shopName + shopTitle + choseStr;
			})
			
			//全选按钮
			var quanbu=0;
			$(document).on('click','.quanbu',function(){
				quanbu++;
				var ss=$(".text ul").length;
				
				//取消
				if(quanbu%2==0){
					for(var x=0;x<ss;x++){
						var sp=$(".text .a").eq(x).val();
						arrshu[x] = 0;
						$(".a").eq(x).css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
						$(".quanbu").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
					}
				}else{//选中
					for(var x=0;x<ss;x++){
						var sp=$(".text .a").eq(x).val();
						arrshu[x] = sp;
						$(".a").eq(x).css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)","background-size":"contain"});
						$(".quanbu").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)","background-size":"contain"});
					}
				}

			})
			
			
			
			//下拉框显示按钮
			$(document).on('click','.q_xuan',function(){
				var ss=$(".text ul").length;
					$(this).css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)","background-size":"contain"});
					$(".q_quxiao").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
					for(var x=0;x<ss;x++){
						var sp=$(".text .a").eq(x).val();
						arrshu[x] = sp;
						$(".a").eq(x).css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)","background-size":"contain"});
						$(".quanbu").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)","background-size":"contain"});
					}
			})
			
			//下拉框隐藏按钮
			$(document).on('click','.q_quxiao',function(){
				var ss=$(".text ul").length;
				$(this).css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/60631741-6bff-4098-96d6-10ac25adefbf.png)","background-size":"contain"});
				$(".q_xuan").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
					for(var x=0;x<ss;x++){
						arrshu[x] = 0;
						$(".a").eq(x).css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
						$(".quanbu").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
					}
			})
			
			//下拉框显示和隐藏
			var xia_sel=0;
			$(".xia_sel").click(function(){
				xia_sel++;
				$(".q_xuan").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
				$(".q_quxiao").css({"background":"url(https://www.chuanshoucs.com/ServerImg/2018-05-28/aa99ad25-7d57-4c46-8ebb-fe275b5e0b5a.png)","background-size":"contain"});
				if(xia_sel%2==0){
					$(".xia_box").css("display","none");
				}else{
					$(".xia_box").css("display","block");
				}
				
			})
			
			
			//selectOne手风琴效果
			$(".select-menu").on('click',function(){
				$(".select-menu-ul").slideToggle(300);
				$(".pin").find("ul").hide();
			})
			
			$(".select-menu-ul li").click(function() {
				var con = $(".select-menu-ul li").eq($(this).index()).text();
				$(".select-menu-div input").val(con)
			})
			

			//selectTow手风琴效果
			$(".pin").on('click',function(){
				$(this).find("ul").slideToggle(300);
				$(".select-men").find("ul").hide();
			})
			
			$(".pin ul li").click(function() {
				var con = $(".pin ul li").eq($(this).index()).html();
				$(".pin input").val(con)
			})
			
			setInterval(function(){
				$(".fenlei").css("font-size","0.9rem");
			},1)

		})
		
		


			
		

