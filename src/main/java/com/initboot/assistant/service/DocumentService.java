package com.initboot.assistant.service;

import com.initboot.assistant.entity.Document;

/**
 * Description:
 * Author:   Jack.Li
 * Time:     2021/4/23 15:03
 * Version:  1.0.0
 */

public interface DocumentService {


    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);

}
