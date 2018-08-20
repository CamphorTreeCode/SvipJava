package com.shensu.service;

import com.shensu.pojo.Template;

/**
 * 
 * @author YUKI 
 * 接口
 */
//接口
public interface TemplateService {
    //更新模版小程序
	public int updateTemplate(Template t);
	//转发小程序定时器
	public Template selectTemplate(Template t);
	 
}
