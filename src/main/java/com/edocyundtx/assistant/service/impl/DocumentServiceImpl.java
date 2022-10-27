package com.edocyundtx.assistant.service.impl;

import com.edocyundtx.assistant.entity.Document;
import com.edocyundtx.assistant.mapper.DocumentMapper;
import com.edocyundtx.assistant.service.DocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 * Author:   Jack.Li
 * Time:     2021/4/23 15:03
 * Version:  1.0.0
 */

@Slf4j
@Service
public class DocumentServiceImpl implements DocumentService {

    @Resource
    private DocumentMapper documentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return documentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Document record) {
        return documentMapper.insert(record);
    }

    @Override
    public int insertSelective(Document record) {
        return documentMapper.insertSelective(record);
    }

    @Override
    public Document selectByPrimaryKey(Integer id) {
        return documentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Document record) {
        return documentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Document record) {
        return documentMapper.updateByPrimaryKey(record);
    }

}
