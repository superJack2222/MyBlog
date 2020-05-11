package com.antfilms.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: blog
 * @description: RightResult
 * @author: Jack.Miao
 * @create: 2020-05-08 14:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RightResult implements Serializable {

    private  Blogger blogger;
    private List<Link> linkList;
    private List<String> blogTimeList;
    private  List<Blog> blogList;

    private  List<BlogType> blogTypes;

}
