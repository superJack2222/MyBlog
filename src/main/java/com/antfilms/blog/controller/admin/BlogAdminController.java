package com.antfilms.blog.controller.admin;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.antfilms.blog.entity.*;
import com.antfilms.blog.lucene.BlogIndex;
import com.antfilms.blog.service.BlogService;
import com.antfilms.blog.service.BlogTypeService;
import com.antfilms.blog.service.CommonService;
import com.antfilms.blog.util.ResponseUtil;
import com.antfilms.blog.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: blog
 * @description: BlogAdminController
 * @author: Jack.Miao
 * @create: 2020-05-09 10:53
 **/
@RestController
@RequestMapping("/admin/blog")
public class BlogAdminController {

    @Resource
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;
    @Resource
    private CommonService commonService;

    @Resource
    private BlogIndex blogIndex;



    @GetMapping("/listBlog")
    public String listBlog(@RequestParam(value = "page",required = false) String page, @RequestParam(value = "rows",required = false) String rows,
                           Blog s_blog, HttpServletResponse response) throws  Exception
    {
        PageBean<Blog> pageBean=new PageBean<>(Integer.parseInt(page),
                Integer.parseInt(rows));
        pageBean=blogService.listBlog(s_blog.getTitle(),pageBean);


        List<Blog> result =
                pageBean.getResult();
        JSONObject jsonObject=new JSONObject();
        jsonObject.setDateFormat("yyyy-MM-dd");
        jsonObject.set("rows",result);
        jsonObject.set("total",pageBean.getTotal());
//        ResponseUtil.write(response,result);
        return  JSONUtil.toJsonStr(jsonObject);
    }

    @RequestMapping("/save")
    public  String saveBlog(Blog blog,HttpServletResponse response) throws  Exception{
        int resultTotal=0;
        if (blog.getId()!=null){
            //更新操作
            resultTotal=blogService.updateBlog(blog);
            //更新索引


        }

        else {
            resultTotal=blogService.saveBlog(blog);
        }

        CommonResult<String> commonResult=new CommonResult<>();
        commonResult.setData("ok");
        commonResult.setCode(0);
        String s = JSONUtil.toJsonStr(commonResult);
        return  s;
    }


    @RequestMapping("/writeBlog")
    public  ModelAndView writeBlog()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/admin/writeBlog");
        List<BlogType> blogType = blogTypeService.getBlogType();

        modelAndView.addObject("blogTypes",blogType);
        return  modelAndView;
    }

    @RequestMapping("/getBlogType")
    public  String getBlogType(){
        List<BlogType> blogType = blogTypeService.getBlogType();

        CommonResult<List<BlogType>> commonResult=new CommonResult<>();
        if (blogType!=null&&blogType.size()>0){
            commonResult.setData(blogType);
            commonResult.setCode(0);
        }
        else{
            commonResult.setCode(1);
        }
        return  JSONUtil.toJsonStr(commonResult);
    }




}
