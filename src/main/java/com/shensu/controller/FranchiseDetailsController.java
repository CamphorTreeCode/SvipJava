package com.shensu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shensu.pojo.AboutMe;
import com.shensu.pojo.FranchiseDetails;
import com.shensu.service.FranchiseDetailsService;
import com.shensu.tool.DateTime;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.shensu.tool.UploadHelper;

/**
 * 
 * @author YUKI
 *  加盟的controller
 *  
 */
@Controller
@RequestMapping("admin/franchiseDetails")
public class FranchiseDetailsController {

    @Autowired
    FranchiseDetailsService franchiseDetailsService;
 /**
  * 更新加盟信息
  * @param request
  * @return 网页
  */
//   @RequestMapping("/updataFranchiseDetails")
//	public String updataFranchiseDetails(){
//	     FranchiseDetails  fd = new FranchiseDetails();
//	     fd.setFranchisedetailscontent("修改加盟的内容信息");
//	     fd.setFranchisedetailscreattime(DateTime.getDate());
//	     fd.setFranchisedetailsimg("图片的地址");	     
//	     fd.setFranchisedetailsid(1);	   
//	     int num = franchiseDetailsService.updataFranchiseDetails(fd);
//	     if(num>0){
//	    	 System.out.println("修改成功！");
//	     }
//		 return "wxIndex_message/wxIndex_message_list";
//	} 
//   
//   /**
//    * 查询加盟信息
//    * @param request
//    * @return 网页
//    * 
//    */
//    @RequestMapping("/selectFranchiseDetails")
//  	public void selectFranchiseDetails(){
//  	FranchiseDetails  fd = new FranchiseDetails();
//  	fd.setFranchisedetailsid(1);
//    System.out.println(franchiseDetailsService.selectFranchisseDetails(fd));        
//    //   return "wxIndex_message/wxIndex_message_list";
//	
//    }

   	//添加申请加盟页面信息
   	@RequestMapping(value="/addFranchiseDetails",method = RequestMethod.POST) 
	@ResponseBody
	public String addFranchiseDetails(
			FranchiseDetails fd,@RequestParam("File") MultipartFile File,HttpServletRequest request) throws IOException{
		String img = UploadHelper.upload(File, request);
		fd.setFranchisedetailsimg(img);
		fd.setFranchisedetailscreattime(new DateTime().getDate());
		franchiseDetailsService.addFranchiseDetails(fd);
		return "findfranchiseDetails";
		
	}
	
	//修改申请加盟页面信息
   @RequestMapping("/updataFranchiseDetails")
   @ResponseBody
   public String updataFranchiseDetails(
		FranchiseDetails franchiseDetails,@RequestParam("file") MultipartFile File,HttpServletRequest request) throws IOException{
	   	System.out.println("开始+++++++++++++++++++++++++++++++++++++++++++");
		String img = UploadHelper.upload(File, request);
		System.out.println("图片是+++++++++++++++++++++++++++++++++++++++++++"+img);
		franchiseDetails.setFranchisedetailsimg(img);
		franchiseDetails.setFranchisedetailscreattime(new DateTime().getDate());
		franchiseDetailsService.updataFranchiseDetails(franchiseDetails);
		System.out.println("结束+++++++++++++++++++++++++++++++++++++++++++");
	   
		return "findfranchiseDetails";
   }

   //申请加盟预添加页面跳转
   @RequestMapping(value="/pre-add") 
	public String preAdd(Model model ){
		List<FranchiseDetails> franchiserDetailsList=franchiseDetailsService.HtFindFranchiseDetails();
		if(franchiserDetailsList.size()>0){
			model.addAttribute("franchiserDetails", franchiserDetailsList.get(0));
		}
		return "franchiserDetails/franchiserDetails";
	}
   
   //申请加盟页面修改或添加
   @RequestMapping("franchiserDetailsUpload")
   @ResponseBody
	public String franchiserDetailsUpload(@RequestParam(value="file",required=false)MultipartFile files,HttpServletRequest request,
		FranchiseDetails franchiserDetails) throws IOException{
	    String requestUrl = request.getScheme() //当前链接使用的协议
			    +"://" + request.getServerName()//服务器地址
			    +"RegistCompanyIMG/"
			    ; 
	 
		String imgUrl=UploadHelper.upload(files, request);
		List<FranchiseDetails> franchiserDetailsList=franchiseDetailsService.HtFindFranchiseDetails();
		if(franchiserDetailsList.size()>0){
			String prefix=request.getSession().getServletContext().getRealPath("/").replace("Svip","RegistCompanyIMG");
			String suffix= franchiserDetailsList.get(0).getFranchisedetailsimg().substring(requestUrl.length()+1);
			String realUrl=prefix+suffix;
			File targetFile=new File(realUrl);
			
			if(targetFile.exists()){
				
				System.out.println("文件存在");
			}else{
				System.out.println("文件不存在");
			}
			
			if (targetFile.isDirectory()) { //如果是 文件夹
		         try {
		               FileUtils.deleteDirectory(targetFile);
		            } catch (IOException e) {
		               e.printStackTrace();
		            }  
		      } else if (targetFile.isFile()) {//如果是文件  
		          targetFile.delete();  
		      } 
			  
		}
		//在删除服务器上的图片后，吧数据库的数据进行先删除在增加的操作
		franchiseDetailsService.deleteAll();
		franchiserDetails.setFranchisedetailsimg(imgUrl);	
		franchiserDetails.setFranchisedetailscreattime(DateTime.getDate());
		franchiseDetailsService.addFranchiseDetails(franchiserDetails);
		
	   //这里的1代表与前段交互的ajax的状态码，1代表的是保存或者修改成功，具体交互见前段
	   return "1";
   
   }

}
