package com.antfilms.blog.service.impl;

import com.antfilms.blog.entity.Blogger;
import com.antfilms.blog.mapper.BloggerMapper;
import com.antfilms.blog.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: blog
 * @description: BloggerServiceImpl
 * @author: Jack.Miao
 * @create: 2020-05-08 11:31
 **/
@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerMapper bloggerMapper;
    @Override
    public Blogger getBlogger() {
        return  bloggerMapper.getBloggerData();
    }

    @Override
    public Blogger getBloggeByUserName(String username) {
            return  bloggerMapper.getBloggerByUserName(username);
    }
}
