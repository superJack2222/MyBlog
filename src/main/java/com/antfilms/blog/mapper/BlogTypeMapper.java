package com.antfilms.blog.mapper;

import com.antfilms.blog.entity.BlogType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface BlogTypeMapper {
    @Select("select * from t_blogtype where id=#{id}")
    BlogType getById(Integer id);


    @Select("select * from t_blogtype limit {#start},{#end}")
    List<BlogType> listByPage(@Param("start") Integer start, @Param("end") Integer end);

    @Select("select count(1) from t_blogtype")
    long getTotal();


    @Select("select * from t_blogtype")
    List<BlogType> getList();
}
