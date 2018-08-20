package api;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;  
import java.net.URL;  
import java.net.URLConnection;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
public class WebSpider {  
    public static void main(String[] args) {  
        URL url = null;  
        URLConnection urlconn = null;  
        BufferedReader br = null;  
        PrintWriter pw = null;  
       // String regex = "http://[\\w+\\.?/?]+\\.[A-Za-z]+";  <img.*src=(.*?)[^>]*?>"
        String regex = "<img.*src=(.*?)[^>]*?>";
        Pattern p = Pattern.compile(regex);  
        for (int i = 0; i <100; i++) {
		
			
	
        try {  
            url = new URL("http://www.66xh.com/tupian/"+(27027+i)+".html");  
            urlconn = url.openConnection();  
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:\\url.txt",true), "UTF-8"));//这里我们把收集到的链接存储在了E盘底下的一个叫做url的txt文件中  
            br = new BufferedReader(new InputStreamReader(  
                    urlconn.getInputStream()));  
            System.out.println(br);
            System.out.println(br.lines());
            String buf = null;  
            while ((buf = br.readLine()) != null) {
          
                Matcher buf_m = p.matcher(buf);  
                while (buf_m.find()) {  
                    pw.println(buf_m.group());  
                }  
            }  
            System.out.println("获取成功！");  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                br.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            pw.close();  
        } 
        }
    }  
}  