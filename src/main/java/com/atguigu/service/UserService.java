package com.atguigu.service;

import com.atguigu.pojo.User;
import com.atguigu.utils.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 27175
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-10-19 13:56:21
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result getUserInfo(String token);

    Result checkUsername(String username);

    Result regist(User user);
}
