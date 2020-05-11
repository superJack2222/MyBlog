package com.antfilms.blog.lucene;

import com.antfilms.blog.util.PathUtil;
import org.apache.tomcat.jni.Directory;
import org.springframework.stereotype.Component;

/**
 * @program: blog
 * @description: BlogIndex
 * @author: Jack.Miao
 * @create: 2020-05-09 10:58
 **/
@Component
public class BlogIndex {

    public Directory directory;
    public  String indexDir= PathUtil.getRootPath()+"";




}
