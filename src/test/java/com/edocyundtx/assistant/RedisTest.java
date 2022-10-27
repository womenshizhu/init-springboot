package com.edocyundtx.assistant;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Description: 测试用户用例
 * Author:   fsli
 * Time:     2021/5/29 17:19
 * Version:  1.0.0
 */
@SpringBootTest
public class RedisTest {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSelect() {

        stringRedisTemplate.opsForValue().set("peter", "1");
        String peter = stringRedisTemplate.opsForValue().get("peter");
        System.out.println(peter);

    }
}
