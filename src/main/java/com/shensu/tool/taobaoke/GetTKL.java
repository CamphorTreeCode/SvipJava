package com.shensu.tool.taobaoke;

import java.util.HashMap;
import java.util.Map;

import com.shensu.tool.UpdataName;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkTpwdCreateResponse;

public class GetTKL {
	
public static String tklurl = "https://uland.taobao.com/coupon/edetail?";

public static TbkTpwdCreateResponse Tkl(String shopUrl,String shopDiscountUrl,String pid,String shopLogoUrl) throws ApiException{

	System.out.println(urlSplit(shopDiscountUrl));
	System.out.println(urlSplit(shopUrl));
    System.out.println(pid);
	System.out.println(tklurl+"activityId="+urlSplit(shopDiscountUrl).get("activityid")+"&itemId="+urlSplit(shopUrl).get("id")+"&pid="+pid+"&dx=1&src=cs_cswz");
	TaobaoClient client = new DefaultTaobaoClient(UpdataName.tburl, UpdataName.tbappkey, UpdataName.tbsecret);
	TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
//	String requestUrl = tklurl.replace("ActivityId",UpdataName.appid).replace("APPSECRET",UpdataName.secret).replace("JS_code",jscode);
	req.setUserId("");
	req.setText("优惠商城小程序淘口令");
	//req.setText("超级vip小程序淘口令");
	req.setUrl(tklurl+"activityId="+urlSplit(shopDiscountUrl).get("activityid")+"&itemId="+urlSplit(shopUrl).get("id")+"&pid="+pid+"&dx=1&src=tkm_tkmwz");
	req.setLogo(shopLogoUrl);
	req.setExt("{}");
	TbkTpwdCreateResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());
	return rsp;

}
/*
* 去掉url中的路径，留下请求参数部分
* @param strURL url地址
* @return url请求参数部分
* @author lzf
*/
private static String TruncateUrlPage(String strURL){
   String strAllParam=null;
   String[] arrSplit=null;
   strURL=strURL.trim().toLowerCase();
   arrSplit=strURL.split("[?]");
   if(strURL.length()>1){
     if(arrSplit.length>1){
         for (int i=1;i<arrSplit.length;i++){
             strAllParam = arrSplit[i];
         }
     }
   }
   return strAllParam;   
}

/**
* 解析出url参数中的键值对
* 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
* @param URL  url地址
* @return  url请求参数部分
* @author lzf
*/
public static Map<String, String> urlSplit(String URL){
   Map<String, String> mapRequest = new HashMap<String, String>();
   String[] arrSplit=null;
   String strUrlParam=TruncateUrlPage(URL);
   if(strUrlParam==null){
       return mapRequest;
   }
   arrSplit=strUrlParam.split("[&]");
   for(String strSplit:arrSplit){
         String[] arrSplitEqual=null;         
         arrSplitEqual= strSplit.split("[=]");
         //解析出键值
         if(arrSplitEqual.length>1){
             //正确解析
             mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
         }else{
             if(arrSplitEqual[0]!=""){
             //只有参数没有值，不加入
             mapRequest.put(arrSplitEqual[0], "");       
             }
         }
   }   
   return mapRequest;   
}
public static void main(String[] args) {
	try {
		//GetTKL.Tkl("https://detail.tmall.com/item.htm?id=535018584722","https://uland.taobao.com/quan/detail?sellerId=2455066042&activityId=35e2f7dc2fd54f30bacdcb872b985ce0","mm_47879448_33192231_144446436");
	} catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}

}
