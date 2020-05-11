package com.antfilms.blog.mapper;

import com.antfilms.blog.entity.Link;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: blog
 * @description: 友情链接mapper
 * @author: Jack.Miao
 * @create: 2020-05-08 11:19
 **/
public interface LinkMapper {
    @Select("select * from t_link order by order_num desc")
   List<Link> getLinkList();
}
