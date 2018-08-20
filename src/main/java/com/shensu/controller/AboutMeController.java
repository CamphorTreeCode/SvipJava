package com.shensu.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.shensu.pojo.AboutMe;
import com.shensu.service.AboutMeService;
import com.shensu.tool.DateTime; 
import com.shensu.tool.UploadHelper;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("admin/about")
@Api(description = "关于我们的信息接口", value = "AboutMeController")
public class AboutMeController {

	@Autowired
	private AboutMeService aboutMeService;
	
	        //关于我们修改活添加预跳转
			@RequestMapping(value="/pre-add") 
			@ApiOperation(value="preAdd",notes="关于我们修改活添加预跳转",httpMethod = "GET",produces = "text/plain;charset=UTF8")
			public String preAdd(Model model ){
				List<AboutMe> aboutMe=aboutMeService.findAboutMeDetails();
				if(aboutMe.size()>0){
					model.addAttribute("aboutMe", aboutMe.get(0));
				}
				return "aboutMe/aboutMe";
			}
			//关于我们修改或添加保存
			@RequestMapping("aboutMeUpload")
			@ResponseBody	
			@ApiOperation(value="aboutMeUpload",notes="关于我们修改或添加保存",produces = "text/plain;charset=UTF8")			
			public String aboutMeUpload( @ApiParam(name="files",value = "上传的文件(文件自行上传)", required = true)@RequestParam(value="file",required=false)MultipartFile files,HttpServletRequest request,
					@RequestBody @ApiParam(name = "aboutMe",value = "关于我们的内容", required = true)AboutMe aboutMe) throws IOException{
				String requestUrl = request.getScheme() //当前链接使用的协议
					    +"://" + request.getServerName()//服务器地址
					    +"RegistCompanyIMG/"
					    ; 
				String imgUrl=UploadHelper.upload(files, request);
				
				List<AboutMe> aboutList= aboutMeService.findAboutMeDetails();
				if(aboutList.size()!=0){
					
					AboutMe abm=aboutList.get(0);
					String qzz=request.getSession().getServletContext().getRealPath("/");
					qzz= qzz.replace("Svip","RegistCompanyIMG");
				    String hz=abm.getAboutmeimg().substring(requestUrl.length()+1);
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
				//在删除服务器上的图片后，把数据库的数据进行先删除在增加的操作
				aboutMeService.deleteByPrimaryKey();
				aboutMe.setAboutmeimg(imgUrl);	
				aboutMe.setAboutmecreattime(DateTime.getDate());
				aboutMeService.addAboutMe(aboutMe);
				
				return "1";
			    
					
			}
	 
	//修改关于我们的内容(网页端)
	/*@RequestMapping(value="/modifyAboutMe",method=RequestMethod.POST)
	public String modifyAboutMe(AboutMe aboutMe,HttpServletRequest request) throws IOException{
			List<AboutMe> aboutList= aboutMeService.findAboutMeDetails();
			if(aboutList.size()!=0){
				
				AboutMe abm=aboutList.get(0);
				System.out.println(abm+"旧对象jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
                String qz="http://localhost/RegistCompanyIMG/";
				
			    String hz=abm.getAboutmeimg().substring(qz.length());
			    System.out.println(request.getSession().getServletContext().getRealPath("/")+"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
				System.out.println(hz+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
				String allUrl="F://apache-tomcat-9.0.1/webapps/RegistCompanyIMG/"+hz;
				System.out.println(allUrl+"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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
			System.out.println(aboutMe.toString());
			//如果网页端本来没有信息，则吧修改当成增加信息来操作并把数据录入数据库,如果原本有数据则吧原本数据删除后再次增加
			aboutMeService.deleteByPrimaryKey(123);
				
			aboutMe.setAboutmecreattime(DateTime.getDate());
			aboutMeService.addAboutMe(aboutMe);
			
			return "index";
			}	*/
	//增加关于我们的内容
	 @RequestMapping(value="/addAboutMe",method = RequestMethod.POST) 
	 @ResponseBody
	 public String addAboutMe(
			 AboutMe aboutMe,@RequestParam("File") MultipartFile File,HttpServletRequest request) throws IOException{
		String img = UploadHelper.upload(File, request);
		aboutMe.setAboutmeimg(img);
		aboutMe.setAboutmecreattime(new DateTime().getDate());
		aboutMeService.addAboutMe(aboutMe);
		return "findAboutMeDetails";
		

	
			//以下方法暂时没用
			/*//增加关于我们的内容
			 @RequestMapping(value="/addAboutMe",method = RequestMethod.POST) 
			 public String addAboutMe( AboutMe aboutMe) throws IOException{
				
				aboutMe.setAboutmecreattime(new DateTime().getDate());
				aboutMeService.addAboutMe(aboutMe);
				return "index";
			}
			
			 //预修改页面(网页端)
			 @RequestMapping(value = "select", method = RequestMethod.GET)
				public String selectAll(Model model) throws IOException {
				List<AboutMe> aboutMe=aboutMeService.findAboutMeDetails();
				model.addAttribute("aboutMe", aboutMe);			
					return "aboutMe/aboutMeLook";
				}*/
	 	}
	 }