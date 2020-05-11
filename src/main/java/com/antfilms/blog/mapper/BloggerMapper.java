package com.antfilms.blog.mapper;

import com.antfilms.blog.entity.Blogger;
import org.apache.ibatis.annotations.Select;

/**
 * @program: blog
 * @description: Bloggermapper
 * @author: Jack.Miao
 * @create: 2020-05-08 11:24
 **/
public interface BloggerMapper {

    @Select("select  * from t_blogger where id =1")
    Blogger getBloggerData();
    @Select("select  * from t_blogger where username =#{username}")
    Blogger getBloggerByUserName(String username);
}
