package com.edocyundtx.assistant.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edocyundtx.assistant.entity.User;
import com.edocyundtx.assistant.mapper.UserMapper;
import com.edocyundtx.assistant.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Description: 用户Service实现
 * Author:   fsli
 * Time:     2021/5/29 18:55
 * Version:  1.0.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
