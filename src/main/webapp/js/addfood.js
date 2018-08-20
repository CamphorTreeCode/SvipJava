$(function() {

	$(".sku_1").attr("id", "newId");
	$(".imgs1").css("display","none")

	$(".buzhou").on('click', ".btnjia", function() {
		//		console.log($(".buzhou>div").length);
		var tex=$("#newId").find("textarea").val();
		$("#newId").find("textarea").val("");

		if($(".buzhou>div").length >= 10) {
			alert("添加达到限制");
			return false;
		} else {
			$(".buzhou").append($("#newId").clone());
		}
		
		$("#newId").find("textarea").val(tex);
		var s = $(".buzhou .steps").length;
		var a = s;

		s = s - 1;
		$(".skuname").eq(s).html("步骤" + a);

		$(".buzhou .steps").eq(s).find(".webuploader-container").attr("id", "goodsUpload" + s);

		for(var x = 0; x < s; x++) {
			$(".buzhou .steps").eq(x).children(".p2").children(".imgs").css("display", "none");
			$(".buzhou .steps").eq(x).children(".p2").children(".imgs1").css("display", "block")
		}

		//		$(".buzhou>div").eq(x).children(".imgs").css("display", "block")
		$(".buzhou .steps").eq(s).children(".p2").children(".imgs").css("display", "block");
		$(".buzhou .steps").eq(s).children(".p2").children(".imgs1").css("display", "block")
		//		$(".buzhou>div").eq(0).children(".p2").children(".imgs1").css("display", "block")

	})

	$(document).on('click', ".btnshan", function() {
		//			console.log("----------------------------------")
		var s = $(".buzhou>div").length;

		console.log(s)
		
		//		var aw=$(this).parent().parent().index();
		$(".buzhou .steps").eq(1).find(".skuname").html("步骤sss");
		//		for(var x = 0; x < s-1; x++) {
		//			var a=x+1;
		//			$(".buzhou .steps").eq(x).find(".skuname").html("步骤"+a);
		//     		console.log($(".buzhou>div").eq(x).children(".skuname").html())
		//		}

		if(s == 1) {

		} else {

			$(this).parent().parent().remove();
		}

		if(s == 2) {
			s = s - 2;
			//			console.log(s)
			$(".buzhou .steps").eq(s).children(".p2").children(".imgs").css("display", "block")
			$(".buzhou .steps").eq(s).children(".p2").children(".imgs1").css("display", "none")
		} else {
			s = s - 2;
			//			console.log(s)
			$(".buzhou .steps").eq(s).children(".p2").children(".imgs").css("display", "block")
		}

	})

	setInterval(function() {
		$(".buzhou .steps").eq(0).find(".skuname").html("步骤1");
		$(".buzhou .steps").eq(1).find(".skuname").html("步骤2");
		$(".buzhou .steps").eq(2).find(".skuname").html("步骤3");
		$(".buzhou .steps").eq(3).find(".skuname").html("步骤4");
		$(".buzhou .steps").eq(4).find(".skuname").html("步骤5");
		$(".buzhou .steps").eq(5).find(".skuname").html("步骤6");
		$(".buzhou .steps").eq(6).find(".skuname").html("步骤7");
		$(".buzhou .steps").eq(7).find(".skuname").html("步骤8");
		$(".buzhou .steps").eq(8).find(".skuname").html("步骤9");
		$(".buzhou .steps").eq(9).find(".skuname").html("步骤10");

	}, 30)
	
	//多图插件
	var $tgaUpload = $('#goodsUpload0').diyUpload({
		url: './recipeUpload',
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
		}
	});

	//下拉框
	$(".select-menu-ul li").click(function() {
		var con = $(".select-menu-ul li").eq($(this).index()).text();
		$(".select-menu-div input").val(con);
		var typeid = $(this).attr("value1");
		$("[name='recipestypeid']").val(typeid); 
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
	
	//将数据封装到form表单中提交
	function addPropDataForm(status, imgString){
		var stitle = $("#stitle").val().trim();
    	var sdata = $("#sdata").val().trim();
    	$("[name='recipesimg']").val(imgString);    
    	$("[name='recipestitle']").val(stitle);    
    	$("[name='recipesdata']").val(sdata); 
    	$("[name='recipestypestate']").val(status);
	}
	
  //btnpublish按钮
   $("#btnpublish").on('click',function(){   
       	//插件上传
       var imgStr="";
       	$tgaUpload.upload();
       	//每次上传完成回掉
       	$tgaUpload.on("uploadSuccess",function(file,respone){
   	        console.log(respone)
   	       imgStr+=respone._raw+",";
         })
        //全部上传完成触发事件
        $tgaUpload.on("uploadFinished",function(){
        	addPropDataForm(1, imgStr);
	       	$("form").submit();
	     })
   	 return false;
   })
   
    //btnsave按钮
   $("#btnsave").on('click',function(){   
		//插件上传
       var imgStr="";
       	$tgaUpload.upload();
       	//每次上传完成回掉
       	$tgaUpload.on("uploadSuccess",function(file,respone){
   	        console.log(respone)
   	       imgStr+=respone._raw+",";
         })
        //全部上传完成触发事件
        $tgaUpload.on("uploadFinished",function(){
        	addPropDataForm(2, imgStr);
	       	$("form").submit();
	     })
   	 return false;
   })

})