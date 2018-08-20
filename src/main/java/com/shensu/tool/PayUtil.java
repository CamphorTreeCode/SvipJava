package com.shensu.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;






public class PayUtil {
	
	/**
	 * 生成随机字符串
	 * @param length
	 * @return
	 */
	public  String createRandom(int length){
		
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(base.length());
			sb.append(base.charAt(num));
		}
		
		return sb.toString();
		
	}
	
	
	
	
	
	/**
	 * 生成签名
	 * @param o 传入对象
	 * @param keycode   小程序秘钥
	 * @return
	 * @throws Exception
	 */
	public  String createSign(Object o, String keycode) throws Exception{
		Map map =new HashMap<String, Object>();
		
		StringBuffer sb =new StringBuffer();
		
		Class classobj = o.getClass();
		
		Field[] fields = classobj.getDeclaredFields();
		
		for (Field f : fields) {
			f.setAccessible(true);
			if(f.get(o) != null  && f.get(o) != ""){
				
				map.put(f.getName(), f.get(o));
				
			}
			
		}
		
		List<String> list = new ArrayList<String>(map.keySet());
		
		Collections.sort(list);
		
		for (String l : list) {
			sb.append(l+ "=" +map.get(l)+"&");
		}
		
		String parameterList = sb.toString();
		
		parameterList += "key=" + keycode;
		
        StringBuffer result = new StringBuffer();
		
		 MessageDigest MD5 = MessageDigest.getInstance("MD5");
		 
		 
		 byte[] byteList = MD5.digest(parameterList.getBytes("UTF-8"));
		 
		 for (byte b : byteList) {
			 result.append(byteToHexString(b));
		}
		 
		return result.toString().toUpperCase();
	}
	
	/**
	 * 将字符转为16进制
	 */
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};
	private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
	
	
	
	public  String  ssl(String url, String data){
		
		StringBuffer message = new StringBuffer();
		CloseableHttpResponse response = null;
		CloseableHttpClient httpclient = null;
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			
			FileInputStream in = new FileInputStream(new File(this.getClass().getClassLoader().getResource("apiclient_cert.p12").getPath()));//"D:/cert/apiclient_cert.p12"
			
			keyStore.load(in, UpdataName.mch_id.toCharArray());
			
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, UpdataName.mch_id.toCharArray()).build();
			
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext,
					new String[]{"TLSv1"},
					null,
					SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			
		    httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			
			HttpPost httpost = new HttpPost(url);
			httpost.addHeader("Connection", "keep-alive");
            httpost.addHeader("Accept", "*/*");
            httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpost.addHeader("Host", "api.mch.weixin.qq.com");
            httpost.addHeader("X-Requested-With", "XMLHttpRequest");
            httpost.addHeader("Cache-Control", "max-age=0");
            httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
            httpost.setEntity(new StringEntity(data, "UTF-8"));
            
            response = httpclient.execute(httpost);
            
            HttpEntity entity = response.getEntity();
            
            if(entity != null){
            	BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"));
            	String text;
            	while ((text = bufferedreader.readLine()) != null) {
                    message.append(text);
                }
            	
            }
            EntityUtils.consume(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(response != null){
					response.close();
				}
				if(httpclient != null){
					httpclient.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return message.toString();
	} 
	
	
	public  String getOrderNum(){
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String strDate = sfDate.format(new Date());
		//得到17位时间如：20170411094039080
		System.out.println("时间17位：" + strDate);
		//为了防止高并发重复,再获取3个随机数
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			int num = random.nextInt(9);
			sb.append(num);
		}
		
		//最后得到20位订单编号。
		System.out.println("订单号20位：" + strDate + random);
		return strDate + sb;
	
 }
	
}
