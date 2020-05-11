package com.antfilms.blog.controller;

import com.antfilms.blog.entity.Blog;
import com.antfilms.blog.entity.Blogger;
import com.antfilms.blog.entity.PageBean;
import com.antfilms.blog.service.BlogService;
import com.antfilms.blog.util.PageUtil;
import com.antfilms.blog.util.StringUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    private BlogService blogService;


    @GetMapping("/index2")
    public  ModelAndView index2(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index2");
        return  modelAndView;
    }


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "page",required = false) String page,
                              @RequestParam(value = "typeId",required = false) String typeId,
                              @RequestParam(value = "releaseDateStr",required = false) String releaseDateStr,
                              HttpServletRequest request) throws  Exception{
        ModelAndView modelAndView=new ModelAndView();

        if(StringUtil.isEmpty(page)){
            page="1";
        }

        PageBean pageBean=new PageBean(Integer.parseInt(page),10);

        Map<String,Object> map=new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("end",pageBean.getEnd());
        map.put("typeId",typeId);
        map.put("releaseDateStr",releaseDateStr);

        List<Blog> blogs = blogService.listBlog(map);

        for (Blog blog:blogs){
            List<String> imageList = blog.getImageList();
            String content = blog.getContent();
            Document parse = Jsoup.parse(content);
            Elements select = parse.select("img[src$=.jpg]");
            for (int i = 0; i < select.size(); i++) {
                Element jpg=select.get(i);
                imageList.add(jpg.toString());
                if (i==2)
                    break;
            }
        }

        StringBuffer stringBuffer=new StringBuffer();
        if (StringUtil.isNotEmpty(typeId)){
            stringBuffer.append("typeId="+typeId+"&");
        }
        if (StringUtil.isNotEmpty(releaseDateStr)){
            stringBuffer.append("releaseDateStr="+releaseDateStr+"&");
        }

        modelAndView.addObject("pageCode", PageUtil.genPagination(
                request.getContextPath()+"index.html",
                blogService.getTotal(map),
                Integer.parseInt(page),10,
                stringBuffer.toString()
        ));
        modelAndView.addObject("blogList",blogs);
        modelAndView.addObject("commonPage","blogList");
        modelAndView.addObject("title","博客主页");

        modelAndView.setViewName("main");
        return  modelAndView;

    }
}
