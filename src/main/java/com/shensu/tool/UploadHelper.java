package com.shensu.tool;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class UploadHelper {
	private static   String UPLOAD_DIRECTORY = new DateTime().getDay();  
	
	public static String upload(@RequestParam("file")MultipartFile file,HttpServletRequest request)throws IOException{
		String imgpath="";
		String mypath = request.getSession().getServletContext().getRealPath("/");

		System.out.println(mypath);
		  //原始名称
        String myappPath = mypath.replace("\\"+UpdataName.projectName,"\\RegistCompanyIMG");
        // 如果目录不存在则创建
        File uploadDir = new File(myappPath);
        if (!uploadDir.exists()) {
        boolean  t =   uploadDir.mkdir();
        System.out.println("OK"+t+myappPath);
        }   
        String myimgpath = myappPath+UPLOAD_DIRECTORY+"\\";
        File fip = new File(myimgpath);
       //	文件没有创建	        
        if (!fip.exists()) {
        	  boolean  t =   fip.mkdir();
        	    System.out.println("OK"+t+myimgpath);
        	} 
        //上传图片的名称		        
        System.out.println(myimgpath);
        String originalFilename = file.getOriginalFilename(); 
        System.out.println(">>>>>>>>>>>"+originalFilename);
 
        //上传图片  
        if(file!=null && originalFilename!=null && originalFilename.length()>0){          
        //存储图片的物理路径  
   
        //新的图片名称  
       String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));  
        //新图片  
        File newFile = new File(myimgpath+newFileName);  
        imgpath=myimgpath+newFileName;
        System.out.println(imgpath);
        //将内存中的数据写入磁盘  
        file.transferTo(newFile);    
        //将新图片名称写到itemsCustom中  
           
        //注意路径
        String mypath1 = mypath.replace("\\"+UpdataName.projectName,"");		        		        
        imgpath=imgpath.replace(mypath1,UpdataName.urlName+"/");
        System.out.println(">>>>"+imgpath);	
        imgpath = imgpath.replaceAll("\\\\","/");
        }      
		return imgpath;
	
        
	}
    //	    图片压缩下载工具
  public static void downImg(String name,String imgurl, ZipOutputStream zos) throws IOException{
  	
      URL url = new URL(imgurl);
      zos.putNextEntry(new ZipEntry(name+".jpg"));
      //FileInputStream fis = new FileInputStream(new File(files[i]));  
      InputStream fis = url.openConnection().getInputStream();   
      byte[] buffer = new byte[1024];     
      int r = 0;     
      while ((r = fis.read(buffer)) != -1) {     
          zos.write(buffer, 0, r);     
      }     
      fis.close();
    
  }
	

}
