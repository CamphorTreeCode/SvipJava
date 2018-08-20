$(document).ready(function() {

	//添加并判断是否重复
	$(".add").click(function() {
		var aa = $('.Category').val();
		if (aa == "" || aa == null || aa == 'undefind') {
			alert('商品名称不能为空');
			return false;
		}

		$.post("./addShopTypeXY", {
			aa : aa
		}, function(data) {
			//商品类目校验判断
			if (data == "0") {
				alert("您输入的商品类目名称重复");
				return false;
			} else {
				$("#add").submit();
			}
		})
		return false;
	})



	//删除
	$(".shan").click(function() {
		var a = confirm("确定要删除这条信息吗？此操作会删除该类目下所有商品信息！")
		if (a) {
			window.location.href = "./delete?shopTypeId=" + $(this).attr("value") + ""
			return true;
		} else {
			return false;
		}
	})




	//修改
	$(document).on('click', ".xiu", function() {
		$("[name=shoptypeid]").val($(this).attr("value"))
		index = $(this).parent().parent().index()-1;
		//  		alert(index)
		var value = $(this).parent(".col-lg-1").siblings(".col-lg-10").find("p").text();
		//	        alert(value)
		$(".primary").text(value);
		$(".Popup").fadeIn();
	})


	//取消修改
	$(document).on('click', ".bon", function() {
		$(".Popup").fadeOut();
		return false;
	})


    //addto No Enter
	$('.Category').keydown(function(event) {
		if (event.which == 13) {
			return false;
		}
	})
	//edit No Enter
	$('.text').keydown(function(event) {
		if (event.which == 13) {
			return false;
		}
	})


	//确认修改
	$(document).on('click', ".btt", function() {

		var Obtain = $(".text").val();
		console.log(Obtain)

		if (Obtain == "" || Obtain == null || Obtain == 'undefind') {
			alert('商品类目名称不能为空');
			return false;
		}

		var shoptypeid = $("[name=shoptypeid]").val();
		$.post("./editShopTypeXY",{Obtain:Obtain,shoptypeid:shoptypeid},function(data){
			
   	        //商品类目校验判断
   	        if(data=="0"){
   	        	alert("您输入的商品类目名称重复");
   	        	return false;
   	        }
   	        else{
   	        	$("#edit").submit();
   	        	
   	        }
    	})
    	
		return false;
		
	})


	//确认修改
	/*$(document).on('click',".btt",function(){
//  		alert(index)
		var Obtain=$(".text").val();
		$(".dynamic").eq(index).find(".col-lg-10").find("p").text(Obtain);
		$(".Popup").fadeOut();
	})*/








})