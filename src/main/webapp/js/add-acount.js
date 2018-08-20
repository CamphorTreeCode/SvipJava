$(function(){
	
	//账号校验
    var ZHweiyi=false;
	 $(".zhanghao").blur(function(){
	    var xiaoyan=$(this).val();
	    $.post("../franchiserUser/zhanghaoXY",{xiaoyan:xiaoyan},function(data){
	        //账号校验判断
	        if(data=="0"){
	        	alert("您输入的账户名称重复");
	        	ZHweiyi =  false;
	        	return false;
	        }else{
	        	ZHweiyi=true;
	        }
	    })
	 })   
	 
	 
	 //用户名校验
	 var YHweiyi=false;
	 $(".username").blur(function(){
	    var xiaoyan=$(this).val();
	    $.post("../franchiserUser/yonghumingXY",{xiaoyan:xiaoyan},function(data){
	        //用户名校验判断
	        if(data=="0"){
	        	alert("您输入的用户名称重复");
	        	YHweiyi =  false;
	        	return false;
	        }else{
	        	YHweiyi=true;
	        }
	    })
	 })   
	 
	  //Pid校验
	 var PIDweiyi=false;
	 $(".pid").blur(function(){
	    var xiaoyan=$(this).val();
	    $.post("../franchiserUser/PIDXY",{xiaoyan:xiaoyan},function(data){
	        //pid校验判断
	        if(data=="0"){
	        	alert("您输入的PID重复");
	        	PIDweiyi =  false;
	        	return false;
	        }else{
	        	PIDweiyi=true;
	        }
	    })
	 })   
	
	
	
	$('.save').on('click',function(){
		var zh=$('.zhanghao').val();
		var yhm=$('.username').val();
		var mm=$('.pwd').val();
		var tb=$('.pid').val();
//		console.log(zh);
//		console.log(yhm);
		var reg1 = /^[a-zA-Z0-9]{1,10}$/;
		var reg=/^(?!([a-zA-Z]+|\d+)$)[a-zA-Z\d]{6,18}$/;
		var regPid=/^mm_[0-9]{1,8}_[0-9]{1,8}_[0-9]{1,9}$/;
	
		if(zh== '' || zh==null || zh==undefined){
			alert('请输入正确的账号名称');
			return false;
		}else if(zh.length>10){
			alert('您输入的账号名称过长,不能超过10个字符');
		    return false;
		}else if(yhm== '' || yhm==null || yhm==undefined) {
			alert('用户名不能为空');
			return false;
		}else if(!reg1.test(yhm)){
			alert('用户名只能输入10个字符以内的英文或者数字');
			return false;
		}else if(mm== '' || mm==null || mm==undefined){
			alert('输入的密码不能为空');
			return false;
		}else if(!reg.test(mm)){
			alert('输入的密码必须为6-18位之间的英文和数字混合密码');
			return false;
		}else if(tb== '' || tb==null || tb==undefined){
			alert('请输入淘宝联盟PID');
			return false;
		}
//		else if(!regPid.test(tb)){
//			alert('请填写规范淘宝联盟三段式PID，例如：mm_12345678_12345678_123456789');
//			return false;
//		}
		else if(ZHweiyi==false){
		    alert("您输入的账号名称重复");
		    return false;
		}else if(YHweiyi==false){
		    alert("您输入的用户名称重复");
		    return false;
		}else if(PIDweiyi==false){
		    alert("您输入的PID重复");
		    return false;
		 }else{
			return true;
		}
	})
	            
			  				 
	     	 		
	
	
	$('.cancel').on('click',function(){
		
	})
})
