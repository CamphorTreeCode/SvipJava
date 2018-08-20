package com.shensu.dao;

import com.shensu.pojo.LearningWorldImg;

public interface LearningWorldImgMapper {

    int deleteByPrimaryKey(Integer learningworldimgid);

    int insert(LearningWorldImg record);

    int insertSelective(LearningWorldImg record);

    LearningWorldImg selectByPrimaryKey(Integer learningworldimgid);

    int updateByPrimaryKeySelective(LearningWorldImg record);

    int updateByPrimaryKey(LearningWorldImg record);
    
}