package com.shensu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author YUKI
 *学习天地的控制层
 */


/**
 * 学习天地
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shensu.pojo.Franchiser;
import com.shensu.pojo.LearningWorld;
import com.shensu.pojo.LearningWorldImg;
import com.shensu.service.LearningWorldImgService;
import com.shensu.service.LearningWorldService;
import com.shensu.tool.DateTime;
import com.shensu.tool.Page;
import com.shensu.tool.UploadHelper;

@Controller
@RequestMapping("admin/learningWorld")
public class LearningWorldController {
	
	@Autowired
	LearningWorldService learningWorldService;
	@Autowired
	LearningWorldImgService learningWorldImgService;
	
	@ResponseBody
	@RequestMapping("/studyUpload")
	public String studyUpload(@RequestParam(value="file",required=false)MultipartFile files,HttpServletRequest request) throws IOException{
		
		String imgUrl=UploadHelper.upload(files, request);
		
		return imgUrl;
	}
	//分业查询学习天地正式发布列表
	/**
	 * 
	 * @param currentPage 页数
	 * @param learningWorldCreatTime 创建时间
	 * @param request 请求
	 * @param model 模型
	 * @return 
	 */
	@RequestMapping(value = "/findLearningWorldList")
	public String findLearningWorldIssueList(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			@RequestParam(value="learningWorldCreatTime",required=false)String learningWorldCreatTime,
			HttpServletRequest request, Model model){
			if("".equals(learningWorldCreatTime)){
				learningWorldCreatTime=null;
			}
			System.out.println(learningWorldCreatTime+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			model.addAttribute("learningWorldList",learningWorldService.selectByIssueCondition(currentPage, learningWorldCreatTime));
			Page<LearningWorld> learningWorldList=learningWorldService.selectByIssueCondition(currentPage, learningWorldCreatTime);
			System.out.println(learningWorldList.getLists().toString());
			System.out.println(learningWorldList.getCurrPage()+"当前页码");
			System.out.println(learningWorldList.getPageSize()+"每页条数");
			System.out.println(learningWorldList.getTotalCount()+"总记录数");
			System.out.println(learningWorldList.getTotalPage()+"总页数");
			System.out.println(learningWorldList.getLists().size());
			model.addAttribute("learningWorldCreatTime", learningWorldCreatTime);
			model.addAttribute("currentPage", currentPage);
			return "studyWorld/listFbStudyWorld";
		}
	
	//分页查询学习天地草稿箱列表
	@RequestMapping(value = "/findLearningWorldDraftList")
	public String findLearningWorldDraftList(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,
			@RequestParam(value="learningWorldCreatTime",required=false)String learningWorldCreatTime,
			HttpServletRequest request, Model model){
			if("".equals(learningWorldCreatTime)){
				learningWorldCreatTime=null;
			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			model.addAttribute("learningWorldList",learningWorldService.selectByDraftCondition(currentPage, learningWorldCreatTime));
			Page<LearningWorld> learningWorldList=learningWorldService.selectByDraftCondition(currentPage, learningWorldCreatTime);
				
			System.out.println(learningWorldList.getCurrPage()+"当前页码");
			System.out.println(learningWorldList.getPageSize()+"每页条数");
			System.out.println(learningWorldList.getTotalCount()+"总记录数");
			System.out.println(learningWorldList.getTotalPage()+"总页数");
			System.out.println(learningWorldList.getLists().size()); 
			model.addAttribute("learningWorldCreatTime", learningWorldCreatTime);
			model.addAttribute("currentPage", currentPage);
			return "studyWorld/listCgxStudyWorld";
		}
	
	//添加学习天地信息
	
	
	
	//学习天地设置上架状态
	@RequestMapping(value="/putawayLearningWorld",method=RequestMethod.GET)
	public String putawayLearningWorld(int learningWorldId){
		learningWorldService.putawayLearningWorld(learningWorldId);
		 return "redirect:findLearningWorldList";
	} 
	
	//学习天地设置下架状态
	@RequestMapping(value="/unshelveLearningWorld",method=RequestMethod.GET)
	public String unshelveLearningWorld(int learningWorldId){
		learningWorldService.unshelveLearningWorld(learningWorldId);
		 return "redirect:findLearningWorldList";
	} 
	
	//根据学习天地id删除一条信息(返回正式发布页面)
	@RequestMapping(value="/deleteLearningWorld",method=RequestMethod.GET)
	public String deleteLearningWorld(int learningWorldId,HttpServletRequest request){
		String requestUrl = request.getScheme() //当前链接使用的协议
			    +"://" + request.getServerName()//服务器地址
			    +"RegistCompanyIMG/"
			    ; 
		LearningWorld l=learningWorldService.HXLearningWorldDetails(learningWorldId);
		System.out.println(l.toString());
		List<LearningWorldImg> limgList=l.getLearningWorldImg();
		//删除本地图片
		if(limgList.size()>0){
			
			for (LearningWorldImg lImg : limgList) {
				
				
				String qzz=request.getSession().getServletContext().getRealPath("/");
				qzz= qzz.replace("Svip","RegistCompanyIMG");
			    String hz=lImg.getLearningworldimgurl().substring(requestUrl.length()+1);
				String allUrl=qzz+hz;
				File targetFile=new File(allUrl);
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
				System.out.println(lImg.toString());			
				learningWorldImgService.del(lImg.getLearningworldimgid());

			}
			
			
		}
		//删除本地视频
		if(l.getLearningworldvideourl()!=null && !("".equals(l.getLearningworldvideourl()))){
			String qzz=request.getSession().getServletContext().getRealPath("/");
			qzz= qzz.replace("Svip","RegistCompanyIMG");
		    String hz=l.getLearningworldvideourl().substring(requestUrl.length()+1);
		    String allUrl=qzz+hz;
			File targetFile=new File(allUrl);
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
		//删除本地视频
				if(l.getLearningworldvideoimgurl()!=null && !("".equals(l.getLearningworldvideoimgurl()))){
					String qzz=request.getSession().getServletContext().getRealPath("/");
					qzz= qzz.replace("Svip","RegistCompanyIMG");
				    String hz=l.getLearningworldvideoimgurl().substring(requestUrl.length()+1);
				    String allUrl=qzz+hz;
					File targetFile=new File(allUrl);
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
		learningWorldService.deleteLearningWorld(learningWorldId);
		if(l.getDraftstate()==0){
			return "redirect:findLearningWorldList";
		}
		return "redirect:findLearningWorldDraftList";
		
	} 
	
	//学习天地修改一条信息(预修改回显数据)
	@RequestMapping(value="/HXLearningWorldDetails",method=RequestMethod.GET)
	public String HXLearningWorldDetails(Integer learningWorldId,Model model){
		//查询加盟者信息
		LearningWorld learningWorld= learningWorldService.HXLearningWorldDetails(learningWorldId);
		model.addAttribute("learningWorld", learningWorld);
		List<LearningWorldImg> imgList=learningWorld.getLearningWorldImg();
		String imgStr="";
		for (LearningWorldImg l : imgList) {
			imgStr+=l.getLearningworldimgurl()+",";
		}
		System.out.println(imgStr);
		model.addAttribute("imgStr",imgStr);
		return "studyWorld/modifyStudyWorld";
	}
	
	//草稿箱设置上架状态(发布到学习天地)
	@RequestMapping(value="/putawayLearningWorldDraft",method=RequestMethod.GET)
	public String putawayLearningWorldDraft(int learningWorldId){
		learningWorldService.putawayLearningWorldDraft(learningWorldId);
		 return "redirect:findLearningWorldDraftList";
	} 
	
	//根据学习天地id删除一条信息(返回草稿页面)
	/**
	 * 
	 * @param learningWorldId
	 * @return
	 */
	@RequestMapping(value="/deleteLearningWorldDraft",method=RequestMethod.GET)
	@ResponseBody
	public String deleteLearningWorldDraft(int learningWorldId){
		learningWorldService.deleteLearningWorld(learningWorldId);
			return "redirect:findLearningWorldDraftList";
	} 
	
	//草稿箱修改一条信息
	
	//学习天地服务层
	@Autowired
	LearningWorldService lws;
	 /**
	  * 学习天地增加方法
	  * @param request
	  * @return 网页
	  */
   @RequestMapping("/updataLearningWorld")
	public String updataLearningWorld(LearningWorld leanWor,HttpServletRequest request,String studyList){
	   System.out.println(leanWor.getDraftstate()+"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
	   String requestUrl = request.getScheme() //当前链接使用的协议
			    +"://" + request.getServerName()//服务器地址
			    +"RegistCompanyIMG/"
			    ; 
	   System.out.println(leanWor.getLearningworldid()+"ididididididididiidididididiididi");
	   LearningWorld lw=learningWorldService.HXLearningWorldDetails(leanWor.getLearningworldid());
	   List<LearningWorldImg> lwList=lw.getLearningWorldImg();
	   //修改之前删除
	   for (LearningWorldImg lWorldImg : lwList) {
		    String qzz=request.getSession().getServletContext().getRealPath("/");
			qzz= qzz.replace("Svip","RegistCompanyIMG");
		    String hz=lWorldImg.getLearningworldimgurl().substring(requestUrl.length()+1);
			String allUrl=qzz+hz;
			File targetFile=new File(allUrl);
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
			learningWorldImgService.del(lWorldImg.getLearningworldimgid());
	   }
	   //删除之后添加
	   if(!("".equals(studyList))){
		   	String[] lwi=studyList.split(",");
		   	System.out.println(lwi);
		   	for (String s : lwi) {
				LearningWorldImg l=new LearningWorldImg();
				l.setLearningworldimgurl(s);
				l.setLearningworldimgcreattime(new DateTime().getDate());
				l.setLearningworldid(leanWor.getLearningworldid());
				learningWorldImgService.insert(l);
		   	}
		}
	   //删除视频图片
	   String videoimgUrl=lw.getLearningworldvideoimgurl();
	   if(!("".equals(videoimgUrl)) && videoimgUrl!=null){
	    String qzz=request.getSession().getServletContext().getRealPath("/");
		qzz= qzz.replace("Svip","RegistCompanyIMG");
	    String hz=videoimgUrl.substring(requestUrl.length()+1);
	    String allUrl=qzz+hz;
	    System.out.println(allUrl);
		File targetFile=new File(allUrl);
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
	   String vedioUrl=leanWor.getLearningworldvideourl();
	   String oldVedioUrl=lw.getLearningworldvideourl();
	   System.out.println(vedioUrl+"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
	   if(!("".equals(vedioUrl))){
		   String qzz=request.getSession().getServletContext().getRealPath("/");
			qzz= qzz.replace("Svip","RegistCompanyIMG");
		    String hz=oldVedioUrl.substring(requestUrl.length()+1);
			String allUrl=qzz+hz;
			File targetFile=new File(allUrl);
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
	   if("".equals(leanWor.getLearningworldvideourl())){
		   leanWor.setLearningworldvideourl(null);
	   }
	   learningWorldService.updataLearningWorld(leanWor);
	   
	   if(leanWor.getDraftstate()==0){
	   	   return "redirect:findLearningWorldList";
	   	}else{
	   		return "redirect:findLearningWorldDraftList";
	   	}
	 
	}
   /**
    * 查询集合的方法
    */
    
   @RequestMapping("/selectAllLearningWorld")
	public void selectAllLearningWorld(){		
	   //学习天地		
	   //谁会是的  			   
	Page<LearningWorld>  p =   lws.selectAllLearningWorld();
	System.out.println(p);
	}
   //添加学习天地添加预跳转
   @RequestMapping("/pre-add")
    public String add(){
    	
    	return "studyWorld/addStudyWorld";
    }
   //学习天地添加保存
   @RequestMapping("/addsave")
   public String addsave(LearningWorld  lw,String studyList){
	System.out.println(studyList);
	 //截取时间
	 String time=new DateTime().getDate();
	 int index= time.lastIndexOf(":");
	 String zzTime=time.substring(0,index);
	 lw.setLearningworldcreattime(zzTime);
	 lws.insertLearningWorld(lw);
	if(!("".equals(studyList))){
	   	String[] lwi=studyList.split(",");
	   	System.out.println(lwi);
	   	for (String s : lwi) {
			LearningWorldImg l=new LearningWorldImg();
			l.setLearningworldimgurl(s);
			l.setLearningworldimgcreattime(new DateTime().getDate());
			l.setLearningworldid(lw.getLearningworldid());
			learningWorldImgService.insert(l);
	   	}
	}
   	if(lw.getDraftstate()==0){
   	   return "redirect:findLearningWorldList";
   	}else{
   		return "redirect:findLearningWorldDraftList";
   	}
   }
   
   
}
