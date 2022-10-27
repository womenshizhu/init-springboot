package com.edocyundtx.assistant.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edocyundtx.assistant.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Description: 用户mapper
 * Author:   fsli
 * Time:     2021/5/29 17:18
 * Version:  1.0.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user ${ew.customSqlSegment}")
    IPage<Map<String, Object>> testPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);

    @Select("select * from user where email = #{email} ")
    IPage<Map<String, Object>> testPage2(Page<User> page, @Param("email") String email);
}
