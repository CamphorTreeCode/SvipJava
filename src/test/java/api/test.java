package api;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgItemCouponGetRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkDgItemCouponGetResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;

public class test {

//*****

 

String url = "https://eco.taobao.com/router/rest";
//String url = "http://gw.api.taobao.com/router/rest";
//"mtop.alimama.union.hsf.coupon.get
//https://gw.api.tbsandbox.com/router/rest
String appkey = "24881954";

String secret = "b77be4246bbc86f526d3ad76008bad46";

TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

//根据条件查询-获取淘宝客商品列表

public TbkItemGetResponse getTBKlistFor(){

TbkItemGetResponse rsp = null;

TbkItemGetRequest req = new TbkItemGetRequest();

req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");

req.setQ("香薰瓶");

 
/*req.setQ("女装");

req.setCat("16,18");

req.setItemloc("杭州");

req.setSort("tk_rate_des");

req.setIsTmall(false);

req.setIsOverseas(false);

req.setStartPrice(10L);

req.setEndPrice(10L);

req.setStartTkRate(123L);

req.setEndTkRate(123L);

req.setPlatform(1L);

req.setPageNo(123L);

req.setPageSize(20L);*/
 
try {

rsp = client.execute(req);

} catch (ApiException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

return rsp;

}

public TbkDgItemCouponGetResponse tbkGoodLinkSerch() throws ApiException{

//TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
//
//req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
//
//req.setNumIid(24337872166L);
//
//req.setCount(20L);
//
//req.setPlatform(1L);
//
//TbkItemRecommendGetResponse rsp =null;
//
//try {
//
//rsp = client.execute(req);
//
//} catch (ApiException e) {
//
//// TODO Auto-generated catch block
//
//e.printStackTrace();
//mtop.alimama.union.hsf.coupon.get
//}
	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
	TbkDgItemCouponGetRequest req = new TbkDgItemCouponGetRequest();
	
	req.setAdzoneId((long) 576624485);
	req.setPlatform(1L);
	req.setCat("16,18");
	req.setPageSize(1L);
	req.setQ("女装");
	req.setPageNo(1L);
	TbkDgItemCouponGetResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());

 return rsp;

}

public TbkTpwdCreateResponse Tkl() throws ApiException{

	//TbkItemRecommendGetRequest req = new TbkItemRecommendGetRequest();
	//
	//req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url");
	//
	//req.setNumIid(24337872166L);
	//
	//req.setCount(20L);
	//
	//req.setPlatform(1L);
	//
	//TbkItemRecommendGetResponse rsp =null;
	//
	//try {
	//
	//rsp = client.execute(req);
	//
	//} catch (ApiException e) {
	//
	//// TODO Auto-generated catch block
	//
	//e.printStackTrace();
	//https://uland.taobao.com/coupon/edetail?activityId=95c64c69455c4e7fbc8afc79cf3b4584https&itemId=538393099512&pid=mm_47879448_45034244_576624485&src=toolla
	//}
	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
	TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
	req.setUserId("");
	req.setText("长度大于5个字符");
	req.setUrl("https://uland.taobao.com/coupon/edetail?activityId=35e2f7dc2fd54f30bacdcb872b985ce0&itemId=535018584722&pid=mm_47879448_33192231_144446436&dx=1&src=tkm_tkmwz");
	req.setLogo("");
	req.setExt("{}");
	TbkTpwdCreateResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());

	return rsp;

	 

	}

public static void main(String[] args) {

// TODO Auto-generated method stub http:\/\/detail.tmall.com\/item.htm?id=527199234576
//https:\/\/uland.taobao.com\/coupon\/edetail?e=O6TtIkt4JsMGQASttHIRqbTV3peCk3nCNXeEGZofcMGAnVXUwZx8Imd1IM9OlHjcrfXzI0%2BvJ1S1734wEbVIDm%2B%2FESVbdzaj819cieM8MLZsMznsgPr758%2FU93frNBIqupOefM1dKDN9FeiLa1YR%2BlhAmztsbMhPiKciRKGYNAdIH07HK3v5wExB%2Fd6dHleqRULWJ223mfA%3D&traceId=0be537df15265285061788801e
test t = new test();
//System.out.println(t.getTBKlistFor().getBody());
try {
	System.out.println(t.tbkGoodLinkSerch().getBody());
	System.out.println(t.Tkl().getBody());
} catch (ApiException e) {
	// TODO 自动生成的 catch 块
	e.printStackTrace();
}

}

 

}