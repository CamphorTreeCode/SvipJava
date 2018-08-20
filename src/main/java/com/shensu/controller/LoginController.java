package com.shensu.controller;

/**
 * 超级VIP后台登录页
 */
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shensu.pojo.Admin;
import com.shensu.service.LoginService;
import com.shensu.service.impl.LoginServiceImpl;
import com.shensu.tool.DateTime;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
 
	// 注销登录跳转
	@RequestMapping(value = "tologin", method = RequestMethod.GET)
	public String login(HttpServletRequest request) throws IOException {
		System.out.println("tologin");
		request.getSession().setAttribute("user_name", null);
		request.getSession().setAttribute("user", null);
		return "login";
	}

	// 登录
	@ResponseBody
	@RequestMapping("login")
	public String userLogin(String user_name, String user_password, String check, HttpServletRequest request,
			HttpServletResponse response) {

		request.getSession().removeAttribute("error");
		Admin adm = new Admin();
		adm.setAdminname(user_name);
		adm.setAdminpassword(user_password);
		Admin user = loginService.selectAdmin(adm);
		if (user == null) {
			 request.getSession().setAttribute("error", "用户名或密码错误");
			return "login";
		} else {
			Cookie unCookie = new Cookie("user_name", user_name);
			unCookie.setPath("/");
			unCookie.setMaxAge(0);
			Cookie pwCookie = new Cookie("user_password", user_password);
			pwCookie.setPath("/");
			pwCookie.setMaxAge(0);
			response.addCookie(unCookie);
			response.addCookie(pwCookie);
			request.getSession().setAttribute("user_name", user.getAdminname());
			request.getSession().setAttribute("user", user);
			return "index";

		}
	}

	@RequestMapping(value = "pauduan", method = RequestMethod.POST)
	@ResponseBody
	public String panduan(HttpServletRequest request, Admin adm) {
		Admin a = loginService.selectAdmin(adm);
		if (a != null) {
			return "1";
		} else {
			return "0";
		}
	}
	
	//预跳转修改页面
	@RequestMapping(value="/pre-update",method=RequestMethod.GET)
	public String update(HttpServletRequest request){
		
		return "admin/update";
	}
	
	//跳转修改页面
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatesave(HttpServletRequest request,Admin adm){
		System.out.println("进入方法");
		System.out.println(adm);
		System.out.println(adm.getAdminid());
		//adm.setAdmincreattime(new DateTime().getDate());
		loginService.updateAdmin(adm);
		request.getSession().setAttribute("user", adm);
		return "redirect:../admin/index/index";
	}

}
