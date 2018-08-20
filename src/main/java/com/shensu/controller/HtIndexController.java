package com.shensu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shensu.service.FranchiserService;
import com.shensu.service.MaintenanceService;

@Controller
@RequestMapping("admin/index")
public class HtIndexController {
	
	@Autowired
	FranchiserService franchiserService;
	
	@Autowired
	MaintenanceService maintenanceService;
	
	@RequestMapping("index")
	public String index(Model model){
		//统计加盟管理未读数据
		int franchiserUnRead = franchiserService.findAllUnRead();
		//统计维修管理未读数据
		int maintenanceUnRead = maintenanceService.findAllUnRead();
		model.addAttribute("franchiserUnRead", franchiserUnRead);
		model.addAttribute("maintenanceUnRead", maintenanceUnRead);
		return "index";
	}
	
}
