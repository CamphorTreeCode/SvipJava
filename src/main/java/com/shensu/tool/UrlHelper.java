package com.shensu.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

public class UrlHelper {
	
	
	public static String postResult(String url ,Object o) throws IOException {
		
		URL Url = new URL(url);//参数1
		
		HttpURLConnection HttpURLConnection = (HttpURLConnection) Url.openConnection();
		
		HttpURLConnection.setRequestMethod("POST");//参数2
		
		HttpURLConnection.setDoOutput(true);
		
		HttpURLConnection.setDoInput(true);
		
		HttpURLConnection.setRequestProperty("Content-type", "application/json;charset=UTF-8"); 
		
		HttpURLConnection.connect();
		
        
        OutputStreamWriter out = new OutputStreamWriter(HttpURLConnection.getOutputStream(), "UTF-8"); 
       
        
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(o);
        
        System.out.println(jsonObject);
        
        out.write(jsonObject.toString());
        
        out.flush();
        
        
		StringBuffer bf = new StringBuffer();
		
		InputStream inputStream = HttpURLConnection.getInputStream();
		
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
		
		BufferedReader BufferedReader = new BufferedReader(inputStreamReader);
		
		String line = null;
		
		while((line = BufferedReader.readLine()) != null) {
			
			bf.append(line);
			
		}
		
		out.close();
		
		inputStream.close();
		
		inputStreamReader.close();
		
		BufferedReader.close();
		
		String result = bf.toString();
		
		return result;
	}

}
