package com.shensu.controller;

/**
 * 账号管理
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.shensu.pojo.Data;
import com.shensu.pojo.Franchiser;
import com.shensu.pojo.FranchiserUser;
import com.shensu.pojo.Template2;
import com.shensu.pojo.keyword;
import com.shensu.service.FranchiserService;
import com.shensu.service.FranchiserUserService;
import com.shensu.service.MyCardService;
import com.shensu.tool.DateTime;
import com.shensu.tool.GetOpenId;
import com.shensu.tool.HttpRequestor;
import com.shensu.tool.Page;
import com.shensu.tool.UpdataName;
import com.shensu.tool.UrlHelper;


@Controller
@RequestMapping("admin/franchiserUser")
public class FranchiserUserController {
	
	@Autowired
	private FranchiserUserService franchiserUserService;
	
	@Autowired
	private FranchiserService franchiserService;
	
	@Autowired
	private MyCardService MyCardService;
	
	//跳转添加账号页面 
	/*@RequestMapping(value="/addFranchiserUserAccounts")
	public String addFranchiserUserAccounts(){
		
		return "franchiserUser/addFranchiserUserAccounts";
	}*/
		
	//添加加盟者数据
	 @RequestMapping(value="/addFranchiserUser",method = RequestMethod.GET) 
	 @ResponseBody
	 public String addFranchiserUser(FranchiserUser franchiserUser, String openId) throws IOException{
		 
		 System.out.println("进来了***********************************************************************************");
//		 int openId = franchiserService.findFranchiserOpenId(franchiserId);
//		 int num = franchiserUserService.findUser(openId);
//		 if(num>0){
//			 return "加盟者账号已经存在" ;
//		 }
//       2.取出数据 添加数据
		 System.out.println(openId);
		 franchiserUser.setOpenid(openId); 
	
		 franchiserUser.setFranchiserusercreattime(new DateTime().getDate());

		//3.存入数据库
		  franchiserUserService.insertFranchiserUser(franchiserUser);
		  return "findAllFranchiserUserDetails";
     }
		
	 
	 //网页端添加加盟者数据
	 @RequestMapping(value="/HtAddFranchiserUser",method = RequestMethod.POST) 
	 public String HtAddFranchiserUser(FranchiserUser franchiserUser, HttpServletRequest request) throws Exception{
		 request.setAttribute("openId",franchiserUser.getOpenid());
		 franchiserUser.setFranchiserusercreattime(new DateTime().getDate());
		 franchiserUserService.insertFranchiserUser(franchiserUser);
		 //修改加盟状态为账号已添加
		 String openId = franchiserUser.getOpenid();
		 franchiserService.updateFranchiserState(openId);
		 MyCardService.deleteMyCardByOpenidId(openId);
		 
		 System.out.println("*********************************************************************************"); 
		 Franchiser  franchiser = franchiserService.findByOpenid(openId);
		 
		 HttpRequestor httpRequestor = new HttpRequestor();
			String result=httpRequestor.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + UpdataName.appid
					+ "&secret=" + UpdataName.secret + "");
			JSONObject access = JSONObject.parseObject(result);
			

			
			Template2 template = new Template2();
			
			template.setTouser( franchiser.getOpenid() );
			
			template.setTemplate_id(UpdataName.template2);		
		    
			template.setPage("pages/index/index");
			
			template.setForm_id( franchiser.getFormId() );
			
 			template.setData(new Data(new keyword(franchiser.getFranchisecreattime()),
 					                                new keyword(franchiser.getFranchisename()),
 					                                new keyword("您的审核已经通过"), 
 					                                new keyword("账号："+franchiserUser.getFranchiseruseraccounts()+"   密码："+franchiserUser.getFranchiseruserpassword()), 
 					                                new keyword(new DateTime().getDate())));
			
			String result2 = UrlHelper.postResult("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access.get("access_token")+"", template);
			System.out.println(result2);
		 
		 
		 System.out.println("*********************************************************************************"); 
		 
		 return "redirect:findFranchiserUserList"; 
	 }
	 
	//分页查询
	// @ResponseBody
	@RequestMapping("/findFranchiserUserList")
	public String list(@RequestParam(value="currentPage",defaultValue="1",required=false)Integer currentPage,
			@RequestParam(value="franchiserUserUserName",required=false)String franchiserUserUserName,
			@RequestParam(value="franchiserUserAccounts",required=false)String franchiserUserAccounts,
			@RequestParam(value="franchiserUserPid",required=false)String franchiserUserPid,
			HttpServletRequest request,
			Model model	
			){
		 	if("".equals(franchiserUserUserName)){
		 		franchiserUserUserName=null;
		 	}
		 	if("".equals(franchiserUserAccounts)){
		 		franchiserUserAccounts=null;
		 	}
		 	if("".equals(franchiserUserPid)){
		 		franchiserUserPid=null;
		 	}
			model.addAttribute("franchiserUserList",franchiserUserService.selectByCondition(
					currentPage, franchiserUserUserName, franchiserUserAccounts, franchiserUserPid));
			Page<FranchiserUser> franchiserUserList=franchiserUserService.selectByCondition(
					currentPage,franchiserUserUserName, franchiserUserAccounts, franchiserUserPid);
			System.out.println(franchiserUserList.getCurrPage()+"当前页码");
			System.out.println(franchiserUserList.getPageSize()+"每页条数");
			System.out.println(franchiserUserList.getTotalCount()+"总记录数");
			System.out.println(franchiserUserList.getTotalPage()+"总页数");
//			System.out.println(franchiserUserList.getLists().size());
//			request.setAttribute("FranchiserUser", franchiserUserList.getLists());
			model.addAttribute("franchiserUserUserName", franchiserUserUserName);
			model.addAttribute("franchiserUserAccounts", franchiserUserAccounts);
			model.addAttribute("franchiserUserPid", franchiserUserPid);
			model.addAttribute("currentPage", currentPage);
			return "franchiserUser/listFranchiserUser";
	}
	
//	//跳转到修改加盟者信息页面
//	@RequestMapping(value="/modifyFranchiserUserPage",method=RequestMethod.GET)
//	@ResponseBody
//	public String update(FranchiserUser franchiserUser){
//		return "modifyFranchiserUser";
//		
//	}
	
	//跳转到修改加盟者信息页面并回显数据
	@RequestMapping(value="/pre-editFranchiserUser",method=RequestMethod.GET)
	public String  preUpdate(int franchiseruserId, Model model, Integer currentPage, String franchiserUserUserName){
		FranchiserUser franchiserUser=franchiserUserService.findByFranchiserUser(franchiseruserId);
		model.addAttribute("franchiserUser", franchiserUser);
		model.addAttribute("franchiserUserUserName", franchiserUserUserName);
		model.addAttribute("currentPage", currentPage);
		return "franchiserUser/editFranchiser";
	}
	
	//修改加盟者信息
	 @RequestMapping(value="/modifyFranchiserUser",method = RequestMethod.POST) 
	// @ResponseBody
	 public String updateUser(FranchiserUser franchiserUser, Model model, Integer currentPage, String franchiserUserUserName) throws IOException{
		 	System.out.println("修改成功");
		 	franchiserUser.setFranchiserusercreattime(new DateTime().getDate());
			 franchiserUserService.modifyFranchiserUser(franchiserUser);
			 model.addAttribute("franchiserUserUserName", franchiserUserUserName);
			 model.addAttribute("currentPage", currentPage);
			 return "redirect:findFranchiserUserList";
			
	 }
	 
	 
		 
	//删除加盟者信息
	 @RequestMapping("/deleteFranchiserUser")
	    public String deleteFranchiserUser(Integer franchiserUserId){
	    	 MyCardService.deleteMyCardByOpenidId(franchiserUserService.findByFranchiserUser(franchiserUserId).getOpenid());
	    	 franchiserService.deleteFranchiserByOpenId(franchiserUserService.findByFranchiserUser(franchiserUserId).getOpenid());
	    	 franchiserUserService.deleteFranchiserUser(franchiserUserId);
	    	 
	    	 return "redirect:findFranchiserUserList";
	    }
	 
	//查询加盟者账号全部列表
	@RequestMapping(value="/findAllFranchiserUserDetails",method=RequestMethod.GET)
	@ResponseBody
	public List<FranchiserUser> findAllFranchiserDetails(FranchiserUser franchiserUser){
		return franchiserUserService.findAllFranchiserUserDetails(franchiserUser);	
	} 
	
	//添加账号唯一性校验
	@ResponseBody
	@RequestMapping("zhanghaoXY")
	public String zhanghaoXY(FranchiserUser franchiserUser,String xiaoyan){
		System.out.println(xiaoyan+"*************************");
		List<FranchiserUser> list=franchiserUserService.findAllFranchiserUserDetails(franchiserUser);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getFranchiseruseraccounts().equals(xiaoyan)){
					return  "0";
				}				
			}	
	     return "1";
	}
	
	//添加用户名唯一性校验
		@ResponseBody
		@RequestMapping("yonghumingXY")
		public String yonghumingXY(FranchiserUser franchiserUser,String xiaoyan){
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+xiaoyan+"*************************");
			List<FranchiserUser> list=franchiserUserService.findAllFranchiserUserDetails(franchiserUser);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+list.size());
			for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getFranchiseruserusername().equals(xiaoyan)){
						return  "0";
					}				
				}	
		     return "1";
		}
		
		//添加PID唯一性校验
		@ResponseBody
		@RequestMapping("PIDXY")
		public String PIDXY(FranchiserUser franchiserUser,String xiaoyan){
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+xiaoyan+"*************************");
			List<FranchiserUser> list=franchiserUserService.findAllFranchiserUserDetails(franchiserUser);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+list.size());
			for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getFranchiseruserpid().equals(xiaoyan)){
						return  "0";
					}				
				}	
		     return "1";
		}
	
		//编辑账号唯一性校验
		@ResponseBody
		@RequestMapping("EditAccountXY")
		public String EditAccountXY(String xiaoyan, Integer franchiseruserid){
			System.out.println(xiaoyan+"*************************");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+franchiseruserid);
			List<FranchiserUser> list=franchiserUserService.editFranchiserUser(franchiseruserid);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getFranchiseruseraccounts().equals(xiaoyan)){
						return  "0";
					}				
				}	
		     return "1";
		}
		
		//编辑用户名唯一性校验
		@ResponseBody
		@RequestMapping("EditUserNameXY")
		public String EditUserNameXY(String xiaoyan, Integer franchiseruserid){
			System.out.println(xiaoyan+"*************************");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+franchiseruserid);
			List<FranchiserUser> list=franchiserUserService.editFranchiserUser(franchiseruserid);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getFranchiseruserusername().equals(xiaoyan)){
						return  "0";
					}				
				}	
		     return "1";
		}
		
		//编辑PID唯一性校验
		@ResponseBody
		@RequestMapping("EditPIDXY")
		public String EditPIDXY(String xiaoyan, Integer franchiseruserid){
			System.out.println(xiaoyan+"*************************");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+franchiseruserid);
			List<FranchiserUser> list=franchiserUserService.editFranchiserUser(franchiseruserid);
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
					if(list.get(i).getFranchiseruserpid().equals(xiaoyan)){
						return  "0";
					}				
				}	
		     return "1";
		}
	   
		
		//判断当前用户是否已经加盟
		@ResponseBody
		@RequestMapping("judgeFranchiser")
		public int yesOrNoJoin(String openid){
			System.out.println("*************************************************************");
			System.out.println(openid);
			System.out.println("*************************************************************");
			return franchiserUserService.findUser(openid);
			
		}
}
