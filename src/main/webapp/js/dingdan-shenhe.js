$(function(){

$(".but").on("click",function(){
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
	})
	
	
})