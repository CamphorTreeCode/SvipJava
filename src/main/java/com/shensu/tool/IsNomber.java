package com.shensu.tool;

import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

/**
* @Title: IsNomber.java
 * @Prject: LFXCX
 * @Package: com.dk.util
 * @Description: TODO
 * @author: lichenglong
 * @date: 2017年3月24日 下午4:34:44
 * @version: V1.0  
 */
public class IsNomber {

	//
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		  
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
 
	//过滤特殊字符的方法：
	public static  String removeEmojiUnicode(String str)
	    {
	        if (str == null)
	        {
	            return null;
	        }
	        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
	        return str;
	    }

//	转换编码：将utf转换iso-8859-1

	public static  String encodeString(String value)
	    {
	        String retval = null;
	        try
	        {
	            retval = new String(value.getBytes("utf-8"), "ISO-8859-1");
	        } catch (UnsupportedEncodingException e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return retval;
	    }
	//将编码转换utf-8
	public static String decodeString(String value)
    {
        String retval = null;
        try
        {
            retval = new String(value.getBytes("ISO-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retval;
    }
public static void main(String[] args) {
	
	System.out.println(IsNomber.removeEmojiUnicode("你%你🍀"));
	System.out.println(IsNomber.decodeString(IsNomber.encodeString("你%你🍀")));
	
}
//经纬度转换
public static String getAdd(String log, String lat ){  
    //lat 小  log  大  
    //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)  
    String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";  
    String res = "";     
    try {     
        URL url = new URL(urlString);    
        java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();    
        conn.setDoOutput(true);    
        conn.setRequestMethod("POST");    
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));    
        String line;    
       while ((line = in.readLine()) != null) {    
           res += line+"\n";    
     }    
        in.close();    
    } catch (Exception e) {    
        System.out.println("error in wapaction,and e is " + e.getMessage());    
    }   
    System.out.println(res);  
    return res;    
}

private static boolean isEmojiCharacter(char codePoint) {
    return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
            || (codePoint == 0xD)
            || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
            || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
            || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
}

//过滤特殊字符串
public static String filterEmoji(String source) {
  if (StringUtils.isBlank(source)) {
      return source;
  }
  StringBuilder buf = null;
  int len = source.length();
  for (int i = 0; i < len; i++) {
      char codePoint = source.charAt(i);
      if (isEmojiCharacter(codePoint)) {
          if (buf == null) {
              buf = new StringBuilder(source.length());
          }
          buf.append(codePoint);
      }
  }
  if (buf == null) {
      return source;
  } else {
      if (buf.length() == len) {
          buf = null;
          return source;
      } else {
          return buf.toString();
      }
  }

}


}
