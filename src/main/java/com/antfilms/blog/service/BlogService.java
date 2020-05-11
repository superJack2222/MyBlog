package com.antfilms.blog.service;

import com.antfilms.blog.entity.Blog;
import com.antfilms.blog.entity.PageBean;

import java.util.List;
import java.util.Map;

public interface BlogService {

    List<Blog> listBlog(Map<String,Object> map);

    PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean);

    long getTotal(Map<String,Object> map);

    int updateBlog(Blog blog);

    int saveBlog(Blog blog);
}
