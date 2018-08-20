$(function(){
	$(".save").on('click', function(){
		var user = $('#user').val();
		var old = $('#old').val();
		var newPsw = $('#newPsw').val();
		var sure = $('#sure').val();
		if(user == '' || user.length > 20){
			alert('请输入20字以内的用户名');
			return false;
			
		}else if(old == '' || old.length > 10) {
			alert('请输入10字符以内的旧密码')
			return false;
			
		}else if(newPsw == '' || newPsw.length > 10){
			alert('请输入10字符以内的新密码')
			return false;
		
		}else if(sure == '' || sure.length > 10){
			alert('请确认新密码')
			return false;
			
		}else if(!(sure === newPsw)){
			alert("密码不一致");
			return false;
		}else{
			return true;
		}
	})
})
