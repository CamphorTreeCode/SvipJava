package com.shensu.service.impl;

import java.util.HashMap;
import java.util.List;
import com.shensu.pojo.LearningWorld;
import com.shensu.service.LearningWorldService;
import com.shensu.tool.Page;

/**
 * 
 *@author YUKI
 *实现的方法
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shensu.dao.LearningWorldMapper;
import com.shensu.pojo.Fabulous;
import com.shensu.pojo.LearningWorld;
import com.shensu.service.LearningWorldService;
import com.shensu.tool.Page;

@Service("LearningWorldService")
public class LearningWorldServiceImpl implements LearningWorldService {
	
	@Autowired
	LearningWorldMapper learningWorldMapper;
	
	//分业查询学习天地正式发布列表
	@Override
	public Page<LearningWorld> selectByIssueCondition(int currentPage,String learningWorldCreatTime) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("learningWorldCreatTime", learningWorldCreatTime);
		Page<LearningWorld> pageBean = new Page<LearningWorld>();
		//封装当前页数
		pageBean.setCurrPage(currentPage);
		//每页显示的数据
		int pageSize=10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = learningWorldMapper.selectCountByIssueCondition(map1);
		pageBean.setTotalCount(totalCount);
		//System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("learningWorldCreatTime", learningWorldCreatTime);
		//封装每页显示的数据
		List<LearningWorld> lists = learningWorldMapper.selectByIssueCondition(map);
		pageBean.setLists(lists);
		return pageBean;
	}
	
	//分页查询学习天地草稿箱列表
	@Override
	public Page<LearningWorld> selectByDraftCondition(int currentPage,String learningWorldCreatTime) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		HashMap<String,Object> map1 = new HashMap<String,Object>();
		map1.put("learningWorldCreatTime", learningWorldCreatTime);
		Page<LearningWorld> pageBean = new Page<LearningWorld>();
		//封装当前页数
		pageBean.setCurrPage(currentPage);
		//每页显示的数据
		int pageSize=10;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = learningWorldMapper.selectCountByDraftCondition(map1);
		pageBean.setTotalCount(totalCount);
		//System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
		map.put("learningWorldCreatTime", learningWorldCreatTime);
		//封装每页显示的数据
		List<LearningWorld> lists = learningWorldMapper.selectByDraftCondition(map);
		pageBean.setLists(lists);
		return pageBean;
	}
	
	//学习天地设置上架状态
	@Override
	public int putawayLearningWorld(int learningWorldId) {
		return learningWorldMapper.putawayLearningWorld(learningWorldId);
	}
	
	//学习天地设置下架状态
	@Override
	public int unshelveLearningWorld(int learningWorldId) {
		return learningWorldMapper.unshelveLearningWorld(learningWorldId);
	}
	
	//草稿箱设置上架状态(发布到学习天地)
	@Override
	public int putawayLearningWorldDraft(int learningWorldId) {
		return learningWorldMapper.putawayLearningWorldDraft(learningWorldId);
	}
	
	//根据学习天地id删除一条信息
	@Override
	public int deleteLearningWorld(int learningWorldId) {
		return learningWorldMapper.deleteLearningWorld(learningWorldId);
	}
	
	//查询学习天地全部列表(小程序)
	@Override
	public Page<LearningWorld> findLearningList(int currentPage) {

		
		HashMap<String,Object> map = new HashMap<String,Object>();
		//HashMap<String,Object> map1 = new HashMap<String,Object>();
	
		Page<LearningWorld> pageBean = new Page<LearningWorld>();
		//封装当前页数
		pageBean.setCurrPage(currentPage);
		//每页显示的数据
		int pageSize=6;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = learningWorldMapper.selectcountLW();
		pageBean.setTotalCount(totalCount);
		//System.out.println(totalCount);
		//封装总页数
		double tc = totalCount;
		Double num =Math.ceil(tc/pageSize);//向上取整
		pageBean.setTotalPage(num.intValue());
		map.put("start",(currentPage-1)*pageSize);
		map.put("size", pageBean.getPageSize());
	
		//封装每页显示的数据
		List<LearningWorld> lists = learningWorldMapper.selectLWlList(map);
		pageBean.setLists(lists);
		return pageBean;
	
		//return learningWorldMapper.findLearningList();
	}
	
	//查询学习天地详细信息(小程序)
	@Override
	public LearningWorld findLearningDetails(int learningWorldId) {
		//取出浏览量数据
//		int Browse = learningWorldMapper.getLearningWorldBrowse(learningWorldId);
//		int NewBrowse = Browse + 1;
		learningWorldMapper.updateLearningWorldBrowse(learningWorldId);
		
		return learningWorldMapper.findLearningDetails(learningWorldId);
	}
	
	//学习天地详情页点赞
	@Override
	public int addLearningFabulous(Integer learningWorldId) {
		
		return learningWorldMapper.addLearningFabulous(learningWorldId);
	}

	//增加学习天地
	@Override
	public int insertLearningWorld(LearningWorld lw) {
		// TODO 自动生成的方法存根
	  return learningWorldMapper.insertSelective(lw);
	}
    //修改学习天地
	@Override
	public int updataLearningWorld(LearningWorld lw) {
		// TODO 自动生成的方法存根
		return learningWorldMapper.updateByPrimaryKeySelective(lw);
	}
    //删除学习天地
	@Override
	public int delectLearningWorld(LearningWorld lw) {
		// TODO 自动生成的方法存根
		return 0;
	}
	//学习天地的分页查询
	@Override
	public Page<LearningWorld> selectAllLearningWorld() {
//		HashMap<String,Object> map = new HashMap<String,Object>();
//        Page<LearningWorld> pageBean = new Page<LearningWorld>();
//        //封装当前页数
//        pageBean.setCurrPage(currentPage);
//        //每页显示的数据
//        int pageSize=3;
//        pageBean.setPageSize(pageSize);
//        //封装总记录数
//        int totalCount = bcm.selectCount();
//        pageBean.setTotalCount(totalCount);
//        System.out.println(totalCount);
//        //封装总页数
//        double tc = totalCount;
//        Double num =Math.ceil(tc/pageSize);//向上取整
//        pageBean.setTotalPage(num.intValue());
//        System.out.println(bcy);
//        System.out.println(bcy.getBusinessCompany());
//        System.out.println(bcy.getBusinessCompanyRegion()!=null);
//        System.out.println(bcy.getBusinessCompany()!=null);
//        System.out.println(bcy.getBusinessCompanyAccount()!=null);
//        map.put("businessCompanyRegion",bcy.getBusinessCompanyRegion());
//        map.put("businessCompany",bcy.getBusinessCompany());
//        map.put("businessCompanyPayTaxes",bcy.getBusinessCompanyPayTaxes());
//        map.put("businessCompanyAccount",bcy.getBusinessCompanyAccount());
//        map.put("businessCompanyIndustry",bcy.getBusinessCompanyIndustry());
//        map.put("start",(currentPage-1)*pageSize);
//        map.put("size", pageBean.getPageSize());
//        //封装每页显示的数据
//        List<BusinessCompany> lists = bcm.findByPage(map);
//        pageBean.setLists(lists);
//
//        return pageBean;
	     	return null;
	}
	
	//查询学习天地列表的全部id
	@Override
	public List<LearningWorld> findLearningId() {
		return learningWorldMapper.findLearningId();
	}

    //学习天地增加分享的功能 小程序
	@Override
	public int addShare(LearningWorld learningWorld) {
		// TODO 自动生成的方法存根
		return learningWorldMapper.addShare(learningWorld);
	}
	//学习天地查询一条信息的全部内容
	@Override
	public LearningWorld HXLearningWorldDetails(int learningWorldId) {
		
		return learningWorldMapper.HXLearningWorldDetails(learningWorldId);

	}
}
