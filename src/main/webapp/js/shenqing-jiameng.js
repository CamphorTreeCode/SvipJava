$(function(){
	 //上传图片
        var $tgaUpload = $('#goodsUpload').diyUpload({
            url:'./franchiserDetailsUpload',
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
            	franchisedetailscontent:'',
            }
        });
        //上传按钮绑定点击事件
       $('.save').on('click',function(){
       	 
    	 var item = $('#item').val();
       	 if(item==''){
       	 	alert('请填写项目介绍')
       	 	return false;
       	 }
       	 
       var franchisedetailscontent=$("[name=franchisedetailscontent]").val();
       //插件上传
       $tgaUpload.options.formData.franchisedetailscontent=franchisedetailscontent
       $tgaUpload.upload();
     //每次上传完成回掉
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
  	 		
  	 		
  	 		
  	 		var img=$("[name=franchisedetailsimg]").val();
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
