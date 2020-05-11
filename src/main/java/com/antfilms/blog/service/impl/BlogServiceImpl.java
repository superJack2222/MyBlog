package com.antfilms.blog.service.impl;

import com.antfilms.blog.mapper.BlogMappper;
import com.antfilms.blog.entity.Blog;
import com.antfilms.blog.entity.PageBean;
import com.antfilms.blog.service.BlogService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMappper blogMappper;


    @Override
    public List<Blog> listBlog(Map<String, Object> map) {
        return  blogMappper.listBlog(map);
    }

    public  PageBean<Blog> listBlog(String title, PageBean<Blog> pageBean){
        Map<String,Object> map=new HashMap<>();
        map.put("title",title);
        pageBean.setTotal(blogMappper.getTotal(map));
        map.put("start",pageBean.getStart());
        map.put("end",pageBean.getEnd());
        //把分页结果放入pageBean
        pageBean.setResult(blogMappper.listBlog(map));
        return pageBean;
    }

    /**
    * @Description: 获取博客的总数量
    * @Param: 
    * @return: 
    * @Author: JackMiao
    * @Date:
    */
    @Override
    public long getTotal(Map<String, Object> map) {
        return 0;
    }

    /**
    * @Description: 更新博客
    * @Param:
    * @return:
    * @Author: JackMiao
    * @Date:
    */
    @Override
    public int updateBlog(Blog blog) {
        return  blogMappper.updateBlog(blog.getId());
    }

    @Override
    public int saveBlog(Blog blog) {
        return  blogMappper.saveBlog(blog);
    }


}
