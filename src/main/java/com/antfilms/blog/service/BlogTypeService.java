package com.antfilms.blog.service;

import com.antfilms.blog.entity.BlogType;
import com.antfilms.blog.entity.PageBean;

import java.util.List;

/**
 * @program: blog
 * @description: BlogTypeService
 * @author: Jack.Miao
 * @create: 2020-05-08 11:00
 **/
public interface BlogTypeService {

    PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);

    long getTotal();

    Integer addBlogType(BlogType blogType);


    List<BlogType> getBlogType();
}
