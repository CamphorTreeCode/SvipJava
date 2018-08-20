package com.shensu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shensu.pojo.MyCard;
import com.shensu.service.MyCardService;
import com.shensu.tool.taobaoke.GetTKL;

import net.sf.json.JSONArray;

/**
 * 
 * @author YUKI
 * 我的卡卷中心
 */

@Controller
@RequestMapping("/WXMyCard")
public class WXMyCardController {
		@Autowired
		MyCardService myCardService;	
	    //查询卡卷中心的分页
		@RequestMapping(value="/selectMyCard",method = RequestMethod.GET) 
		@ResponseBody
		public void selectMyCardPage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,String openId, HttpServletResponse response) throws IOException{
		  System.out.println(currentPage);
		  System.out.println(openId);
		  response.setCharacterEncoding("utf-8");
		  MyCard mc = new MyCard();
		  mc.setOpenid(openId);		
		 JSONArray jsonArray = JSONArray.fromObject(myCardService.select(currentPage,mc));
		 PrintWriter pw = response.getWriter();
		 pw.print(jsonArray);
		}
	
}
