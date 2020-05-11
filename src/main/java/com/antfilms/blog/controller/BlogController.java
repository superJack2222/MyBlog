package com.antfilms.blog.controller;


import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.antfilms.blog.entity.*;
import com.antfilms.blog.mapper.BlogTypeMapper;
import com.antfilms.blog.service.BlogService;
import com.antfilms.blog.service.BlogTypeService;
import com.antfilms.blog.service.BloggerService;
import com.antfilms.blog.service.LinkService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class BlogController {


    @Autowired
    private BlogTypeService blogTypeService;

    @Autowired
    private BloggerService bloggerService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private BlogService blogService;


    @RequestMapping("/blogList")
    public ModelAndView blogList(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/foreground/blog/blogList");
        return  modelAndView;
    }



    @GetMapping("/getRightList")
    public  String getRightList(){

        HashMap<String,Object> map=new LinkedHashMap<>();
        map.put("start",0);
        map.put("end",10);
        Blogger blogger = bloggerService.getBlogger();

        List<Blog> blogs = blogService.listBlog(map);
        List<Link> linkList = linkService.getLinkList();
        List<BlogType> blogType = blogTypeService.getBlogType();
        RightResult rightResult = new RightResult();
        rightResult.setBlogger(blogger);
        rightResult.setBlogList(blogs);
        rightResult.setLinkList(linkList);
        rightResult.setBlogTypes(blogType);
        CommonResult<RightResult> stringCommonResult = new CommonResult<>();
        stringCommonResult.setCode(0);
        stringCommonResult.setMessage("ok");
        stringCommonResult.setData(rightResult);
        String jsonData= JSONUtil.toJsonStr(stringCommonResult);
        return jsonData;
    }


    @GetMapping("/getBlogList")
    public  String getBlogList(){
        HashMap<String,Object> map=new LinkedHashMap<>();
        map.put("start",0);
        map.put("end",10);
        List<Blog> blogs = blogService.listBlog(map);
        CommonResult<List<Blog>> blogCommonResult = new CommonResult<>();
        blogCommonResult.setCode(0);
        blogCommonResult.setMessage("ok");
        blogCommonResult.setData(blogs);
        return  JSONUtil.toJsonStr(blogCommonResult);
    }

}
