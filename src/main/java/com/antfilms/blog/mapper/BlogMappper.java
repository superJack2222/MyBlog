package com.antfilms.blog.mapper;


import com.antfilms.blog.entity.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
public interface BlogMappper {
    //分页查询博客


    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "summary",column = "summary"),
            @Result(property = "releaseDate",column = "releaseDate"),
            @Result(property = "clickHit",column = "clickHit"),
            @Result(property = "replyHit",column = "replyHit"),
            @Result(property = "content",column = "content"),
            @Result(property = "keyWord",column = "keyWord"),
            @Result(property = "blogType",column = "type_id",one = @One(select = "com.antfilms.blog.mapper.BlogTypeMapper.getById"))
    })

    @Select("<script>"+"SELECT * FROM t_blog"+
            "<where><if test=\"title!=null and title!=''\">"+
            "and title like \"%\"#{title}\"%\""+
            "</if>"+
            "<if test=\"typeId!=null and typeId!=''\">"+
            "and type_id=#{typeId}"+
            "</if>"+
            "<if test=\"releaseDateStr!=null and releaseDateStr!=''\">"+
            "and DATE_FORMAT(releaseDate,'%Y年%m月')=#{releaseDateStr}"+
            "</if>"+
        "</where>"+
    "ORDER BY releaseDate DESC"+
        "<if test=\"start!=null and end!=null\">"+
    "limit #{start},#{end}"+
        "</if>"+
            "</script>")
    List<Blog> listBlog(Map<String,Object> map);

    @Select("select count(1) from t_blog")
    long getTotal(Map<String, Object> map);


    @Update("<script>" +
            "        update  t_blog\n" +
            "        <set>\n" +
            "            <if test=\"title!=null and title!=''\">\n" +
            "                title=#{title},\n" +
            "            </if>\n" +
            "            <if test=\"summary!=null and summary!=''\">\n" +
            "                summary=#{summary},\n" +
            "            </if>\n" +
            "            <if test=\"content!=null and content!=''\">\n" +
            "                content=#{content},\n" +
            "            </if>\n" +
            "            <if test=\"blogType.id!=null\">\n" +
            "                type_id=#{blogType.id},\n" +
            "            </if>\n" +
            "            <if test=\"clickHit!=null\">\n" +
            "                clickHit=#{clickHit},\n" +
            "            </if>\n" +
            "            <if test=\"replyHit!=null\">\n" +
            "                replyHit=#{replyHit},\n" +
            "            </if>\n" +
            "            <if test=\"keyWord!=null and keyWord!=''\">\n" +
            "                keyWord=#{keyWord},\n" +
            "            </if>\n" +
            "        </set>      \n" +
            "        where id=#id \n" +
            "   </script>")
    int updateBlog(int id);

    @Insert("<script>" +
            "        insert into t_blog values (NULL ,#{title},#{summary},now(),0,0,#{content},#{keyWord},#{blogType.id})" +
            "</script>")
    int saveBlog(Blog blog);
}
