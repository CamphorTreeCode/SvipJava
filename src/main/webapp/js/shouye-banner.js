$(function() {

	

	//上传图片
	var $tgaUpload = $('#goodsUpload').diyUpload({
		url : 'admin/swiper/indexSwiperUpload',
		success : function(data) {},
		error : function(err) {},
		buttonText : '',
		accept : {
			title : "Images",
			extensions : 'gif,jpg,jpeg,bmp,png'
		},
		thumb : {
			width : 120,
			height : 120,
			quality : 100,
			allowMagnify : true,
			crop : true,
			type : "image/jpeg",
		},
		fileNumLimit : 1,
		threads : 1,
	});
	var uploadList = [];
	for (var i = 0; i < 5; i++) {
		uploadList[i] = $('#goodsUpload' + i + '').diyUpload({
			url : 'admin/swiper/indexSwiperUpload',
			success : function(data) {},
			error : function(err) {},
			buttonText : '',
			accept : {
				title : "Images",
				extensions : 'gif,jpg,jpeg,bmp,png'
			},
			thumb : {
				width : 120,
				height : 120,
				quality : 100,
				allowMagnify : true,
				crop : true,
				type : "image/jpeg",
			},
			fileNumLimit : 1,
			threads : 1,
		});

	}
	//页面回显
    //将字符传对象转为一个file对象
	var img = $("[name=hxswiperList]").val();
	var imgList = JSON.parse(img)
    for(var i=0;i<imgList.length;i++){
    	var index=imgList[i].location
    	HX(imgList[i].swiperimg,uploadList[index-1])
    	$($(".save")[index-1]).attr("swiperid",imgList[i].swiperid)
    	$($("select")[index-1]).find("option").each(function(){
    		if($(this).val()==imgList[i].shopId){
    			$(this).attr("selected","selected")
    		}
    		
    	})
    }
	function HX(url,demo){
		var xhr = new XMLHttpRequest();
		xhr.open("GET",url);imgList[0].swiperimg
		xhr.responseType = "blob";
		xhr.send();
		var WebUploadDemo = [];
		var WebUploadIndex = 0;
		xhr.addEventListener('load', function() {
			console.log(xhr.response)
			demo.addFiles(new WebUploader.Lib.File(WebUploader.guid('rt_'), xhr.response))
		});
	}
	



	//      保存按钮
	$('.save').on('click', function() {
		var index=$(this).attr("index");
		var swiperid=$(this).attr("swiperid")
		$("[name=swiperid]").val(swiperid)
		$("[name=location]").val(Number(index)+Number(1))
		uploadList[index].upload();
		uploadList[index].on("uploadSuccess", function(file, respone) {
		console.log(respone._raw)
		$("[name=swiperimg]").val(respone._raw)
	    })
	    uploadList[index].on("uploadFinished", function() {
			$("form").submit();
		})
		return false;
	});
	
	$("select").searchableSelect();
	$(".searchable-select").on('click', function() {
		$(".searchable-select").css("z-index", "0")
		$(this).css("z-index", "1000")
	})
	
	
	//     轮播图
//	var canshu = 0;
//	$(document).on('click', '.diyUploadHover', function() {
//		canshu = $(this).index();
//		$('.lunbo').show();
//		$(".lunbo_c").append($(".upload-ul").clone());
//		$('.lunbo_c').css('height', $(window).height());
//		$(".lunbo_c .upload-pick").remove();
//		$(".lunbo_c .upload-ul").attr('id', 'upload_copy');
//
//		for (var x = 0; x < $("#upload_copy li").length - 1; x++) {
//			$("#upload_copy li").eq(x).css("display", "none");
//		}
//		$("#upload_copy li").eq(canshu).css("display", "block");
//		$(".lunbo_c .upload-box").css('max-height', '12rem');
//	//		$(".upload-ul li").eq(canshu).sibling().css("display","none")
//	//		$(".upload-ul li").eq(canshu).css("display","block");
//	});
//	//     右箭头
//	$(document).on('click', '.btnright', function() {
//		canshu++;
//		if (canshu > $("#upload_copy li").length - 1) {
//			canshu = 0;
//		}
//		for (var x = 0; x < $("#upload_copy li").length; x++) {
//			$("#upload_copy li").eq(x).css("display", "none");
//		}
//		$("#upload_copy li").eq(canshu).css("display", "block");
//	});
//	//     左箭头
//	$(document).on('click', '.btnleft', function() {
//		canshu--;
//		if (canshu < 0) {
//			canshu = $("#upload_copy li").length - 1;
//		}
//		for (var x = 0; x < $("#upload_copy li").length; x++) {
//			$("#upload_copy li").eq(x).css("display", "none");
//		}
//		$("#upload_copy li").eq(canshu).css("display", "block");
//	});
//	//     X号
//	$(document).on('click', '.btncuo', function() {
//		$('.lunbo').hide();
//		$("#upload_copy").remove();
//		canshu = 0;
//	});
//	//     阻止事件冒泡
//	$(document).on('click', '.diyControl', function(e) {
//		e.stopPropagation();
//	});

	


})