package com.shensu.controller;

 /**
 * 用户
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.shensu.pojo.User;
import com.shensu.service.UserService;
import com.shensu.tool.DateTime;
import com.shensu.tool.GetOpenId;
import com.shensu.tool.IsNomber;


@Controller
@RequestMapping("/WXUser")
public class UserController {
	
	@Autowired
	UserService us;
	 
	//增加用户的信息
	@RequestMapping(value="/addUser",method=RequestMethod.POST)	
	public void addUser(User userInfo,HttpServletResponse response) throws IOException{			
		userInfo.setRegisterdate(DateTime.getDate());
		System.out.println(userInfo);		
		userInfo.setNickname(IsNomber.filterEmoji(userInfo.getNickname()));
		int selectNum = us.selectUser(userInfo.getOpenid());
		if(selectNum>0){
			System.out.println("用户已经存在了");
			return;
		}
		int num=us.insetUser(userInfo);
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		if(num>0){
			pw.print("增加用户成功");
		}else{
			pw.print("增加用户失败");
		}
	}
	
	
	//获取用户的openid
	@RequestMapping(value="/getOpenid",method=RequestMethod.GET)
	public void getOpenid(String jscode,HttpServletResponse response) {
	try {
		System.out.println(jscode);
        String openId = GetOpenId.getOpenid(jscode);
		response.setCharacterEncoding("utf-8");
		JSONObject json = new JSONObject();					
		json.put("openId", openId);	
		response.getWriter().append(json.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}
}
