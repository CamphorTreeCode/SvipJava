$(function() {

	$(".sku_1").attr("id", "newId")
	$(".shangpin p").attr("id", "newId1")

	$(".skustate .content").on('click', ".btnjia", function() {
		console.log($(".skustate .content>div").length);
		
		if($(".skustate .content>div").length >= 5) {
			alert("添加达到限制");
			return false;
		} else {
			$(".skustate .content").append($("#newId").clone());
		}
		var s = $(".skustate .content>div").length;

		s = s - 1;
		$(".sku_1").eq(s).find("input").val("");
		$(".sku_1").eq(s).find(".diyUploadHover").remove();
		$(".skustate .content>div").eq(s).find(".webuploader-container").attr("id", "goodsUpload" + s + "");
		
		for(var x = 0; x < s; x++) {
			$(".skustate .content>div").eq(x).children(".imgs").css("display", "none");
			$(".skustate .content>div").eq(x).children(".imgs1").css("display", "block")
		}

		$(".skustate .content>div").eq(s).children(".imgs").css("display", "block")
		$(".skustate .content>div").eq(s).children(".imgs1").css("display", "block")
		//		$(".skustate .content>div").eq(0).children(".imgs1").css("display", "block")
	})

	$(".skustate .content").on('click', ".btnshan", function() {

		var s = $(".skustate .content>div").length;

		if(s == 1) {

		} else {
			var num = $(this).parent().index();
			$tgas.splice(1,num+1);
			$(this).parent().remove();
		}

		if(s == 2) {
			s = s - 2;
			$(".skustate .content>div").eq(s).children(".imgs1").css("display", "none");
			$(".skustate .content>div").eq(s).children(".imgs").css("display", "block")
		} else {
			s = s - 2;
			$(".skustate .content>div").eq(s).children(".imgs").css("display", "block")
		}

	})

	$(".shangpin").on('click', ".btnjia", function() {
		$(".shangpin").append("<p class='spshuxing'><input  class='propsName' placeholder='属性名'/><img class='imgs btnjia' src='img/jia(5).png'/><img class='imgs1 btnshan' src='img/jian.png'/><textarea class='propert'></textarea></p>");
		var s = $(".shangpin p").length;

		s = s - 1;
		for(var x = 0; x < s; x++) {
			$(".shangpin p").eq(x).children(".imgs").css("display", "none")
		}

		$(".shangpin p").eq(x).children(".imgs").css("display", "block")
		$(".shangpin p").eq(s).children(".imgs1").css("display", "block")
		$(".shangpin p").eq(0).children(".imgs1").css("display", "block")

	})
	
	setInterval(function() {
		var s = $(".shangpin p").length;
		s--;
		for(var x = 0; x < s; x++) {
			if($(".shangpin input").eq(x).val() == "") {
				$(".shangpin input").eq(x).css("border-radius", "5px")
				$(".shangpin input").eq(x).css("background", "white")
			} else {
				$(".shangpin input").eq(x).css("background", "rgba(1,1,1,0)")
			}
		}
	}, 50)

	$(".shangpin").on('click', ".btnshan", function() {
		var s = $(".shangpin p").length;

		if(s == 1) {

		} else {

			$(this).parent().remove();
		}

		if(s == 2) {
			s = s - 2;
			$(".shangpin p").eq(s).children(".imgs1").css("display", "none");
			$(".shangpin p").eq(s).children(".imgs").css("display", "block")
		} else {
			s = s - 2;
			
			$(".shangpin p").eq(s).children(".imgs").css("display", "block")
		}
	})

	$(".baobei").on('click', '.enm', function() {
		$(this).parent().remove();
	})

	$(document).on('click', '.btn_baobei', function() {
		//每点击一次添加先判断添加组件的长度
	    	var aa=$(".aa").length+1;
	    	if(aa>3){
	    		alert("宝贝描述添加超出限制");
	    		return false;
	    	}else{
	    		
	    	};
		$(".active22").append("<div class='aa'><input class='aw' value='' placeholder='商品描述' maxlength='4' /><img class='enm' src='img/shan.png'/></div>")
		console.log(aa);
	});
	
	/*$(document).on('blur','.aa',function(){
		var aa=$(".aa input").val;
		if(aa.length>5){
			alert("请输入五个字符以内的文字");
		}
	})*/
 
	//正则判断
	$("#biaoti").focus(function() {

	}).blur(function() {
		var biaoti = $("#biaoti").val();
		console.log(biaoti.length)
		if((biaoti == null || biaoti == "")) {
			alert("请输入完整信息");
			return false;
		} else if((biaoti.length > 40) || (biaoti.length < 2)) {
			alert("请输入长度为2-40的汉字");
			return false;
		} 
	})
	//下拉框
	$(".select-menu-ul li").click(function() {
		var con = $(".select-menu-ul li").eq($(this).index()).text();
		$(".select-menu-div input").val(con);
		var typeid = $(this).attr("value1");
		$("[name='shoptypeid']").val(typeid); 
		
	})
	var jishu = 0;

	$(".select-menu").click(function() {
		jishu++;
		if(jishu % 2 == 0) {
			$(".select-menu-ul").css("display", "none");
		} else {
			$(".select-menu-ul").css("display", "block");
		}
	})
	

	//存放上传对象
	var $tgas = new Array(6);

	//多图插件商品轮播图
	$tgas[0] = $('#goodsUpload').diyUpload({
		url: './admin/shop/goodsUpload',
		success: function(data) {},
		error: function(err) {},
		buttonText: '',
		accept: {
			title: "Images",
			extensions: 'gif,jpg,jpeg,bmp,png'
		},
		thumb: {
			width: 120,
			height: 90,
			quality: 100,
			allowMagnify: true,
			crop: true,
			type: "image/jpeg"
		},
		threads: 1,
	});

	//多图插件商品SKU轮播图
	$tgas[1] = $('#goodsUpload0').diyUpload({
		url: './admin/shop/goodsUpload',
		success: function(data) {},
		error: function(err) {},
		buttonText: '',
		accept: {
			title: "Images",
			extensions: 'gif,jpg,jpeg,bmp,png'
		},
		thumb: {
			width: 120,
			height: 90,
			quality: 100,
			allowMagnify: true,
			crop: true,
			type: "image/jpeg"
		},
		threads: 1,
	});
	
	//多图插件商品SKU轮播图
	$(".content").on('click', '.btnjia', function() {
		var skucont = $(".skustate .content>div").length;
		var indexNum = skucont - 1;
		$tgas[skucont] = $("#goodsUpload" + indexNum).diyUpload({
			url: './admin/shop/goodsUpload',
			success: function(data) {},
			error: function(err) {},
			buttonText: '',
			accept: {
				title: "Images",
				extensions: 'gif,jpg,jpeg,bmp,png'
			},
			thumb: {
				width: 120,
				height: 90,
				quality: 100,
				allowMagnify: true,
				crop: true,
				type: "image/jpeg"
			},
			threads: 1,
		});
	})
	
	//存放shop轮播图
	var shopimgStr;
	
	//存放上传图片完成标志
	var flags = [false,false,false,false,false,false];
	
	//存放商品标签
	var shlabels = new Array();
	
	//存放商品属性
	var shopProp = new Array();
	
	//存放sku数据
	var skuObj = new Array();
	
	function addPropDataForm(status, imgString, suklist){
		var shopname = $("#shopname").val().trim();
    	var biaoti = $("#biaoti").val().trim();
    	var shopmodel = $("#shopmodel").val().trim();
    	var shopurl = $("#shopurl").val().trim();
    	var shopdisurl = $("#shopdisurl").val().trim();
    	var shopdiscMoney = $("#shopdiscMoney").val().trim();
    	var labelNo = $(".aw").length;
    	var propsNo = $(".spshuxing").length;
    	var touristShopDiscountMoney = $("#touristShopDiscountMoney").val().trim()
    	var touristShopDiscountUrl = $("#touristShopDiscountUrl").val().trim()
    	for(var i = 0; i < propsNo; i++){
    		var propJson= {name:"",props:""};
    		propJson.name = $(".spshuxing").eq(i).find(".propsName").val();
    		propJson.props = $(".spshuxing").eq(i).find(".propert").val();
    		shopProp.push(propJson);
    	}
    	var proplist = JSON.stringify(shopProp);
    	
    	for(var i = 0; i < labelNo; i++){
    		var label = $(".aw").eq(i).val();
    		shlabels.push(label);
    	}
    	var labellist = JSON.stringify(shlabels);
    	
    	$("[name='shopname']").val(shopname); 
    	$("[name='shopstate']").val(status); 
    	$("[name='shoptitle']").val(biaoti); 
    	$("[name='shopmodel']").val(shopmodel);
    	$("[name='shopurl']").val(shopurl);
    	$("[name='shopdiscounturl']").val(shopdisurl);
    	$("[name='shopDiscountMoney']").val(shopdiscMoney);
    	$("[name='shoplable']").val(labellist);	
    	$("[name='shopdetails']").val(proplist);	
    	$("[name='touristShopDiscountUrl']").val(touristShopDiscountUrl);
    	$("[name='touristShopDiscountMoney']").val(touristShopDiscountMoney);
	}
	
	//循环上传图片
	function imgUploadCircle(index, count, status){
	
		var skuimgStr = "";	
		//启动图片上传
		$tgas[index].upload();
		//存放sku信息的json
		if(index > 0) {
			var obJSon = {shopsku:"",shopskuspecifications:"",shopskuimg:"",shopskumoney:0,shopskustock:0};
			skuObj.push(obJSon);
		}
       	//每次上传完成回掉
		console.log($tgas[index])
		$tgas[index].on("uploadSuccess",function(file,respone){
			
   	       skuimgStr += respone._raw + ",";
         })
        //全部上传完成触发事件
        $tgas[index].on("uploadFinished",function(){   
        	if(index == 0) {
        		shopimgStr= skuimgStr;
        	} else {
        		skuObj[index-1].shopskuspecifications = $(".sku_1").eq(index-1).find(".shopSUKspec").val();
        		skuObj[index-1].shopsku = $(".sku_1").eq(index-1).find(".shopSUK").val();
        		skuObj[index-1].shopskuimg = skuimgStr;
        		skuObj[index-1].shopskustock = $(".sku_1").eq(index-1).find(".shopSUKstoc").val();
        		skuObj[index-1].shopskumoney = $(".sku_1").eq(index-1).find(".shopSUKpric").val();
        		
        	}
        	  
        	//判断是否全部上传完毕
        	flags[index] = true;
        	for(var i = 0; i <= count; i++){
        		if(flags[i] == false) {
        			return false;
        		}
        	}
        	var swirelist = JSON.stringify(skuObj);
        	addPropDataForm(status, shopimgStr, swirelist);
        	$("form").submit();	
	     })
	}

	//btnpublish按钮
    $("#btnpublish").on('click',function(){   
    	var count = $(".sku_1").length;
        for(var i = 0; i <=  count; i++){
     	   
     	   imgUploadCircle(i, count, 1);
        }
     	return false;
    })
    
     
     //btnsave按钮
    $("#btnsave").on('click',function(){   
    	
       var count = $(".sku_1").length;
      
       for(var i = 0; i <=  count; i++){
    	   
    	   imgUploadCircle(i, count, 0);
       }
    	return false;
    });
    
//    $(".propsName").blur(function(){
//    	var propsName=  $(".propsName").val();
//    	if(propsName== '' || propsName==null || propsName==undefined){
//			alert('属性名不能为空');
//			return false;
//    	}
//    })
//     $(".propert").blur(function(){
//    	var propert=  $(".propert").val();
//    	if(propert== '' || propert==null || propert==undefined){
//			alert('属性值不能为空');
//			return false;
//    	}
//    })

})



