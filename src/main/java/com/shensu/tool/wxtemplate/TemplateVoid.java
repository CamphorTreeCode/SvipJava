package com.shensu.tool.wxtemplate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shensu.pojo.Franchiser;
import com.shensu.pojo.FranchiserUser;
import com.shensu.service.FranchiserService;
import com.shensu.service.ShopTypeService;
import com.shensu.service.SwiperService;
import com.shensu.service.impl.TemplateServiceImpl;
import com.shensu.tool.HttpRequestor;
import com.shensu.tool.UpdataName;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 * @author YUKI
 * 模版消息的推送方法
 */

public class TemplateVoid {
	@Autowired
	FranchiserService franchiserService;
	/**
	 * 发送微信消息
	 * @param request
	 * @param model
	 */
	//查询首页轮播图
	 public void sendMessage(String openId,HttpServletRequest request,Model model){  
		    Franchiser fer = new Franchiser();
		    fer.setOpenid(openId);
		    Franchiser fe  =  franchiserService.findOpenidTemplate(fer);
	    	Template tem=new Template();  
			tem.setTemplateId("WsHtokVPQi807XPVUm7HRr7MofSzhroc47hbOc5Yk1s");  
			tem.setFormId(fe.getFormId());
			tem.setToUser(openId);  
			tem.setUrl("");  			
			List<TemplateParam> paras=new ArrayList<TemplateParam>();  
			paras.add(new TemplateParam("keyword1","猪猪侠","#0044BB"));  
			paras.add(new TemplateParam("keyword2","999","#0044BB"));  
			paras.add(new TemplateParam("keyword3","成个猪栏最叻就系你","#AAAAAA"));  
			paras.add(new TemplateParam("keyword4","666","#0044BB"));  
			paras.add(new TemplateParam("keyword5","131123456789","#AAAAAA"));  			          
			tem.setTemplateParamList(paras);        
			boolean result=sendTemplateMsg(tem); 
			System.out.println(result);
	    }  
	 
	 
	 public static boolean sendTemplateMsg(Template template){  
		   String token = getToken(template);
	       boolean flag=false;   
	        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";  
	        requestUrl=requestUrl.replace("ACCESS_TOKEN", token);  
	        String jsonString = template.toJSON();
	        JSONObject jsonResult=CommonUtil.httpsRequest(requestUrl, "POST", jsonString);  
	        if(jsonResult!=null){  
	            int errorCode=jsonResult.getInt("errcode");  
	            String errorMessage=jsonResult.getString("errmsg");  
	            if(errorCode==0){  
	                flag=true;  
	            }else{  
	                System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);  
	                flag=false;  
	            }  
	        }
	        return flag;          
	    }  
		
		
		/**
		 *获取token 
		 * @param template
		 * @return
		 */
	
	    public static String getToken(Template template){  
	        String requestUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+UpdataName.appid+"&secret="+UpdataName.secret;  
	        JSONObject jsonResult=CommonUtil.httpsRequest(requestUrl, "POST", template.toJSON());  
	        if(jsonResult!=null){  
	            String access_token=jsonResult.getString("access_token");  
	            return access_token;
	        }else{  
	        	  return "";     
	        }    
	    }  
	    public static void main(String[] args) throws Exception {
			System.out.println("test");
		    String requestUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+UpdataName.appid+"&secret="+UpdataName.secret;  
		    System.out.println(new HttpRequestor().doGet(requestUrl));
		    
		}
}
