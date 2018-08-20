package com.shensu.controller;

import java.io.File;
/**
 * 商品管理
 */
import java.io.IOException;
import java.util.ArrayList;
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
import com.shensu.pojo.Shop;
import com.shensu.pojo.ShopSKU;
import com.shensu.pojo.ShopSkuSwiper;
import com.shensu.pojo.ShopSwiper;
import com.shensu.pojo.ShopType;
import com.shensu.service.MyCardService;
import com.shensu.service.ShopSKUService;
import com.shensu.service.ShopService;
import com.shensu.service.ShopSkuSwiperService;
import com.shensu.service.ShopSwiperService;
import com.shensu.service.ShopTypeService;
import com.shensu.tool.DateTime;
import com.shensu.tool.Page;
import com.shensu.tool.UploadHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/shop")
public class ShopController {
	@Autowired
	ShopService shopService;

	@Autowired
	ShopSwiperService shopSwiperService;

	@Autowired
	ShopSkuSwiperService shopSkuSwiperService;

	@Autowired
	ShopSKUService shopSKUService;

	@Autowired
	ShopTypeService shopTypeService;
	
	@Autowired
	MyCardService myCardService;

	// 单张图片上传
	@ResponseBody
	@RequestMapping("/goodsUpload")
	public String studyUpload(@RequestParam(value = "file", required = false) MultipartFile files,
			HttpServletRequest request) throws IOException {

		String imgUrl = UploadHelper.upload(files, request);

		return imgUrl;
	}

	// 根据条件分页查询商品
	@RequestMapping("/shopList")
	public String list(@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "shopTypeName", required = false) String shopTypeName,
			@RequestParam(value = "shopState", required = false) Integer shopState,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "shopTitle", required = false) String shopTitle, HttpServletRequest request,
			Model model) {

		if ("".equals(shopTitle)) {
			shopTitle = null;
		}
		if ("".equals(shopName)) {
			shopName = null;
		}

		Integer shopTypeId = null;
		if (shopTypeName != null && !"".equals(shopTypeName)) {
			shopTypeId = shopTypeService.getShopTypeIdByName(shopTypeName);
		}

		// 商品类别列表
		List<ShopType> shopTypeList = shopTypeService.selectAll();
		model.addAttribute("shopTypeList", shopTypeList);

		// 分页商品信息
		Page<Shop> shopList = shopService.selectByCondition(currentPage, shopTitle, null, shopName, shopState,
				shopTypeId);
		model.addAttribute("shopList", shopList);

		model.addAttribute("shopTitle", shopTitle);
		model.addAttribute("shopState", shopState);
		model.addAttribute("shopName", shopName);
		model.addAttribute("shopTypeName", shopTypeName);
		return "goods/addquery";
	}

	// 跳转添加商品页面
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String add(Model model) {
		// 商品类别列表
		List<ShopType> shopTypeList = shopTypeService.selectAll();
		System.out.println("商品类别列表：" + shopTypeList);
		model.addAttribute("shopTypeList", shopTypeList);
		model.addAttribute("shopTypeDefault", shopTypeList.get(0));
		return "goods/addgood";
	}

	// 添加保存
	@RequestMapping(value = "/addSave", method = RequestMethod.POST)
	public String addsave(Shop shop, String shopswires, String shopswireslist) {

		System.out.println("*******************************************************************************");
		System.out.println(shopswireslist);
		System.out.println("*******************************************************************************");

		shop.setShopcretattime(new DateTime().getDate());
		shopService.insertShop(shop);
		Integer shopId = shop.getShopid();
		// 循环获取放入图片到数据库
		String[] swires = shopswires.split(",");
		ShopSwiper simg = new ShopSwiper();
		simg.setShopid(shopId);
		for (String string : swires) {
			simg.setShopswiperimg(string);
			simg.setShopswipercreattime(new DateTime().getDate());
			shopService.insertShopImg(simg);
		}
		if (!"".equals(shopswireslist)) {
			// SKU信息数组
			JSONArray JsonArray = JSONArray.fromObject(shopswireslist);
			// 循环获取数组里面的SKU信息
			for (Object object : JsonArray) {
				JSONObject jsonObject = JSONObject.fromObject(object);
				ShopSKU shopSKU = (ShopSKU) JSONObject.toBean(jsonObject, ShopSKU.class);
				String shopskuSting = shopSKU.getShopsku();
				String sukSwires = shopSKU.getShopskuimg();
				shopSKU.setShopskuimg("");
				shopSKU.setShopid(shopId);
				shopSKU.setShopskutime(new DateTime().getDate());
				shopSKUService.insertShopSKU(shopSKU);
				Integer shopSKUid = shopSKU.getShopskuid();
				// 循环获取放入图片到数据库
				String[] skuswArray = sukSwires.split(",");
				ShopSkuSwiper skusw = new ShopSkuSwiper();
				skusw.setShopskuid(shopSKUid);
				for (String string : skuswArray) {
					skusw.setShopSkuSwiperCreatTime(new DateTime().getDate());
					skusw.setShopSkuSwiperUrl(string);
					shopSkuSwiperService.insertShopSkuSwiper(skusw);
				}
			}
		}
		return "redirect:shopList";
	}

	// 跳转修改页面
	@RequestMapping("/modifyShop")
	public String modifyShop(Integer shopId, Model model) {

		// 商品类别列表
		List<ShopType> shopTypeList = shopTypeService.selectAll();
		// 根据id查询商品
		Shop shop = shopService.queryShopAllandSKUAll(shopId);
		/* System.out.println("================shop==============" + shop); */

		// 解析商品label
		List<String> labelList = new ArrayList<String>();
		JSONArray JsonLable = JSONArray.fromObject(shop.getShoplable());
		for (Object object : JsonLable) {
			labelList.add(object.toString());
		}
		// 解析商品属性
		List<Object> prpoList = new ArrayList<Object>();
		JSONArray Jsonprop = JSONArray.fromObject(shop.getShopdetails());
		for (Object object : Jsonprop) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			prpoList.add(jsonObject);
		}

		// 解析商品轮播图
		String shopSwires = "";
		List<ShopSwiper> lists = shop.getShopSwiperList();
		for (ShopSwiper shopSwiper : lists) {
			shopSwires += shopSwiper.getShopswiperimg() + ",";
		}
		/* System.out.println("商品录播图拼接：" + shopSwires); */

		// 商品sku轮播图
		List<ShopSKU> shopSKUList = shop.getShopSKUMoney();
		for (ShopSKU shopSKU : shopSKUList) {
			List<ShopSkuSwiper> SkuSwiperList = shopSKU.getShopSkuSwiper();
			String skuImgsString = "";
			for (ShopSkuSwiper shopSkuSwiper : SkuSwiperList) {
				skuImgsString += shopSkuSwiper.getShopSkuSwiperUrl() + ",";
			}
			shopSKU.setShopskuimg(skuImgsString);
		}
		shop.setShopSKUMoney(shopSKUList);

		model.addAttribute("labelList", labelList);
		model.addAttribute("prpoList", prpoList);
		model.addAttribute("shop", shop);
		model.addAttribute("shopTypeList", shopTypeList);
		model.addAttribute("shopSwires", shopSwires);

		return "goods/editgood";
	}

	// 修改保存
	@RequestMapping(value = "/saveModifyShop", method = RequestMethod.POST)
	public String modifyShop(Shop shop, String shopswires, String shopswireslist, HttpServletRequest request) {

		/*
		 * System.out.println(shop.getShoptypeid());
		 * System.out.println("===========shop =========" + shop);
		 * System.out.println("===========shopswires =========" + shopswires);
		 * System.out.println("===========shopswireslist =========" +
		 * shopswireslist);
		 */

		Integer shopId = shop.getShopid();
		DeleteShopSwiperImgs(shopId, request);
		// 循环获取放入图片到数据库
		String[] swires = shopswires.split(",");
		ShopSwiper simg = new ShopSwiper();
		simg.setShopid(shopId);
		for (String string : swires) {
			simg.setShopswiperimg(string);
			simg.setShopswipercreattime(new DateTime().getDate());
			shopService.insertShopImg(simg);
		}

		List<ShopSKU> skulist = shopSKUService.findShopSKUAllByshopId(shopId);
		for (ShopSKU shopsku : skulist) {
			DeleteSKUSwiperImgs(shopsku.getShopskuid(), request);
		}

		// 删除shopSKU
		shopService.deleteShopSKU(shopId);

		// SKU信息数组
		JSONArray JsonArray = JSONArray.fromObject(shopswireslist);
		// 循环获取数组里面的SKU信息
		for (Object object : JsonArray) {
			JSONObject jsonObject = JSONObject.fromObject(object);
			ShopSKU shopSKU = (ShopSKU) JSONObject.toBean(jsonObject, ShopSKU.class);
			String shopskuSting = shopSKU.getShopsku();
			String sukSwires = shopSKU.getShopskuimg();
			shopSKU.setShopskuimg("");
			shopSKU.setShopid(shopId);
			shopSKU.setShopskutime(new DateTime().getDate());
			shopSKUService.insertShopSKU(shopSKU);

			Integer shopSKUid = shopSKU.getShopskuid();

			// 循环获取放入图片到数据库
			String[] skuswArray = sukSwires.split(",");
			ShopSkuSwiper skusw = new ShopSkuSwiper();
			skusw.setShopskuid(shopSKUid);
			for (String string : skuswArray) {
				skusw.setShopSkuSwiperCreatTime(new DateTime().getDate());
				skusw.setShopSkuSwiperUrl(string);
				shopSkuSwiperService.insertShopSkuSwiper(skusw);
			}
		}

		shop.setShopcretattime(new DateTime().getDate());
		shopService.modifyShop(shop);

		return "redirect:shopList";
	}

	// 删除商品
	@RequestMapping(value = "/deleteShop", method = RequestMethod.GET)
	public String deleteShop(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) Integer currentPage,
			@RequestParam(value = "shopTypeName", required = false) String shopTypeName,
			@RequestParam(value = "shopState", required = false) Integer shopState,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "shopTitle", required = false) String shopTitle,
			@RequestParam(value = "shopId", required = false) Integer shopId, Model model, HttpServletRequest request) {

		DeleteShopSwiperImgs(shopId, request);
		List<ShopSKU> skulist = shopSKUService.findShopSKUAllByshopId(shopId);
		if (skulist.size() != 0) {
			for (ShopSKU shopSKU : skulist) {
				DeleteSKUSwiperImgs(shopSKU.getShopskuid(), request);
			}
		}
		shopService.deleteShopSKU(shopId);
		myCardService.deleteMyCardByShopId(shopId);
		shopService.deleteShop(shopId);

		model.addAttribute("currentPage", currentPage);
		model.addAttribute("shopTypeName", shopTypeName);
		model.addAttribute("shopState", shopState);
		model.addAttribute("shopName", shopName);
		model.addAttribute("shopTitle", shopTitle);
		return "redirect:shopList";
	}

	// 设置商品为上架状态
	@RequestMapping(value = "/putawayShop", method = RequestMethod.GET)
	public String putawayShop(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value = "shopTypeName", required = false) String shopTypeName,
			@RequestParam(value = "shopState", required = false) Integer shopState,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "shopTitle", required = false) String shopTitle,
			@RequestParam(value = "shopId", required = true) Integer shopId, Model model) {
		shopService.putawayShop(shopId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("shopTypeName", shopTypeName);
		model.addAttribute("shopState", shopState);
		model.addAttribute("shopName", shopName);
		model.addAttribute("shopTitle", shopTitle);
		return "redirect:shopList";
	}

	// 设置商品为下架状态
	@RequestMapping(value = "/unshelveShop", method = RequestMethod.GET)
	public String unshelveShop(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value = "shopTypeName", required = false) String shopTypeName,
			@RequestParam(value = "shopState", required = false) Integer shopState,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "shopTitle", required = false) String shopTitle,
			@RequestParam(value = "shopId", required = true) Integer shopId, Model model) {
		shopService.unshelveShop(shopId);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("shopTypeName", shopTypeName);
		model.addAttribute("shopState", shopState);
		model.addAttribute("shopName", shopName);
		model.addAttribute("shopTitle", shopTitle);
		return "redirect:shopList";
	}

	// 批量上架
	@RequestMapping(value = "/batchPutawayShop", method = RequestMethod.GET)
	public String batchPutawayShop(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage,
			@RequestParam(value = "shopTypeName", required = false) String shopTypeName,
			@RequestParam(value = "shopState", required = false) Integer shopState,
			@RequestParam(value = "shopName", required = false) String shopName,
			@RequestParam(value = "shopTitle", required = false) String shopTitle,
			@RequestParam(value = "choseStr", required = true) String choseStr, Model model) {
		String[] shopArray = choseStr.split("-");
		for (String string : shopArray) {
			if (!string.equals("0")) {
				Integer shopId = Integer.parseInt(string);
				shopService.putawayShop(shopId);
			}
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("shopTypeName", shopTypeName);
		model.addAttribute("shopState", shopState);
		model.addAttribute("shopName", shopName);
		model.addAttribute("shopTitle", shopTitle);
		return "redirect:shopList";
	}

	// 根据商品Id删除轮播图
	public void DeleteShopSwiperImgs(Integer shopId, HttpServletRequest request) {

		List<ShopSwiper> shopSwireList = shopSwiperService.selectShopSwiperByShopId(shopId);

		if (shopSwireList.size() != 0) {

			for (ShopSwiper swireimg : shopSwireList) {
				String urlString = swireimg.getShopswiperimg();
				if (urlString != null && !"".equals(urlString)) {
					deleteLocalHostResources(urlString, request);
				}
			}
		}
		shopService.deleteShopSwiperImg(shopId);
	}

	// 根据商品SKUId删除轮播图
	public void DeleteSKUSwiperImgs(Integer shopSkuId, HttpServletRequest request) {

		List<ShopSkuSwiper> ShopSkuSwireList = shopSkuSwiperService.selectShopSkuId(shopSkuId);

		if (ShopSkuSwireList.size() != 0) {

			for (ShopSkuSwiper skuswireimg : ShopSkuSwireList) {

				String urlString = skuswireimg.getShopSkuSwiperUrl();
				if (urlString != null && !"".equals(urlString)) {
					deleteLocalHostResources(urlString, request);
				}
			}
		}
		shopSkuSwiperService.deleteShopSkuSwireBySkuid(shopSkuId);
	}

	// 根据请求删除本地图片
	public void deleteLocalHostResources(String URL, HttpServletRequest request) {
		String requestUrl = request.getScheme() // 当前链接使用的协议
				+ "://" + request.getServerName()// 服务器地址
				+ "RegistCompanyIMG/";
		String qzz = request.getSession().getServletContext().getRealPath("/");
		qzz = qzz.replace("Svip", "RegistCompanyIMG");
		String hz = URL.substring(requestUrl.length() + 1);
		String allUrl = qzz + hz;
		File targetFile = new File(allUrl);
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

}
