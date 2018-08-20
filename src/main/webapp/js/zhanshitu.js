$(function(){
	 //上传图片
        var $tgaUpload = $('#goodsUpload').diyUpload({
            url:'admin/shopType/addTypeAndPhotoUpload',
            success:function( data ) { },
            error:function( err ) { },
            buttonText : '',
            accept: {
                title: "Images",
                extensions: 'gif,jpg,jpeg,bmp,png'
            },
            thumb:{
                width:120,
                height:120,
                quality:100,
                allowMagnify:true,
                crop:true,
                type:"image/jpeg",
            },
            fileNumLimit:1,
            formData:{
            	shoptypeid:'',
            }
        });
//  后台类目框
    $('.kuang').on('click',function(){
    	$('.jiqi').toggleClass('active');
    });
	
    
    $('.jiqi li').each(function(i,e){
    	
    	if($(this).find("span").attr("value")==$("[name=dcshoptypeid]").val()){
    		$('.kuang span').text($(this).find("span").html());	
    		$(this).siblings().find('span').removeClass('yanse')
        	$(this).find('span').addClass('yanse');
        	$(this).siblings().find('img').attr('src','img/hui.png');
        	$(this).find('img').attr('src','img/jian3.png');
        	
        	$('.jiqi').removeClass('active');
    	}
    	
    })
    
   /* var one = $('.jiqi li:first');
    one.find('span').addClass('yanse');
    one.find('img').attr('src','img/jian3.png');
    $('.kuang span').text(one.find('span').html());*/
//下拉列表
    $('.jiqi li').on('click',function(){
    	var zhi = $(this).find('span');
    	$('.kuang span').text(zhi.html());
    	$(this).siblings().find('span').removeClass('yanse')
    	$(this).find('span').addClass('yanse');
    	$(this).siblings().find('img').attr('src','img/hui.png');
    	$(this).find('img').attr('src','img/jian3.png');
    	
    	$('.jiqi').removeClass('active');
    	
    	window.location.href="admin/shopType/pre-add?shoptypeid="+$(this).find("span").attr("value")+"";
    });
    
   	$('.save').on('click',function(){
	   	/*var item = $('#item').val();
	   	if(item==''){
	   	alert('请填写项目介绍')
	   	return false;
   		}
   	 	return true;*/
   	 	//上传图片
	   	
	   	var shoptypeid=$("[name=dcshoptypeid]").val();
	    $tgaUpload.options.formData.shoptypeid=shoptypeid
	    $tgaUpload.upload();
	   	//上传图片完毕后给予提示
	    $tgaUpload.on("uploadSuccess",function(file,respone){
		       if(respone==1){
		    	   window.location.reload();
		    	   alert("修改/添加成功")
		       }
		       
	   	})
	   	return false;
   	})
       
   	

   			//页面回显
  	       //将字符传对象转为一个file对象
  	       var getFileBlob = function (url, cb) {
  	 		  var xhr = new XMLHttpRequest();
  	 		  xhr.open("GET", url);
  	 		  xhr.responseType = "blob";
  	 		  xhr.addEventListener('load', function() {
  	 		  cb(xhr.response);
  	 		  });
  	 		  xhr.send();
  	 		};
  	 		
  	 		var blobToFile = function (blob, name) {
  	 		  blob.lastModifiedDate = new Date();
  	 		  blob.name = name;
  	 		  return blob;
  	 		};
  	 		
  	 		var getFileObject = function(filePathOrUrl, cb) {
  	 		  getFileBlob(filePathOrUrl, function (blob) {
  	 		  cb(blobToFile(blob, 'test.jpg'));
  	 		  });
  	 		};
  	 		//对象转换结束
  	 		var img=$("[name=shoptypeimg]").val();
  	 		var imgList=[];
  	 		imgList.push(img)
  	 		if(imgList!=""){
  	 			$.each(imgList, function(index,item){
  	 			  getFileObject(item, function (fileObject) {
  	 			    if(fileObject!=null){
  	 			    var wuFile = new WebUploader.Lib.File(WebUploader.guid('rt_'),fileObject);
  	 			    var file = new WebUploader.File(wuFile);
  	 			  
  	 			    $tgaUpload.addFiles(file)
  	 			    }
  	 			  })
  	 			});
  	 		}
})
