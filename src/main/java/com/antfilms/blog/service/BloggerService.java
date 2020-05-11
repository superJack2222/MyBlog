package com.antfilms.blog.service;

import com.antfilms.blog.entity.Blogger;

/**
 * @program: blog
 * @description: BloggerService
 * @author: Jack.Miao
 * @create: 2020-05-08 11:31
 **/
public interface BloggerService {

    Blogger getBlogger();

    Blogger getBloggeByUserName(String username);
}
