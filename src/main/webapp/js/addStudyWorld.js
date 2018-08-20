$(function(){
		var fileMd5;
		    //上传大文件前注册
		    WebUploader.Uploader.register({
			         'before-send-file': 'beforeSendFile'
			         , "before-send": "beforeSend"
			         , "after-send-file": "afterSendFile"},
			         //上传之前
			         {
			               beforeSendFile:function(file){
			                console.info(file);  
				            //秒传验证  
				            var deferred = WebUploader.Deferred();  
				            console.info(deferred);
				            var start = new Date().getTime();  
			                console.info(start);
			                 (new WebUploader.Uploader()).md5File(file,0,10*1024*1024)  
			                    .progress(function(percentage){  
			                       /*  $('#item1').find("p.state").text("正在读取文件信息...");   */
			                       console.info(percentage);
			                    })  
			                    .then(function(val){  
			                        fileMd5=val;  
			                       /*  $('#item1').find("p.state").text("成功获取文件信息...");   */
			                        //获取文件信息后进入下一步  
			                        console.info(fileMd5);
			                        deferred.resolve();  
			                    });  
			                return deferred.promise();  
			               }
			         
			         },
			         
			         //单片上传之前
			         {
			             beforeSend:function(block){
			             
			                console.log("beforeSend");  
				            var deferred = WebUploader.Deferred();    
				                
				            $.ajax({    
				                type:"POST",    
				                url:"admin/learningWorld/studyUpload",    
				                data:{    
				                    //文件唯一标记    
				                    fileMd5:fileMd5,    
				                    //当前分块下标    
				                    chunk:block.chunk,    
				                    //当前分块大小    
				                    chunkSize:block.end-block.start    
				                },    
				                dataType:"json",    
				                success:function(response){    
				                    if(response.ifExist){   
				                        console.log("分片存在:"+block.chunk)  
				                        //分块存在，跳过    
				                        deferred.reject();    
				                    }else{  
				                        console.log("分片不存在:"+block.chunk)  
				                        //分块不存在或不完整，重新发送该分块内容    
				                        deferred.resolve();    
				                    }    
				                }    
				            });    
				                
				            this.owner.options.formData.fileMd5 = fileMd5;  
				            console.log("继续执行")  
				            //deferred.resolve();    
				            return deferred.promise();    
							             }
			         
			         },
			         
			         
			         //全部上传完成
			         {
			             afterSendFile:function(block){
			             
			                alert("456")
			             }
			         
			         }
			         
			         )
			         
			//选择上传的资源类型
			var $tgaUpload="";
			var $tgaUpload1="";
			var $tgaUpload2="";
			var uploadType=0;
			$(document).on('click','.phone',function(){
			uploadType=1
			$(".diyUploadHover").remove();
			    $(".superbig:eq(0)").css("display","block").siblings(".superbig").css("display","none")
			    $tgaUpload = $('#goodsUpload').diyUpload({
				url: 'admin/learningWorld/studyUpload',
				success: function(data) {},
				error: function(err) {},
				buttonText: '',
				accept: {
					title: "Images",
					extensions: 'gif,jpg,jpeg,bmp,png'
				},
				threads : 1,
				thumb: {
					width: 120,
					height: 90,
					quality: 100,
					allowMagnify: true,
					crop: true,
					type: "image/jpeg"
				}
			});
			/* $tgaUpload.reset(); */
			return false;
			})
			
			 
			$(".video").on('click',function(){
			uploadType=2;
			$(".diyUploadHover").remove();
			       $(".superbig:eq(1)").css("display","block").siblings(".superbig").css("display","none");
			       
			    $tgaUpload1= $('#badsUpload').diyUpload({
				url: 'admin/learningWorld/studyUpload',
				success: function(data) {},
				error: function(err) {},
				buttonText: '',
				accept: {
					title: "image/jpeg",
					extensions: 'ogg,mp4,flv,jpeg,bmp,doc,docx,rar,pdf,avi'
				},
				threads : 1,
				thumb: {
					width: 120,
					height: 90,
					quality: 100,
					allowMagnify: true,
					crop: true,
					type: "video"
				},
				fileNumLimit:1,
			});
			    
			    $tgaUpload2= $('#badsUploadimg').diyUpload({
					url: 'admin/learningWorld/studyUpload',
					success: function(data) {},
					error: function(err) {},
					buttonText: '',
					accept: {
						title: "image/jpeg",
						extensions: 'gif,jpg,jpeg,bmp,png'
					},
					threads : 1,
					thumb: {
						width: 120,
						height: 90,
						quality: 100,
						allowMagnify: true,
						crop: true,
						type: "image/jpeg"
					},
					fileNumLimit:1,
				});
			/* $tgaUpload1.reset(); */
			 return false;
			})
			
			
			
			         
			
			
			
			$(".btn").click(function(){
				 $("[name=draftstate]").val(0);
				 $("[name=learningworldstate]").val(1);
			     var studyImgList="";
			     //图片上传
			     if(uploadType==1){
				    $tgaUpload.upload();
				    //单个文件上传完成触发
				    $tgaUpload.on("uploadSuccess",function(file,respone){
			   	       studyImgList+=respone._raw+","
	      	   
	        	    })
	                 //全部上传完成触发事件
			        $tgaUpload.on("uploadFinished",function(){
	                    $("[name=studyList]").val(studyImgList)
	                    console.info(studyImgList)
	                    $("form").submit();
	                        	     
				     })
			    }
			    //视频上传
			   if(uploadType==2){
				   var f1=false;
				    var f2=false;
				    $tgaUpload1.upload();
				    //单个文件上传完成触发
				    $tgaUpload1.on("uploadSuccess",function(file,respone){
			   	       console.log(respone)
			   	       $("[name=learningworldvideourl]").val(respone._raw)
	      	   
	        	    })
	                 //全部上传完成触发事件
			        $tgaUpload1.on("uploadFinished",function(){
			        	f1=true;
	                     if(f1 && f2){
	                    	$("form").submit();   
	                     }
				     })
				     
				     $tgaUpload2.upload();
				    //单个文件上传完成触发
				    $tgaUpload2.on("uploadSuccess",function(file,respone){
				    	 $("[name=learningworldvideoimgurl]").val(respone._raw)
	        	    })
	                 //全部上传完成触发事件
			        $tgaUpload1.on("uploadFinished",function(){
			        	f2=true;
			        	 if(f1 && f2){
			        		 $("form").submit();        
			        	 }
	                   	     
				     })
			    }
			    
			    return false;
			})
			
			
			$(".cgxbtn").click(function(){
				 $("[name=draftstate]").val(1);
				 $("[name=learningworldstate]").val(0);
			     var studyImgList="";
			     //图片上传
			     if(uploadType==1){
				    $tgaUpload.upload();
				    //单个文件上传完成触发
				    $tgaUpload.on("uploadSuccess",function(file,respone){
			   	       studyImgList+=respone._raw+","
	      	   
	        	    })
	                 //全部上传完成触发事件
			        $tgaUpload.on("uploadFinished",function(){
	                    $("[name=studyList]").val(studyImgList)
	                    console.info(studyImgList)
	                    $("form").submit();
	                        	     
				     })
			    }
			    //视频上传
			   if(uploadType==2){
				    var f1=false;
				    var f2=false;
				    $tgaUpload1.upload();
				    //单个文件上传完成触发
				    $tgaUpload1.on("uploadSuccess",function(file,respone){
			   	       console.log(respone)
			   	       $("[name=learningworldvideourl]").val(respone._raw)
	      	   
	        	    })
	                 //全部上传完成触发事件
			        $tgaUpload1.on("uploadFinished",function(){
			        	f1=true;
	                     if(f1 && f2){
	                    	$("form").submit();   
	                     }
				     })
				     
				     $tgaUpload2.upload();
				    //单个文件上传完成触发
				    $tgaUpload2.on("uploadSuccess",function(file,respone){
				    	 $("[name=learningworldvideoimgurl]").val(respone._raw)
	        	    })
	                 //全部上传完成触发事件
			        $tgaUpload1.on("uploadFinished",function(){
			        	f2=true;
			        	 if(f1 && f2){
			        		 $("form").submit();        
			        	 }
	                   	     
				     })
			    }
			    
			    return false;
			})
			
			
			
			
			
			
			$(".qxbtn").click(function(){
				
				window.location.href="admin/learningWorld/findLearningWorldList";
				return false;
			})
			
		})