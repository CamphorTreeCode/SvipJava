package com.shensu.tool;

import net.sf.json.JSONObject;

/**获取用户的openid
* @Title: GetOpenId.java
 * @Prject: LFXCX
 * @Package: com.dk.util
 * @Description: TODO
 * @author: lichenglong
 * @date: 2017年3月10日 下午8:05:02
 * @version: V1.0  
 */
public class GetOpenId {
	//小程序的appid和sercet和URL

   public static String openidUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=APPSECRET&js_code=JS_code&grant_type=authorization_code";	

	/**
	 * 获取小程序的openid
	 * @Title: getOpenid
	 * @Description: TODO
	 * @param jscode
	 * @return
	 * @return: String 
	 */
    public static String getOpenid(String jscode){
    	String openid=null;
    	String open_id=null;
    	String requestUrl = openidUrl.replace("APPID",UpdataName.appid).replace("APPSECRET",UpdataName.secret).replace("JS_code",jscode);
    	System.out.println(requestUrl);
    	try {
    		openid = new HttpRequestor().doGet(requestUrl);
		   System.out.println("恭喜你"+openid);//X89krA0150ns82
	      JSONObject oppidObj =JSONObject.fromObject(openid);
	      String access_token = (String) oppidObj.get("session_key");
	      System.out.println("access_token:"+access_token);
          open_id = (String) oppidObj.get("openid");
          System.out.println(">>>>>>>>>>openid:"+open_id);      
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return open_id;
    	
    }
}
