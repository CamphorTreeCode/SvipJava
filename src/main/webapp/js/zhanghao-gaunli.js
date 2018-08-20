$(function(){
	
	//点击going按钮跳转
	 $(document).on('click', '.sure', function() {
		 
		 var currentPage = $(".tiao").val().trim();
	
		 var franchiserUserUserName = $(".name_1").val().trim();

		 var franchiserUserAccounts = $("#time").val().trim();

		 var franchiserUserPid = $(".pdd").val().trim();

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
		
		if(franchiserUserUserName != "") {
			franchiserUserUserName = "&franchiserUserUserName=" + franchiserUserUserName;
		 }
		
		if(franchiserUserAccounts != "") {
			franchiserUserAccounts = "&franchiserUserAccounts=" + franchiserUserAccounts;
		 }
		
		if(franchiserUserPid != "") {
			franchiserUserPid = "&franchiserUserPid=" + franchiserUserPid;
		 }

		 window.location.href="findFranchiserUserList?" + currentPage + franchiserUserUserName + franchiserUserAccounts + franchiserUserPid;

	 })
	 
	 $(".xiu").click(function(){
	    	   var a=confirm("确定要删除这条信息吗？")
		        
		        if(a){
		        	window.location.href="deleteFranchiserUser?franchiserUserId="+$(this).attr("value")+""
		          return true;
		        }else{
		           return false;
		        }
	       })
	
	
})