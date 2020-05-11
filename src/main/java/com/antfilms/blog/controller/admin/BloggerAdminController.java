package com.antfilms.blog.controller.admin;

import cn.hutool.json.JSONUtil;
import com.antfilms.blog.entity.Blogger;
import com.antfilms.blog.entity.CommonResult;
import com.antfilms.blog.mapper.BloggerMapper;
import com.antfilms.blog.service.BloggerService;
import com.antfilms.blog.util.MD5Util;
import com.antfilms.blog.util.StringUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @program: blog
 * @description: BloggerAdminController
 * @author: Jack.Miao
 * @create: 2020-05-09 14:33
 **/
@RestController
@RequestMapping("/admin")
public class BloggerAdminController {

    @Resource
    private BloggerService bloggerService;

    @GetMapping("/login")
    public ModelAndView login()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return  modelAndView;
    }

    @PostMapping("/login")
    public String login(Blogger blogger)
    {
        CommonResult<String> commonResult=new CommonResult<>();
        if (StringUtil.isNotEmpty(blogger.getUsername())&&StringUtil.isNotEmpty(blogger.getPassword())){
            Blogger bloggeByUserName = bloggerService.getBloggeByUserName(blogger.getUsername());
            if (bloggeByUserName==null){
                commonResult.setCode(2);
                commonResult.setMessage("对不起该用户不存在");
            }
            else {
                boolean isRight= bloggeByUserName.getPassword().equals(MD5Util.md5(blogger.getPassword(),"aaa"));
                if (isRight){
                    commonResult.setCode(0);
                    commonResult.setMessage("登录成功");
                }
                else {
                    commonResult.setCode(3);
                    commonResult.setMessage("对不起密码错误");
                }

            }
        }
        else {
            commonResult.setCode(4);
            commonResult.setMessage("请输入用户名密码");
        }
        String jsonStr= JSONUtil.toJsonStr(commonResult);
        return  jsonStr;
    }





}
