$(function() {

	/*$(".but").on("click",function(){
			var name=$(".name_1").val();
			var time=$("#time").val();
			var pdd =$('.pdd').val();
			if ((name==null||name=="")||(time==null||time=="")||(pdd==null||pdd=="")) {
				alert("请填写完整查询信息");
				return false;
			}else if (name.length>20) {
				alert("您填写的名称过长");
				return false;
			}
			return true;	
		})*/

	//点击going按钮跳转
	$(document).on('click', '.sure', function() {

		var currentPage = $(".tiao").val();

		var name = $("[name=name]").val();

		var phone = $("[name=phone]").val();

		var refundState = $("[name=refundState]").val();

		var totalpages = $("#totpages").val();

		var tempcunt = parseInt(currentPage);
		var temptotl = parseInt(totalpages);

		if (tempcunt <= 0 || tempcunt > temptotl) {
			alert("你输入的数据超出页面范围！");
			return false;
		}

		if (currentPage == "") {
			return false;
		}


		currentPage = "currentPage=" + currentPage;


        if(name!=''){
        	name = "&name=" + name;
        }else{
        	name='';
        }
        
        
        if(phone!=''){
        	phone = "&phone=" + phone;
        }else{
        	phone='';
        }
        
        
        
        
        if(refundState!=''){
        	refundState = "&refundState=" + refundState;
        }else{
        	refundState='';
        }


		



		

		window.location.href = "./list?" + currentPage + name + phone + refundState+"";

	})

	$(".xiu").click(function() {
		var a = confirm("确定要删除这条信息吗？")

		if (!a) {
			return  false;
		} 
	})


})