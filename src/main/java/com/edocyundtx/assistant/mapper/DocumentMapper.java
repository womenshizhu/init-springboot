package com.edocyundtx.assistant.mapper;

import com.edocyundtx.assistant.entity.Document;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


/**
 * Description:
 * Author:   Jack.Li
 * Time:     2021/4/23 15:03
 * Version:  1.0.0
 */

@Mapper
@Component
public interface DocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);
}