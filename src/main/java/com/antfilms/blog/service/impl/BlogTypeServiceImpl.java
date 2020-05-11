package com.antfilms.blog.service.impl;

import com.antfilms.blog.entity.BlogType;
import com.antfilms.blog.entity.PageBean;
import com.antfilms.blog.mapper.BlogTypeMapper;
import com.antfilms.blog.service.BlogTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: blog
 * @description: BlogTypeServiceImpl
 * @author: Jack.Miao
 * @create: 2020-05-08 11:02
 **/
@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Resource
    private BlogTypeMapper blogTypeMapper;

    @Override
    public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {
        pageBean.setResult(blogTypeMapper.listByPage(pageBean.getStart(),pageBean.getEnd()));
        pageBean.setTotal(blogTypeMapper.getTotal());
        return  pageBean;
    }

    @Override
    public long getTotal() {
        return 0;
    }

    @Override
    public Integer addBlogType(BlogType blogType) {
        return null;
    }

    @Override
    public List<BlogType> getBlogType() {
        List<BlogType> list = blogTypeMapper.getList();
        return  list;
    }
}
