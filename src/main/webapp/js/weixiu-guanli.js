$(function(){

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
    	 		 
    	 		 var currentPage = $(".tiao").val().trim();
    	 	
    	 		 var maintenancemodel = $("#time").val().trim();

    	 		 var maintenanceName = $(".name_1").val().trim();
  
    	 		 var maintenancePhone = $(".pdd").val().trim();
    	
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
    	 		
    	 		if(maintenanceName != "") {
    	 			maintenanceName = "&maintenanceName=" + maintenanceName;
    	 		 }
    	 		
    	 		if(maintenancemodel != "") {
    	 			maintenancemodel = "&maintenancemodel=" + maintenancemodel;
    	 		 }
    	 		
    	 		if(maintenancePhone != "") {
    	 			maintenancePhone = "&maintenancePhone=" + maintenancePhone;
    	 		 }
    
    	 		 window.location.href="findMaintenanceMsgList?" + currentPage + maintenancemodel + maintenanceName + maintenancePhone;

    	 	 })
    	 	 
    	 	 $(".xiu").click(function(){
	    	   var a=confirm("确定要删除这条信息吗？")
		        
		        if(a){
		        	window.location.href="deleteMaintenanceMsg?maintenanceId="+$(this).attr("value")+""
		          return true;
		        }else{
		           return false;
		        }
	       })
	
	
})