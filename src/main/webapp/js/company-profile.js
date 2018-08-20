$(function(){
	$('.save').on('click', function(){
		if($('textarea').val() == ''){
			alert('请输入公司简介');
			return false;
		}else {
			console.log('hello world!');
		}
	})
})