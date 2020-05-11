package com.antfilms.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: blog
 * @description: MainAdminController
 * @author: Jack.Miao
 * @create: 2020-05-09 13:34
 **/
@Controller
@RequestMapping("/admin")
public class MainAdminController {

    @RequestMapping("/main")
    public  String toMenuPage(){
        return  "admin/main";
    }


    @RequestMapping("/menu1")
    public  String toMenuPage1()
    {
        return  "admin/main1";
    }
}
