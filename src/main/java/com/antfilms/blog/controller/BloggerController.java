package com.antfilms.blog.controller;

import com.antfilms.blog.entity.Blogger;
import com.antfilms.blog.service.BloggerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @program: blog
 * @description: BloggerController
 * @author: Jack.Miao
 * @create: 2020-05-08 17:31
 **/
@RestController
public class BloggerController {

    @Resource
    private BloggerService bloggerService;





    @RequestMapping("/resource")
    public ModelAndView resource(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("mainTemp");
        modelAndView.addObject("commonPage","resource");
        return  modelAndView;
    }

    @RequestMapping("/aboutMe")
    public ModelAndView aboutMe(){
        ModelAndView modelAndView=new ModelAndView();
        Blogger blogger = bloggerService.getBlogger();
        modelAndView.addObject("blogger", blogger);
        modelAndView.addObject("commonPage","bloggerInfo");
        modelAndView.addObject("title", "关于博主 - 熊平的博客");
        modelAndView.setViewName("mainTemp");
        return modelAndView;

    }

    @RequestMapping("/myAlbum")
    public  ModelAndView myAlbum(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("commonPage","myAlbum");
        modelAndView.setViewName("mainTemp");
        return  modelAndView;
    }
}
