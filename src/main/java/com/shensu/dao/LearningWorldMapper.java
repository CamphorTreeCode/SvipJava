package com.shensu.dao;

import java.util.HashMap;
import java.util.List;

import com.shensu.pojo.Fabulous;
import com.shensu.pojo.LearningWorld;

public interface LearningWorldMapper {

    int deleteByPrimaryKey(Integer learningworldid);

    int insert(LearningWorld record);

    int insertSelective(LearningWorld record);

    LearningWorld selectByPrimaryKey(Integer learningworldid);

    int updateByPrimaryKeySelective(LearningWorld record);

    int updateByPrimaryKeyWithBLOBs(LearningWorld record);

    int updateByPrimaryKey(LearningWorld record);
    
    //根据条件分页查询学习天地正式发布列表
    List<LearningWorld> selectByIssueCondition(HashMap<String,Object> map);
    
    //根据条件查正式发布列表总数
    int selectCountByIssueCondition(HashMap<String,Object> map);
    
    //根据条件分页查询学习天地草稿箱列表
    List<LearningWorld> selectByDraftCondition(HashMap<String,Object> map);
    
    //根据条件查草稿箱列表总数
    int selectCountByDraftCondition(HashMap<String,Object> map);
    
  //学习天地设置上架状态
  	int putawayLearningWorld(int learningWorldId);
  	
  	//学习天地设置下架状态
  	int unshelveLearningWorld(int learningWorldId);
  	
  	//根据学习天地id删除一条信息
	int deleteLearningWorld(int learningWorldId);
  	
  	//学习天地修改一条信息
	
	//学习天地增加一条信息
  	
  	//草稿箱设置上架状态(发布到学习天地)
  	int putawayLearningWorldDraft(int learningWorldId);
  	
  	//草稿箱修改一条信息
  	
	//查询学习天地全部列表(小程序)
	List<LearningWorld> findLearningList();
	
	//查询学习天地详细信息(小程序)
	LearningWorld findLearningDetails(int learningWorldId);
	
	//查询学习天地文章的浏览量(小程序)
	int getLearningWorldBrowse(int learningWorldId);
	
	//浏览量加1(小程序)
	int updateLearningWorldBrowse(int newBrowse);
	
	//学习天地详情页点赞(小程序)
	int addLearningFabulous(Integer learningWorldId);
	
	//查询学习天地列表的全部id
	List<LearningWorld> findLearningId();
	

	//查询学习天地的第一条
	int selectcountLW();
   //分页查询学习天的集合 （小程序）
	List<LearningWorld> selectLWlList(HashMap<String, Object> map);
  //增加学习天地文章的转发量
	int addShare(LearningWorld learningWorld);
	
	

	//学习天地查询一条信息的全部内容
	LearningWorld HXLearningWorldDetails(int learningWorldId);

}