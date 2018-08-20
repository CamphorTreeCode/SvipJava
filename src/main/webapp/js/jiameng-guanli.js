$(function(){
/*
$(".buts").on("click",function(){
		var name=$(".name_1").val();
		console.log(name);
		var time=$("#time").val();
		console.log(time);
		var pdd =$('.pdd').val();
		console.log(pdd);
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

		 var currentPage = $(".tiao").val().trim();
		 
	
		 var franchiserName = $(".name_1").val().trim();
		
		 //var franchiserCreatTime = $("#time").val().trim();
	
		 var franchiserOrderNmuber = $(".pdd").val().trim();

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
		
		if(franchiserName != "") {
			franchiserName = "&franchiserName=" + franchiserName;
		 }
		
		/*if(franchiserCreatTime != "") {
			franchiserCreatTime = "&franchiserCreatTime=" + franchiserCreatTime;
		 }*/
		
		if(franchiserOrderNmuber != "") {
			franchiserOrderNmuber = "&franchiserOrderNmuber=" + franchiserOrderNmuber;
		 }

		 window.location.href="findFranchiserList?" + currentPage + franchiserName + franchiserOrderNmuber;

	 })
	 
	 		       
	       $(".xiu").click(function(){
	    	   var a=confirm("确定要删除这条信息吗？")
		        
		        if(a){
		        	window.location.href="delete?franchiserId="+$(this).attr("value")+""
		          return true;
		        }else{
		           return false;
		        }
	       })
	
	
})