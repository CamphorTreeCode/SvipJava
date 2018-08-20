package com.shensu.controller;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
/**
 * 加盟管理
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.JoinRowSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.shensu.pojo.Data;
import com.shensu.pojo.Franchiser;
import com.shensu.pojo.Template2;
import com.shensu.pojo.keyword;
import com.shensu.service.FranchiserService;
import com.shensu.tool.HttpRequestor;
import com.shensu.tool.Page;
import com.shensu.tool.UpdataName;
import com.shensu.tool.UrlHelper;

@Controller
@RequestMapping("admin/franchiser")
public class FranchiserController {

	@Autowired
	private FranchiserService franchiserService;

	// 分页查询加盟者列表
	@RequestMapping(value = "/findFranchiserList")
	public String list(@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "franchiserName", required = false) String franchiserName,
			@RequestParam(value = "franchiserCreatTime", required = false) String franchiserCreatTime,
			@RequestParam(value = "franchiserOrderNmuber", required = false) String franchiserOrderNmuber,
			HttpServletRequest request, Model model) {

		System.out.println(franchiserName);
		System.out.println(franchiserCreatTime);
		System.out.println(franchiserOrderNmuber);

		if ("".equals(franchiserName)) {
			franchiserName = null;
		}
		if ("".equals(franchiserCreatTime)) {
			franchiserCreatTime = null;
		}
		if ("".equals(franchiserOrderNmuber)) {
			franchiserOrderNmuber = null;
		}

		model.addAttribute("franchiserList", franchiserService.selectByCondition(currentPage, franchiserName,
				franchiserCreatTime, franchiserOrderNmuber));
		Page<Franchiser> franchiserList = franchiserService.selectByCondition(currentPage, franchiserName,
				franchiserCreatTime, franchiserOrderNmuber);
		System.out.println(franchiserList.getCurrPage() + "当前页码");
		System.out.println(franchiserList.getPageSize() + "每页条数");
		System.out.println(franchiserList.getTotalCount() + "总记录数");
		System.out.println(franchiserList.getTotalPage() + "总页数");

		model.addAttribute("franchiserName", franchiserName);
		model.addAttribute("franchiserCreatTime", franchiserCreatTime);
		model.addAttribute("franchiserOrderNmuber", franchiserOrderNmuber);
		model.addAttribute("currentPage", currentPage);

		return "franchiser/listFranchiserDetails";
	}

	// 跳转添加账号页面
	@RequestMapping(value = "/addFranchiserUserAccounts", method = RequestMethod.GET)
	public String addFranchiserUserAccounts(String openId, Model model) {
		System.out.println("****************************************" + openId);
		model.addAttribute("openId", openId);
		return "franchiserUser/addFranchiserUserAccounts";
	}

	// 删除加盟用户
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteFranchiser(Integer franchiserId) {
		System.out.println(franchiserId);
		franchiserService.deleteFranchiser(franchiserId);
		System.out.println("删除成功");
		return "redirect:findFranchiserList";
	}

	// 跳转查询一个加盟者信息页面 (审核页面)
	@RequestMapping(value = "/findFranchiserDetailsPage", method = RequestMethod.GET)
	public String findFranchiserDetailsPage() {
		return "franchiser/findFranchiserDetails";
	}

	// 查询一个加盟者信息
	@RequestMapping(value = "/findFranchiserDetails", method = RequestMethod.GET)
	@ResponseBody
	public Franchiser findFranchiserDetails(Integer franchiserId) {
		// 设置状态为已经阅读
		franchiserService.finishRead(franchiserId);

		franchiserService.findFranchiserDetails(franchiserId);
		return franchiserService.findFranchiserDetails(franchiserId);
	}

	// 网页端返回加盟者信息(预修改回显数据)
	@RequestMapping(value = "/HtFindFranchiserDetails", method = RequestMethod.GET)
	public String HtFindFranchiserDetails(Integer franchiserId, Model model, Integer currentPage,
			String franchiserName) {
		// 设置状态为已经阅读
		franchiserService.finishRead(franchiserId);
		// 查询加盟者信息
		Franchiser franchiser = franchiserService.findFranchiserDetails(franchiserId);
		model.addAttribute("franchiser", franchiser);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("franchiserName", franchiserName);
		return "franchiser/findFranchiserDetails";
	}

	// 审核通过
	@RequestMapping(value = "/auditSuccess", method = RequestMethod.GET)
	public String auditSuccess(Integer franchiserId, Model model, Integer currentPage, String franchiserName) {
		franchiserService.auditSuccess(franchiserId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("franchiserName", franchiserName);
		return "redirect:findFranchiserList";
	}

	// 审核不通过
	@RequestMapping(value="/auditFail",method=RequestMethod.GET)
	public String auditFail(Integer franchiserId, Model model, Integer currentPage, String franchiserName) throws Exception{
		franchiserService.auditFail(franchiserId);	
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("franchiserName", franchiserName);
		
	 	Franchiser franchiser = franchiserService.findFranchiserDetails(franchiserId);
		
		HttpRequestor httpRequestor = new HttpRequestor();
		String result=httpRequestor.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + UpdataName.appid
				+ "&secret=" + UpdataName.secret + "");
		JSONObject access = JSONObject.parseObject(result);
		

		
		Template2 template = new Template2();
		
		template.setTouser( franchiser.getOpenid() );
		
		template.setTemplate_id(UpdataName.template1);		
	    
		template.setPage("pages/index/index");
		
		template.setForm_id( franchiser.getFormId() );
		
		template.setData(new Data(new keyword(franchiser.getFranchisecreattime()), new keyword(franchiser.getFranchisename()), new keyword("您的申请未通过，请在‘我的’页面中联系客服询问详情。")));
		
		String result2 = UrlHelper.postResult("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access.get("access_token")+"", template);
		System.out.println(result2);
		System.out.println("****************************************************************************************************");
		return "redirect:findFranchiserList";
	}

	// 查询加盟者全部列表
	@RequestMapping(value = "/findAllFranchiserDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<Franchiser> findAllFranchiserDetails(Franchiser franchiser) {
		return franchiserService.findAllFranchiserDetails(franchiser);
	}

//	//添加加盟者申请信息(小程序)
//	@RequestMapping(value="/addFranchiserMsg",method = RequestMethod.GET) 
//	@ResponseBody
//	public String addFranchiserMsg(Franchiser franchiser) throws IOException{
//		franchiser.setFranchisecreattime(new DateTime().getDate());
//		 franchiserService.addFranchiserMsg(franchiser);
//		 return "添加成功";
//		
//	}

	// 跳转添加账号页面
	@RequestMapping(value = "/findFranchiserListPage", method = RequestMethod.GET)
	public String findFranchiserListPage() {
		return "findFranchiserList";
	}

}
