package com.shensu.controller;

import java.io.File;
/**
 * 商品类目管理
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shensu.pojo.AboutMe;
import com.shensu.pojo.RecipesType;
import com.shensu.pojo.ShopType;
import com.shensu.service.ShopTypeService;
import com.shensu.tool.DateTime;
import com.shensu.tool.UploadHelper;

@Controller
@RequestMapping("admin/shopType")
public class ShopTypeController {
	@Autowired
	ShopTypeService shopTypeService;
 
	// 商品类别列表
	@RequestMapping("/list")
	public String list(Model model) {
		List<ShopType> shopTypeList = shopTypeService.selectAll();
		model.addAttribute("shopTypeList", shopTypeList);
		return "shopType/listShopType";

	}
	//微信小程序所需商品列表
	@ResponseBody
	@RequestMapping("/wxlist")
	public List<ShopType> wxlist(Model model) {
		List<ShopType> shopTypeList = shopTypeService.selectAll();
		
		return shopTypeList;

	}

	// 跳转添加商品类别页面
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String add() {

		return "add";
	}
	// 商品列表添加保存

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addsave(ShopType st) {
		st.setShoptypecreatetime(new DateTime().getDate());
		shopTypeService.insertShopType(st);
		return "redirect:list";
	}

	// 删除一个商品类别
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String del(int shopTypeId, HttpServletRequest request) {
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ "RegistCompanyIMG/";
		String prefix = request.getSession().getServletContext().getRealPath("/").replace("Svip", "RegistCompanyIMG");
		List<ShopType> shopTypeList = shopTypeService.selectAll();
		ShopType shopType = shopTypeService.selectById(shopTypeId);
		if (shopType.getShoptypeimg() != null  && !("".equals(shopType.getShoptypeimg()))) {
			String suffix = shopType.getShoptypeimg().substring(requestUrl.length() + 1);

			String realUrl = prefix + suffix;
			File targetFile = new File(realUrl);

			if (targetFile.exists()) {

				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
			}

			if (targetFile.isDirectory()) { // 如果是 文件夹
				try {
					FileUtils.deleteDirectory(targetFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (targetFile.isFile()) {// 如果是文件
				targetFile.delete();
			}

			shopTypeService.deleteShopType(shopTypeId);
		} else {
			shopTypeService.deleteShopType(shopTypeId);
		}
		return "redirect:list";
	}

	// 跳转到修改商品类别页面
	@RequestMapping(value = "/updatePage", method = RequestMethod.GET)
	public String update(int shopTypeId, HttpServletRequest request) {
		ShopType st = shopTypeService.selectById(shopTypeId);
		request.setAttribute("ShopType", st);
		return "update";
	}

	// 修改商品类别保存
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatesave(ShopType st) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		st.setShoptypecreatetime(new DateTime().getDate());
		shopTypeService.updateShopType(st);
		return "redirect:list";
	}

	// 替换商品类目的展示图(六张展示图)
	@RequestMapping(value = "/updateShopTypeImg", method = RequestMethod.POST)
	@ResponseBody
	public String updateShopTypeImg(int shopTypeId, @RequestParam("File") MultipartFile File,
			HttpServletRequest request) throws IOException {

		String img = UploadHelper.upload(File, request);
		ShopType st = new ShopType();
		st.setShoptypeimg(img);
		st.setShoptypecreatetime(new DateTime().getDate());
		st.setShoptypeid(shopTypeId);
		shopTypeService.updateShopTypeImg(st);
		return "findShopTypeImg";
	}

	// 删除商品类目展示图(修改图片为空)
	@RequestMapping(value = "/deleteShopTypeImg", method = RequestMethod.GET)
	@ResponseBody
	public String deleteShopTypeImg(int shopTypeId) {
		shopTypeService.deleteShopTypeImg(shopTypeId);
		return "findShopTypeImg";
	}

	// 根据商品类目id查询页面信息
	@RequestMapping(value = "/findShopTypeImg", method = RequestMethod.GET)
	@ResponseBody
	public ShopType findShopTypeImg(Integer shopTypeId) {
		System.out.println(shopTypeService.findShopTypeImg(shopTypeId));
		return shopTypeService.findShopTypeImg(shopTypeId);
	}
	         
	//首页展示图修改或添加预跳转
	@RequestMapping(value="/pre-add") 
	public String preAdd(Model model,@RequestParam(value="shoptypeid",defaultValue="0")int shoptypeid){
		List<ShopType> shopTypeList=shopTypeService.selectAll();
		if(shopTypeList.size()>0){
			model.addAttribute("shopTypeList", shopTypeList);
		}
		
		if(shoptypeid==0){
			ShopType st=shopTypeList.get(0);
			model.addAttribute("shoptype", st);
		}else{
			ShopType st=shopTypeService.selectById(shoptypeid);
			model.addAttribute("shoptype", st);
		}
		return "shopTypeSwiper/shopTypeSwiper"; 
	}
	
	// 在添加商品类目的同时给类目绑定上用户添加的图片
	@RequestMapping(value = "addTypeAndPhotoUpload")
	@ResponseBody
	public String addTypeAndPhoto(@RequestParam(value = "file", required = false) MultipartFile files,
			HttpServletRequest request, ShopType shopType) throws IOException {
		
		String imgUrl = UploadHelper.upload(files, request);
		
		ShopType st=shopTypeService.selectById(shopType.getShoptypeid());
		
		System.out.println(st.getShoptypeimg()+"img************************************************************");
		
	    String shopTypeSwiper=st.getShoptypeimg();
		
	    System.out.println(shopTypeSwiper);
	    
	    System.out.println("".equals(shopTypeSwiper));
	    
	    if(shopTypeSwiper!=null && !("".equals(shopTypeSwiper))){
			String requestUrl = request.getScheme() // 当前链接使用的协议
					+ "://" + request.getServerName()// 服务器地址
					+ "RegistCompanyIMG/";
	
			
		
			String prefix = request.getSession().getServletContext().getRealPath("/").replace("Svip",
					"RegistCompanyIMG");
			String suffix = shopTypeSwiper.substring(requestUrl.length() + 1);
			String realUrl = prefix + suffix;
			File targetFile = new File(realUrl);

			if (targetFile.exists()) { 

				System.out.println("文件存在");
			} else {
				System.out.println("文件不存在");
			}

			if (targetFile.isDirectory()) { // 如果是 文件夹
				try {
					FileUtils.deleteDirectory(targetFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else if (targetFile.isFile()) {// 如果是文件
				targetFile.delete();
			}

	    }
		// 在删除服务器上的图片后，吧数据库的数据进行先删除在增加的操作
		
		shopType.setShoptypeimg(imgUrl);
		System.out.println(imgUrl+"UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		shopTypeService.updateShopTypeImg(shopType);
		//这里的1代表与前段交互的ajax的状态码，1代表的是保存或者修改成功，具体交互见前段
		return "1";
	}
	
	
	
		//校验添加商品类目
		@ResponseBody
		@RequestMapping("addShopTypeXY")
		public String addShopTypeXY(ShopType shopType,String aa){
			System.out.println(aa+"*************************");
			List<ShopType> shopTypeList = shopTypeService.selectAll();
			System.out.println(shopTypeList.size()+"*************************");
			for (int i = 0; i < shopTypeList.size(); i++) {
					if(shopTypeList.get(i).getShoptypename().equals(aa)){
						return  "0";
					}				
				}	
		     return "1";
		}
		
		//校验修改商品类目
		@ResponseBody
		@RequestMapping("editShopTypeXY")
		public String editShopTypeXY(ShopType st,String Obtain,Integer shoptypeid){
			System.out.println(Obtain+"*************************"+shoptypeid);
			List<ShopType> shopTypeList = shopTypeService.editShopTypeXY(shoptypeid);
			System.out.println(shopTypeList.size()+"*************************");
			for (int i = 0; i < shopTypeList.size(); i++) {
					if(shopTypeList.get(i).getShoptypename().equals(Obtain)){
						return  "0";
					}				
				}	
		     return "1";
		}
	
}
