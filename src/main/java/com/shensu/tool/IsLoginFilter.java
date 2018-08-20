package com.shensu.tool;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;


public class IsLoginFilter implements Filter{
	
	public void destroy() {
		
	}
	 
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;	
		String uri = req.getRequestURI();
			
			System.out.println(">>>>>>>>"+uri);
		if(uri.endsWith(UpdataName.projectName+"/")||uri.endsWith(UpdataName.projectName+"/tool/uploadImg") ||uri.endsWith(UpdataName.projectName+"/tool/addImg")||uri.endsWith(UpdataName.projectName+"/user/addUser") ||uri.endsWith(UpdataName.projectName+"/company/addCompany") ||uri.endsWith(UpdataName.projectName+"/login/login") || uri.endsWith(UpdataName.projectName+"/login/tologin") || uri.indexOf("index") >= 0  || uri.indexOf("css") >= 0  ||uri.indexOf("img") >= 0  || uri.indexOf("js") >= 0  || uri.indexOf("images") >= 0 ){
			System.out.println(111);
	 
			chain.doFilter(request, response);
		}else{
			Object user_name = req.getSession().getAttribute("user_name");
			Object xcxuser_name = req.getHeader("xcxuser_name");
			System.out.println(222);
			System.out.println("----"+user_name+"----"+xcxuser_name);
			if(user_name != null || xcxuser_name != null){
				System.out.println(333);
				chain.doFilter(request, response);
			}else{
				System.out.println(444);
				//resp.sendRedirect("<script>top.location.href='/index.jsp'</script>");
				resp.getWriter().write("<script>top.location.href=\"/yhsc/login/tologin\"</script>");
				
			}
		}
	}
	
}