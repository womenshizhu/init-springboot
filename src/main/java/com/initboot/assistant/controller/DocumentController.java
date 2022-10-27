package com.initboot.assistant.controller;

import com.initboot.assistant.entity.Document;
import com.initboot.assistant.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description: 文档管理API
 * Author:   Jack.Li
 * Time:     2021/4/23 14:14
 * Version:  1.0.0
 */
@Slf4j
@RestController
@Api(description = "文档管理API")
@RequestMapping(value = "/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @ApiOperation(value = "新增")
    @PostMapping("/insert")
    public int insert(@RequestBody Document document) {
        return documentService.insert(document);
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public int update(@RequestBody Document document) {
        return documentService.updateByPrimaryKey(document);
    }

    @ApiOperation(value = "根据主键查询")
    @PostMapping("/selectById/{id}")
    public Document selectById(@PathVariable int id) {
        return documentService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "根据主键删除")
    @DeleteMapping("/deleteById/{id}")
    public int deleteById(@PathVariable int id) {
        return documentService.deleteByPrimaryKey(id);
    }
}
