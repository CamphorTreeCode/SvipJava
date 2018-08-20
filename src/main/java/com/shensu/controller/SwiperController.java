package com.shensu.controller;

import java.io.File;
/**
 * 首页轮播图
 */
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.shensu.pojo.Shop;
import com.shensu.pojo.ShopType;
import com.shensu.pojo.Swiper;
import com.shensu.service.ShopService;
import com.shensu.service.SwiperService;
import com.shensu.tool.DateTime;
import com.shensu.tool.DeleteLocationImgHelper;
import com.shensu.tool.UploadHelper;

/**
 * 
 * @author YUKI 轮播图的上传时间
 */
@Controller
@RequestMapping("admin/swiper")
public class SwiperController {
	@Autowired
	SwiperService swiperService;
    @Autowired
    ShopService shopService;
	// 增加轮播图
	@RequestMapping(value = "/inserSwiper",method=RequestMethod.POST)
	public String inserSwiper(Swiper swiper, HttpServletRequest request, @RequestParam("File") MultipartFile File[]) throws IOException {
		for (MultipartFile f : File) {
			String img = UploadHelper.upload(f, request);
				Swiper s1 = new Swiper();
				s1.setSwiperimg(img);
				s1.setSwipercreattime(new DateTime().getDate());
				swiperService.inserSwiper(s1);
		}
		return "selectAll";
	}

	// 刪除一张轮播图
	@RequestMapping("/deleteSwiper")
	public String deleteSwiper(int swiperid) throws IOException {
		swiperService.deleteSwiper(swiperid);
		return "selectAll";
	}
	
	

	// 展示轮播图
	@RequestMapping("/findAllSwiper")
	public List<Swiper> findAllSwiper() throws IOException {
		System.out.println("*************************************");
		System.out.println("进来了");
		return  swiperService.findAllSwiper();
	}
	//预跳转首页展示图banner
	@RequestMapping("/indexBanner")
	public String indexBanner(HttpServletRequest request){
		List<Shop> shopList=shopService.getAll();
		request.setAttribute("shopList", shopList);
		List<Swiper> sList=swiperService.findAllSwiper();
		request.setAttribute("swiperList", JSONArray.toJSONString(sList));
		return "indexBanner/indexBanner";
	}
   
	//以下为渲染时新建控制器
	// 在添加商品类目的同时给类目绑定上用户添加的图片
	@RequestMapping(value = "indexSwiperUpload")
	@ResponseBody
	public String addTypeAndPhoto(@RequestParam(value = "file", required = false) MultipartFile files,
			HttpServletRequest request, ShopType shopType) throws IOException {
		
		
		String imgUrl = UploadHelper.upload(files, request);
		
		return imgUrl;
	}

	
	@RequestMapping("insert")
	public String insert(HttpServletRequest request,Swiper swiper,int []selectShopId) throws IOException{
		System.out.println(swiper.getShopId());
		Swiper s=swiperService.findByLocation(swiper.getLocation());
		swiper.setShopId(selectShopId[swiper.getLocation()-1]);
		if(s==null){
			swiperService.inserSwiper(swiper);
		}else{
			
			DeleteLocationImgHelper.deleteLocationImg(s.getSwiperimg(), request);
			int a=swiperService.update(swiper);
			System.out.println(a);
			//修改轮播图
		}
		return "redirect:indexBanner";
	}

}