package com.shensu.controller;

/**
 * 首页-中央维修
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shensu.pojo.Maintenance;
import com.shensu.service.MaintenanceService;
import com.shensu.tool.DateTime;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WXMaintenance")
public class WXMaintenanceController {
	
	@Autowired
	MaintenanceService maintenanceService;
		
		/**
		 * 
		 * @param maintenance 实体类
		 * @param response  响应
		 * @throws IOException 文件异常
		 */
		@RequestMapping(value="/addMaintenanceMsg",method = RequestMethod.GET) 
		@ResponseBody
		public void addMaintenanceMsg(Maintenance maintenance,HttpServletResponse response) throws IOException{
			maintenance.setMaintenancecreattime(new DateTime().getDate());
           System.out.println(maintenance);
			 int num = 	maintenanceService.addMaintenanceMsg(maintenance);
			 response.setCharacterEncoding("utf-8");
			 JSONObject json = new JSONObject();
			 PrintWriter pw = response.getWriter();
			 if(num>0){
				 json.put("franchiseState", true);					
				 pw.print(json);
			 }else{
				 json.put("franchiseState", false);					
				 pw.print(json); 
			 }
		
	
		}
	
}
