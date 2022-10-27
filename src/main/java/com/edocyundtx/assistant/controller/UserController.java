package com.edocyundtx.assistant.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edocyundtx.assistant.entity.User;
import com.edocyundtx.assistant.mapper.UserMapper;
import com.edocyundtx.assistant.service.UserService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Description: 用户API
 * Author:   fsli
 * Time:     2021/5/29 19:00
 * Version:  1.0.0
 */
@Slf4j
@RestController
@Api(description = "用户API")
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "新增")
    @PostMapping("/insert")
    public boolean insert(@RequestBody User user) {
        return userService.save(user);
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @ApiOperation(value = "根据主键查询")
    @PostMapping("/selectById/{id}")
    public User selectById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "根据主键删除")
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @ApiOperation(value = "测试分页")
    @GetMapping("/testPage")
    public IPage<Map<String, Object>> testPage(@RequestParam(value = "pageNum") Integer pageNum,
                                               @RequestParam(value = "pageSize") Integer pageSize) {
        return userMapper.testPage(new Page<User>(pageNum, pageSize), new QueryWrapper<>());
//        return userMapper.testPage2(new Page<>(pageNum, pageSize), "test2@baomidou.com");
    }

    @ApiOperation(value = "特殊条件查询1")
    @GetMapping("/getInfoByConditions1/{name}")
    public List<User> getInfoByConditions1(@PathVariable String name) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>().eq(StrUtil.isNotBlank(name), User::getName, name);
        return userService.list(lambdaQueryWrapper);
    }

    @ApiOperation(value = "特殊条件查询2")
    @GetMapping("/getInfoByConditions2/{name}")
    public List<User> getInfoByConditions2(@PathVariable String name) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().like(StrUtil.isNotBlank(name), "name", name);
        return userService.list(queryWrapper);
    }

    @ApiOperation(value = "简单分词器")
    @GetMapping("/getParticiples/{questionStr}")
    public List<String> getParticiples(@PathVariable(value = "questionStr") String questionStr) {
        TokenizerEngine engine = TokenizerUtil.createEngine();
        Result result = engine.parse(questionStr);
        return Lists.newArrayList(result.iterator()).stream().map(Word::getText).collect(Collectors.toList());
    }
}
