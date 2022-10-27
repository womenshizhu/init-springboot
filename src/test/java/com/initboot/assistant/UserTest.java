package com.initboot.assistant;

import cn.hutool.core.lang.Assert;
import com.initboot.assistant.mapper.UserMapper;
import com.initboot.assistant.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Description: 测试用户用例
 * Author:   fsli
 * Time:     2021/5/29 17:19
 * Version:  1.0.0
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.isTrue(5 == userList.size());
        userList.forEach(System.out::println);
    }
}
