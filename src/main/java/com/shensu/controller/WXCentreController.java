package com.shensu.controller;

/**
 * 会员中心、添加申请加盟
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shensu.pojo.AboutMe;
import com.shensu.pojo.FranchiseDetails;
import com.shensu.pojo.Franchiser;
import com.shensu.service.AboutMeService;
import com.shensu.service.FranchiseDetailsService;
import com.shensu.service.FranchiserService;
import com.shensu.service.UserService;
import com.shensu.tool.DateTime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



@Controller
@RequestMapping("/WXCentre")
public class WXCentreController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	FranchiserService franchiserService;
	
	@Autowired
	AboutMeService aboutMeService;
	
	@Autowired
	FranchiseDetailsService franchiseDetailsService;
	
	//会员中心获取用户信息
	@RequestMapping(value = "/findVIPCentre", method = RequestMethod.GET)
	public void findVIPCentre(String openid, HttpServletResponse response) throws IOException{
		//System.out.println("进入主方法了");
		System.out.println("会员中心获取用户信息");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(userService.findVIPCentre(openid));

		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//添加加盟者申请信息
	@RequestMapping(value="/addFranchiserMsg",method = RequestMethod.GET) 
	@ResponseBody
	public void addFranchiserMsg(Franchiser franchiser,HttpServletResponse response) throws IOException{
			franchiser.setFranchisecreattime(new DateTime().getDate());
			 response.setCharacterEncoding("utf-8");
			 JSONObject json = new JSONObject();
			 PrintWriter pw = response.getWriter();
			Franchiser fc = franchiserService.findOpenidState(franchiser.getOpenid());

			if(fc!=null){
				//有数据的话进行修改属性
				franchiser.setFranchiserid(fc.getFranchiserid());
				franchiser.setReadstate(0);
				franchiser.setFranchisestate(0);
				int updatenum =franchiserService.updateFranchiser(franchiser);
				if(updatenum>0){
					 System.out.println("修改成功");					
					 json.put("franchiseState", true);	
					 pw.print(json);
				}else{
					
					 System.out.println("修改失败");			
					 json.put("franchiseState", false);					
					 pw.print(json);
				 }
			}else{
				//没有数据进行添加
				 int num =  franchiserService.addFranchiserMsg(franchiser);
				 if(num>0){
					
					 System.out.println("增加成功");					
					 json.put("franchiseState", true);	
					 pw.print(json);
				 }else{
				
					 System.out.println("增加失败");			
					 json.put("franchiseState", false);					
					 pw.print(json);
				 }
			}
			
		
			
	}
	
	//查询申请加盟者申请状态
	@RequestMapping(value = "/findFranchiserState", method = RequestMethod.GET)
	public void findFranchiserState(int franchiserId, HttpServletResponse response) throws IOException{
		System.out.println("进入主方法了");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(franchiserService.findFranchiserState(franchiserId));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//查询关于我们的内容
	@RequestMapping(value="/findAboutMeDetails")
	@ResponseBody
    public void findAboutMeDetails(HttpServletResponse response) throws IOException{
		System.out.println("进入主方法了");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(aboutMeService.findAboutMeDetails());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	} 
	
	 //查询申请加盟页面信息
   	@RequestMapping(value="/findFranchiseDetails",method=RequestMethod.GET)
	@ResponseBody
    public void findFranchiseDetails(FranchiseDetails franchiseDetails, HttpServletResponse response) throws IOException{
   		System.out.println("进入主方法了");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(franchiseDetailsService.findFranchiseDetails(franchiseDetails));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	} 
   	//根据openid查询申请状态
	@RequestMapping(value = "/findOpenidState", method = RequestMethod.GET)
	public void findOpenidState(String openid, HttpServletResponse response) throws IOException{
		System.out.println("进入主方法了"+openid);
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(franchiserService.findOpenidState(openid));
		System.out.println("判断有没有:"+franchiserService.findOpenidState(openid)!=null);
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	//查询pid方法
	@RequestMapping(value = "/findUserPId", method = RequestMethod.GET)
	public void findUserPId(String openid, HttpServletResponse response) throws IOException{
		System.out.println("进入主方法了"+openid);
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		System.out.println("判断有没有:"+franchiserService.findUserPId(openid));
		JSONArray jsonArray = JSONArray.fromObject(franchiserService.findUserPId(openid));		
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
}
