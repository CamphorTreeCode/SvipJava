package com.shensu.service;


import com.shensu.pojo.LearningWorld;
import com.shensu.tool.Page;

/**
 * 
 * @author YUKI
 *学习天地的service
 */


import java.util.List;

import com.shensu.pojo.Fabulous;
import com.shensu.pojo.LearningWorld;
import com.shensu.tool.Page;

public interface LearningWorldService {
	
	//分业查询学习天地正式发布列表
	Page<LearningWorld> selectByIssueCondition(int currentPage,String learningWorldCreatTime);
	
	//分页查询学习天地草稿箱列表
	Page<LearningWorld> selectByDraftCondition(int currentPage,String learningWorldCreatTime);
	
	//学习天地设置上架状态
	int putawayLearningWorld(int learningWorldId);
	
	//学习天地设置下架状态
	int unshelveLearningWorld(int learningWorldId);
	
	//根据学习天地id删除一条信息
	int deleteLearningWorld(int learningWorldId);
	
	//学习天地修改一条信息
	
	//草稿箱设置上架状态(发布到学习天地)
	int putawayLearningWorldDraft(int learningWorldId);
	
	//草稿箱修改一条信息
	
	//添加学习天地信息
	
	//学习天地查询一条信息的全部内容
	LearningWorld HXLearningWorldDetails(int learningWorldId);
	
	
	//查询学习天地全部列表(小程序)
	Page<LearningWorld> findLearningList(int currentPage);
	
	//查询学习天地详细信息(小程序)
	LearningWorld findLearningDetails(int learningWorldId);
	
	//查询学习天地列表的全部id
	List<LearningWorld> findLearningId();
	
	
	//学习天地详情页点赞(小程序)
	int addLearningFabulous(Integer learningWorldId);
    //增加学习天地
    public int insertLearningWorld(LearningWorld lw);
	//修改学习天地
    public int updataLearningWorld(LearningWorld lw);
	//更加id来删除学习天地
    public int delectLearningWorld(LearningWorld lw);
     //学习天地的分页 小程序
	public Page<LearningWorld> selectAllLearningWorld();
   //学习天地增加转发的功能
	int addShare(LearningWorld learningWorld);
	
}

