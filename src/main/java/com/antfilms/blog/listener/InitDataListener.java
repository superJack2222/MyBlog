package com.antfilms.blog.listener;

import com.antfilms.blog.entity.BlogType;
import com.antfilms.blog.entity.Blogger;
import com.antfilms.blog.entity.Link;
import com.antfilms.blog.service.BlogTypeService;
import com.antfilms.blog.service.BloggerService;
import com.antfilms.blog.service.LinkService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * @program: blog
 * @description: 创建监听器
 * @author: Jack.Miao
 * @create: 2020-05-08 10:55
 **/
@Component
public class InitDataListener  implements  ServletContextListener ,ApplicationContextAware{

    public    static  ApplicationContext applicationContexts;

    @Override
    public void contextInitialized(ServletContextEvent sce) {


        ServletContext servletContext = sce.getServletContext();
        BlogTypeService blogTypeService = applicationContexts.getBean(BlogTypeService.class);
        LinkService linkService = applicationContexts.getBean(LinkService.class);

        BloggerService bloggerService = applicationContexts.getBean(BloggerService.class);

        Blogger blogger = bloggerService.getBlogger();


        List<BlogType> blogType = blogTypeService.getBlogType();
        List<Link> linkList = linkService.getLinkList();
       servletContext.setAttribute("linkList",linkList);
       servletContext.setAttribute("blogger",blogger);
       servletContext.setAttribute("blogTypeList",blogType);



    }

    public  static boolean checkMyContextIsNull(){
        if (applicationContexts==null){
            return  true;
        }
        else {
            return  false;
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContexts=applicationContext;
    }
}
