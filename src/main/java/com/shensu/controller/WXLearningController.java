package com.shensu.controller;

/**
 * 首页-学习天地
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shensu.pojo.Fabulous;
import com.shensu.pojo.LearningWorld;
import com.shensu.service.FabulousService;
import com.shensu.service.LearningWorldService;
import com.shensu.tool.DateTime;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WXLearning")
public class WXLearningController {
	
	@Autowired
	LearningWorldService lws;
	@Autowired
	FabulousService fs;
	
	//查询学习天地全部列表 分页查询
	@RequestMapping(value = "/findLearningList", method = RequestMethod.GET)
	@ResponseBody
	public void findLearningList(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		//System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(lws.findLearningList(currentPage));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//查询学习天地详情页
	@RequestMapping(value = "/findLearningDetails", method = RequestMethod.GET)
	@ResponseBody
	public void findLearningDetails(int learningWorldId, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(lws.findLearningDetails(learningWorldId));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//学习天地详情页点赞
	@RequestMapping(value = "/addLearningFabulous", method = RequestMethod.GET)
	@ResponseBody
	public void addLearningFabulous(Integer learningworldid, String openId, HttpServletResponse response) throws IOException{ 
		 response.setCharacterEncoding("utf-8");
		 JSONObject json = new JSONObject();
		 PrintWriter pw = response.getWriter();
		//System.out.println("进入主方法了");
		System.out.println("？？？？？？？？"+learningworldid);
		int num = fs.findFabulousNum(learningworldid,openId);
		System.out.println(num);
		if(num>0){
			//System.out.println("已经点过赞了");
			 json.put("Fabulous", false);					
			 pw.print(json);
		System.out.println("已经存在数据");
		}else{
			
			System.out.println("没有数据来添加数据");
			Fabulous fabulous = new Fabulous();
			//System.out.println("开始添加用户点赞信息");
			fabulous.setFabulouscreattime(new DateTime().getDate());
			fabulous.setOpenid(openId);
			fabulous.setLearningworldid(learningworldid);
			
		 	int fnum = fs.addUserOpen(fabulous);
		 	if(fnum>0){
		 		System.out.println("点赞增加成功！");
		 	}
			//System.out.println("开始添加用户点赞");
			int nums = lws.addLearningFabulous(learningworldid);
			if(nums>0){
				System.out.println("点赞数修改成功");
			}
			 json.put("Fabulous", true);					
			 pw.print(json);
			//System.out.println("程序结束添加成功");
		}
		
	}
	
	//查询所有学习天地列表id
	@RequestMapping(value = "/findLearningId", method = RequestMethod.GET)
	@ResponseBody
	public void findLearningId(HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		//System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(lws.findLearningId());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	//学习天地的转发功能
	@RequestMapping(value = "/addShare", method = RequestMethod.GET)
	@ResponseBody
	public void addShare(Integer learningworldid,Integer learningWorldForward, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("..///.."+learningworldid+learningWorldForward);
		LearningWorld learningWorld = new LearningWorld();
		learningWorld.setLearningworldid(learningworldid);
		learningWorld.setLearningWorldForward(learningWorldForward);
		response.setCharacterEncoding("utf-8");	
		JSONArray jsonArray = JSONArray.fromObject(lws.addShare(learningWorld));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
}
