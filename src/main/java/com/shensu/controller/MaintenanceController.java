package com.shensu.controller;
/**
 * 维修管理
 */
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shensu.pojo.Maintenance;
import com.shensu.service.MaintenanceService;
import com.shensu.tool.Page;

@Controller
@RequestMapping("/admin/maintenance")
public class MaintenanceController {
	
	@Autowired
	MaintenanceService maintenanceService;
	
//	//添加维修申请信息
//	@RequestMapping(value="/addMaintenanceMsg",method = RequestMethod.GET) 
//	@ResponseBody
//	public String addMaintenanceMsg(Maintenance maintenance) throws IOException{
//		maintenance.setMaintenancecreattime(new DateTime().getDate());
//		maintenanceService.addMaintenanceMsg(maintenance);
//		 return "添加成功";
//	}
	
	//分业查询
	//@ResponseBody
	@RequestMapping("/findMaintenanceMsgList")
	public String findMaintenanceMsgList(@RequestParam(value="currentPage",defaultValue="1",required=false)Integer currentPage,
			@RequestParam(value="maintenanceName",required=false)String maintenanceName,
			@RequestParam(value="maintenancemodel",required=false)String maintenancemodel,
			@RequestParam(value="maintenancePhone",required=false)String maintenancePhone,
			HttpServletRequest request,
			Model model	
			){
		System.out.println(maintenanceName+"**********************");
		System.out.println(maintenancemodel+"**********************");
		System.out.println(maintenancePhone+"**********************");
			if("".equals(maintenanceName)){
				maintenanceName=null;
			}
			if("".equals(maintenancemodel)){
				maintenancemodel=null;
			}
			if("".equals(maintenancePhone)){
				maintenancePhone=null;
			}
			model.addAttribute("maintenanceMsgList",maintenanceService.selectByCondition(
					currentPage, maintenanceName, maintenancemodel, maintenancePhone));
			Page<Maintenance> maintenanceMsgList=maintenanceService.selectByCondition(
					currentPage,maintenanceName, maintenancemodel, maintenancePhone);
			System.out.println(maintenanceMsgList.getCurrPage()+"当前页码");
			System.out.println(maintenanceMsgList.getPageSize()+"每页条数");
			System.out.println(maintenanceMsgList.getTotalCount()+"总记录数");
			System.out.println(maintenanceMsgList.getTotalPage()+"总页数");
			System.out.println(maintenanceMsgList.getLists().size());
			model.addAttribute("maintenanceName", maintenanceName);
			model.addAttribute("maintenancemodel", maintenancemodel);
			model.addAttribute("maintenancePhone",maintenancePhone);
			model.addAttribute("currentPage", currentPage);
			return "maintenance/listMaintenance";
	}
	
//	//跳转到审核维修信息页面
//	@RequestMapping(value="/findMaintenanceMsgDetailsPage",method=RequestMethod.GET)
//	public String findMaintenanceMsgDetailsPage(){
//	    return "findMaintenanceMsgDetails";
//	}
	
	//查看维修信息
	@RequestMapping(value="/findMaintenanceMsgDetails",method=RequestMethod.GET)
	@ResponseBody
    public Maintenance findMaintenanceMsgDetails(Integer maintenanceId){
		maintenanceService.finishRead(maintenanceId);
		maintenanceService.findMaintenanceMsgDetails(maintenanceId);
		 return maintenanceService.findMaintenanceMsgDetails(maintenanceId);
	} 

	//网页端查看维修信息(审核跳转详情页面)
	@RequestMapping(value="/WyfindMaintenanceMsgDetails",method=RequestMethod.GET)
    public String WyfindMaintenanceMsgDetails(Integer maintenanceId,Model model, Integer currentPage, String maintenanceName){
		maintenanceService.finishRead(maintenanceId);
		Maintenance maintenance=maintenanceService.findMaintenanceMsgDetails(maintenanceId);
		model.addAttribute("maintenance", maintenance);
		 model.addAttribute("maintenanceName", maintenanceName);
		 model.addAttribute("currentPage", currentPage);
		 return "maintenance/maintenanceLook";
	} 
	
	//审核通过
	@RequestMapping(value="/auditSuccess")
	public String auditSuccess(Integer maintenanceId, Model model, Integer currentPage, String maintenanceName ){
		 maintenanceService.auditSuccess(maintenanceId);
		 model.addAttribute("maintenanceName", maintenanceName);
		 model.addAttribute("currentPage", currentPage);
		return "redirect:findMaintenanceMsgList";
	} 
	
	//审核不通过
	@RequestMapping(value="/auditFail")
	public String auditFail(Integer maintenanceId, Model model, Integer currentPage, String maintenanceName){
		 maintenanceService.auditFail(maintenanceId);
		 model.addAttribute("maintenanceName", maintenanceName);
		 model.addAttribute("currentPage", currentPage);
		 return "redirect:findMaintenanceMsgList";
	} 
	
	//删除维修申请信息
	@RequestMapping(value="/deleteMaintenanceMsg",method=RequestMethod.GET)
	//@ResponseBody
	public String deleteMaintenanceMsg(Integer maintenanceId){
		 maintenanceService.deleteMaintenanceMsg(maintenanceId);
		 return "redirect:findMaintenanceMsgList";
	} 
	
	//后台首页跳转到维修管理列表
	@RequestMapping(value="/findMaintenanceMsgListPage",method=RequestMethod.GET)
	public String findMaintenanceMsgListPage(){
		  return "findMaintenanceMsgList";
	}
}
