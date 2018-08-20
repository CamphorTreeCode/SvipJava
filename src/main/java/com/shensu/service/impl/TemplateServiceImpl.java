package com.shensu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shensu.dao.TemplateMapper;
import com.shensu.pojo.Template;
import com.shensu.service.TemplateService;

/**
 * 
 * @author YUKI
 * 微信小程序的模版实现层
 */
@Service("TemplateService")
public class TemplateServiceImpl  implements  TemplateService{
	
	@Autowired
	TemplateMapper templateMapper;
	
	/**
	 *  更新信息模版消息
	 * @return 
	 */
	@Override
	public int updateTemplate(Template t) {
	    return templateMapper.updateTemplate(t);
		  
	}
	
	
	/**
	 * 查询的模板的方法
	 * @return 
	 */
	@Override
	public Template selectTemplate(Template t) {
		System.out.println(t.getTemplateid());
		// TODO 自动生成的方法存根 
        //查询出模版的消息
		return templateMapper.selectTemplate(t);		
	}

	
	


}
