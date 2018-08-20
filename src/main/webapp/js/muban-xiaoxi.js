$(function(){
	$('.save').on('click',function(){
		var zh = $('#zhanghao').val();
		var yhm = $('#name').val();
		var mm = $('#password').val();	
		if(zh == ''){
			alert('请输入标题')
			return false;
		}else if(yhm == '') {
			alert('请输入提示')
			return false;
		}else if(mm == ''){
			alert('请输入发件人')
			return false;
		}
		return true;
	})
	
})
