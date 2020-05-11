package com.antfilms.blog;

import com.antfilms.blog.entity.Blog;
import com.antfilms.blog.entity.BlogType;
import com.antfilms.blog.mapper.BlogMappper;
import com.antfilms.blog.mapper.BlogTypeMapper;
import com.antfilms.blog.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@MapperScan("com.antfilms.blog.mapper")
class BlogApplicationTests {

//    @Autowired
//    BlogTypeMapper blogTypeMapper;

//    @Autowired
//    private BlogMappper blogMappper;
    @Test
    void contextLoads() {
//
//        Map<String,Object> map=new HashMap<>();
//        map.put("start",0);
//        map.put("end",10);
//        List<Blog> blogs = blogMappper.listBlog(map);
//        System.out.println(blogs);
//        BlogType byId = blogTypeMapper.getById(1);
//        System.out.println(byId);

//        DataSource source=dataSource;
//        int k=0;
        System.out.println(MD5Util.md5("jackmiao","aaa"));
//        BlogType byId = blogTypeMapper.getById(1);
//        System.out.println(byId);

    }

}
