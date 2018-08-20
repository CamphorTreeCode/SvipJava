$(document).ready(function(){
	
	//添加
	var index="";
	/*$(".add").on('click',function(){		
		var category=$(".Category").val();
		arr.push(category);
		var combination=arr.length;
		//获取数组的下标
		var subscript=combination-1;
		$(".option").append('<section class="row dynamic"><div class="col-lg-1">'+combination+'</div><div class="col-lg-10"><p>'+arr[subscript]+'</p></div><div class="col-lg-1"><span class="xiu">修改 </span><span class="shan"> 删除</span></div></section>');
//       alert(arr);
	})
	*/
	
	$('.Category').keydown(function(event){
		if(event.which==13){
			return false;     	
		}
	})
	$('.text').keydown(function(event){
		if(event.which==13){
			return false;     	
		}
	})
	
	//删除
	$(document).on('click',".shan",function(){
		var variable=$(this).parent().parent().index();//获取section的长度
	
		var indexone=variable-1;//获取sectiond的下标
			
//		alert(indexone)
		arr.splice(indexone,1)
//		alert(arr)
		$("section").remove();
		
		$(arr).each(function(i,e){
        var mly=i+1;		
		$(".option").append('<section class="row dynamic"><div class="col-lg-1">'+mly+'</div><div class="col-lg-10"><p>'+e+'</p></div><div class="col-lg-1"><span class="xiu">修改 </span><span class="shan"> 删除</span></div></section>');				
	})
				
	})
	
	
    	//修改
        $(document).on('click',".xiu",function(){
    		index=$(this).parent().parent().index()-1;
//  		alert(index)
    		var value=$(this).parent(".col-lg-1").siblings(".col-lg-10").find("p").text();
//	        alert(value)
	        var Rendering=value;
	        $(".primary").text(Rendering);
			$(".Popup").fadeIn();
    	})
    	
    	
    	//取消修改
    	$(document).on('click',".bon",function(){
			$(".Popup").fadeOut();
			return false;
		
    	})

    	

    	//确认修改,食谱类目和判断不能重复修改
    	$(document).on('click',".btt",function(){
//  		alert(index)
    		var Obtain=$(".text").val();
    		
    		if(Obtain==""||Obtain==null||Obtain=='undefind'){
				alert('食谱类目名称不能为空');
				return false;
    		}
    		
    		var recipestypeid=$("[name=recipestypeid]").val();
    		
	    	$.post("admin/RecipesType/editRecipesTypeXY",{Obtain:Obtain,recipestypeid:recipestypeid},function(data){
	   	        //食谱类目校验判断
	   	        if(data=="0"){
	   	        	alert("您输入的食谱类目名称重复");
	   	        	return false;
	   	        }else{
	   	        	/*$(".dynamic").eq(index).find(".col-lg-10").find("p").text(Obtain);*/
	   	        	$(".Popup").fadeOut()
	   	        	$("#edit").submit();
	   	        }
	    	})
    		;
    		return false;
    	})
    	
			//添加食谱类目和判断不能重复添加
			$(".add").click(function() {
				var aa = $('.Category').val();
				if (aa == "" || aa == null || aa == 'undefind') {
					alert('食谱类目名称不能为空');
					return false;
				}
				$.post("admin/RecipesType/addRecipesTypeXY", {
					aa : aa
				}, function(data) {
					//食谱类目校验判断
					if (data == "0") {
						alert("您输入的食谱类目名称重复");
						return false;
					} else {
						$("#add").submit();
					}
				})
				return false;
			})

			$(".shan").click(function(){
	    	   var a=confirm("确定要删除这条信息吗？此操作会删除该类目下所有食谱信息！")
		        
		        if(a){
		        	window.location.href="admin/RecipesType/delete?recipesTypeId="+$(this).attr("value")+""
		          return true;
		        }else{
		           return false;
		        }
			})
	       
	       $(".xiu").click(function(){
		          $(".cc").find("[name=recipestypeid]").val($(this).attr("value"))
		     })
		     
		   $(".bon").click(function(){$(".Popup").fadeOut(); return false;})
    	

})