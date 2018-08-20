package com.shensu.controller;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.shensu.pojo.Data;
import com.shensu.pojo.Refund;
import com.shensu.pojo.Template2;
import com.shensu.pojo.Transfers;
import com.shensu.pojo.keyword;
import com.shensu.service.RefundService;
import com.shensu.tool.DateTime;
import com.shensu.tool.HttpRequestor;
import com.shensu.tool.Page;
import com.shensu.tool.PayUtil;
import com.shensu.tool.Token;
import com.shensu.tool.UpdataName;
import com.shensu.tool.UrlHelper;
import com.thoughtworks.xstream.XStream;
@Controller
@RequestMapping("admin/refund")
public class RefundController {
	
	
	@Autowired
	RefundService RefundService;
	
	@RequestMapping("list")
	public String list(@RequestParam(value = "currentPage" , defaultValue = "1")int currentPage, Refund refund,HttpServletRequest request){
		
		Page<Refund> refundPage = RefundService.findListCondition(currentPage, refund);
		
		System.out.println(refundPage.getLists().size());
		
		request.setAttribute("refundPage", refundPage);
		
		request.setAttribute("name",refund.getName());
		
		request.setAttribute("phone", refund.getPhone());
		
		request.setAttribute("refundState", refund.getRefundState());
		
		return "refund/listRefund";
	}

	@RequestMapping("add")
	@ResponseBody
	public String addRefund(Refund refund){
		
		refund.setRefundCreateTime(DateTime.getDate());
		
		int num = RefundService.addRefund(refund);
		
		return num+"";
	}
	@Token(save=true)
	@RequestMapping("updata")
	public String updata(int refundId,HttpServletRequest request){
		
		Refund refund = RefundService.findByRefundId(refundId);
		
        request.setAttribute("refund", refund);
		
		return "refund/auditRefund";
	}
	
	//退款(企业打款方式)
	@Token(remove=true)
	@ResponseBody
	@RequestMapping("refund")
	public String refund(Refund refund) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PayUtil payutil = new PayUtil();
		Transfers t = new Transfers();
		t.setMch_appid(UpdataName.appid);
		t.setMchid(UpdataName.mch_id);
		t.setNonce_str(payutil.createRandom(32));
		String partner_trade_no = payutil.getOrderNum();
		t.setPartner_trade_no(partner_trade_no);
		t.setOpenid(refund.getOpenId());
		t.setCheck_name("NO_CHECK");
		t.setAmount((int)(refund.getMoney()*100));
		t.setDesc("协议退款");
		t.setSpbill_create_ip(InetAddress.getLocalHost().getHostAddress());
		String sign=payutil.createSign(t, UpdataName.key);
		t.setSign(sign);
		XStream xStream = new XStream();
		xStream.alias("xml", Transfers.class);
		String xml = xStream.toXML(t);
		xml=xml.replace("__", "_");
		System.out.println(xml);
		String a=payutil.ssl("https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers", xml);
		
		System.out.println(a);
		
		Document dom = DocumentHelper.parseText(a);
		Element root = dom.getRootElement();
		String returnCode = root.element("result_code").getText();
		if( StringUtils.equals(returnCode, "SUCCESS")){
			refund.setPartner_trade_no(partner_trade_no);
			refund.setRefundState(2);
			int num = RefundService.updateRefund(refund);
			String payment_no = root.element("payment_no").getText(); // 获取支付流水号
			String payment_time = root.element("payment_time").getText(); // 获取支付时间
			map.put("state", returnCode);
			map.put("payment_no", payment_no);
			map.put("payment_time", payment_time);
		}
		else {
			String err_code = root.element("err_code").getText(); // 获取错误代码
			String err_code_des = root.element("err_code_des").getText();// 获取错误描述
			map.put("state", returnCode);// state
			map.put("err_code", err_code);// err_code
			map.put("err_code_des", err_code_des);// err_code_des
			
		}
		
		System.out.println(map);
		String jsonobject = JSONObject.toJSONString(map);
		
		return jsonobject;
	}
	
	
	@RequestMapping("noPass")
	public String noPass(Refund refund) throws Exception{
		
		RefundService.updateRefund(refund);
		HttpRequestor httpRequestor = new HttpRequestor();
		String result=httpRequestor.doGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + UpdataName.appid
				+ "&secret=" + UpdataName.secret + "");
		JSONObject access = JSONObject.parseObject(result);
		

		
		Template2 template = new Template2();
		
		template.setTouser( refund.getOpenId() );
		
		template.setTemplate_id(UpdataName.template3);		
	    
		template.setPage("pages/index/index");
		
		template.setForm_id( refund.getFormId() );
		
		template.setData(new Data(new keyword(refund.getName()), new keyword("协议退款"), new keyword("您的申请和商议内容不符合，请在‘我的’页面中联系客服询问详情。")));
		
		String result2 = UrlHelper.postResult("https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+access.get("access_token")+"", template);
		System.out.println(result2);
		
		
		return "redirect:list";
	}
	
	
	@RequestMapping("delete")
	public String delete(int refundId){
		RefundService.deleteRefund(refundId);
		return "redirect:list";
	}

}
