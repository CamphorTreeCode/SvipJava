package com.shensu.controller;

/**
 * 首页、关于我们
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import com.shensu.pojo.MyCard;
import com.shensu.pojo.Shop;
import com.shensu.service.AboutMeService;
import com.shensu.service.MyCardService;
import com.shensu.service.ShopService;
import com.shensu.service.ShopTypeService;
import com.shensu.service.SwiperService;
import com.shensu.tool.DateTime;
import com.shensu.tool.taobaoke.GetTKL;


import net.sf.json.JSONArray;


@Controller
@RequestMapping("/WXShop")
public class WXShopController {
	
	@Autowired
	SwiperService ss;
	
	@Autowired
	ShopTypeService sts;
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	AboutMeService as;

	@Autowired
	MyCardService myCardService;
	
	@Autowired
	ShopTypeService shopTypeService;

	
	//查询首页轮播图
	@RequestMapping(value = "/findHomePageImg", method = RequestMethod.GET)
	public void findHomePageSwiper(HttpServletResponse response) throws IOException{
		//System.out.println("进入主方法了");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(ss.findAllSwiper());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}

	//查询首页六张展示图(所有类目信息)
	@RequestMapping(value = "/findHomePageShopImg", method = RequestMethod.GET)
	public void findHomePageShopImg(HttpServletResponse response) throws IOException{
		//System.out.println("进入主方法了");
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(sts.findShopTypeImg());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//查询全部商品类目
	@RequestMapping(value = "/findHomePageShopType", method = RequestMethod.GET)
	public void findHomePageShopType(HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(sts.selectAll());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//根据商品类目查询前两个商品
	@RequestMapping(value = "/findHomePageShop", method = RequestMethod.GET)
	public void findHomePageShop(HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(shopTypeService.selectShopTypeTwo());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//查询关于我们的全部内容
	@RequestMapping(value = "/findAboutMe", method = RequestMethod.GET)
	@ResponseBody
	
	public void findAboutMe(HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(as.findAboutMeDetails());
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//查询商品类目下全部商品
	@RequestMapping(value = "/findShopList", method = RequestMethod.GET)
	@ResponseBody
	public void findShopList(int shopTypeId, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(shopService.findShopList(shopTypeId));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
	}
	
	//查询商品详情页
	@RequestMapping(value = "/findShopDetails", method = RequestMethod.GET)
	@ResponseBody
	//@ApiOperation(value="findShopDetails",notes="查询商品详情页",httpMethod="GET",response = Shop.class)		
	@ApiResponses(value = { @ApiResponse(code = 200, message = "请求成功返回的json结构", response = Shop.class) })
	public List<Shop> findShopDetails(@ApiParam(name="shopId",value = "商品的id", defaultValue="99", required = true)@RequestParam(value="shopId",required=false)int shopId, HttpServletResponse response) throws IOException{
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了");
		response.setCharacterEncoding("utf-8");
		List<Shop> ls = shopService.findShopDetails(shopId);
		JSONArray jsonArray = JSONArray.fromObject(ls);
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
		pw.close();
		System.out.println("恭喜您已完成展示");
		
   return ls;
	}
	//根据类目id查询商品的前6个 分页查询
	@RequestMapping("/selectShopTypePage")
	public void selectShopTypePage(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,String shopTypeId, String shoptitle,HttpServletResponse response) throws IOException{
//		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("根据类目id查询商品的前6个 分页查询");
		System.out.println(currentPage+shopTypeId);
		Shop shop = new Shop();
		System.out.println("null".equals(shoptitle));
		Integer shopTypeIds;
		   if(shopTypeId!=null&& !"".equals(shopTypeId) &&!"null".equals(shopTypeId))
		   {
			   shopTypeIds=Integer.parseInt(shopTypeId);
		   }else{
			   shopTypeIds=null;
		   }
		shop.setShoptitle(shoptitle==null||"".equals(shoptitle)||shoptitle.equals("null")?null:shoptitle);
		   
		shop.setShoptypeid(shopTypeIds);
		System.out.println(shop.getShoptitle());
		response.setCharacterEncoding("utf-8");
		JSONArray jsonArray = JSONArray.fromObject(shopService.selectShopTypePage(currentPage,shop));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
		
		System.out.println("恭喜您已完成展示");
	}	
	//生成陶口令 
	//查询商品详情页
	@RequestMapping(value = "/creartTKL", method = RequestMethod.GET)
	@ResponseBody
	public void creartTKL(String openId,Integer shopid,String shopUrl,String shopDiscountUrl,String pid,String shopLogoUrl, HttpServletResponse response) throws  com.taobao.api.ApiException, IOException {
		response.setHeader("Content-type", "text/html;charset=UTF-8");  
		System.out.println("进入主方法了-");
		response.setCharacterEncoding("utf-8");
		
	    System.out.println(shopUrl+shopLogoUrl);
	    System.out.println(shopDiscountUrl);
	    System.out.println(pid+openId+shopid);
		//增加数据 先查询数据库有没有数据 没有进行增加 有不增加直接返回数据
	    MyCard  mc = new MyCard();
	    mc.setOpenid(openId);
	    mc.setShopid(shopid);
	    mc.setMycardcreattime(DateTime.getDate());
	    int num = myCardService.selectCardIs(mc);
	    if(num>0){
	    	//如果有就不增加
	    	System.out.println("已经有卡卷就不增加");
	    }else{
	    	System.out.println("没有卡卷就增加");
	    	//如果没有就增加
	    	int nums = myCardService.insertMyCard(mc);
	    	if(nums>0){
	    		System.out.println("增加卡卷成功");
	    	}
	   }
		JSONArray jsonArray = JSONArray.fromObject(GetTKL.Tkl(shopUrl,shopDiscountUrl,pid,shopLogoUrl));
		PrintWriter pw = response.getWriter();
		pw.print(jsonArray);
		System.out.println("恭喜您已完成展示");
	}
	
}
