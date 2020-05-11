package com.antfilms.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: blog
 * @description: Blogger
 * @author: Jack.Miao
 * @create: 2020-05-08 11:25
 **/
@Data
public class Blogger implements Serializable {

    private  Integer id;
    private  String username;
    private  String password;
    private  String profile;
    private  String nickname;
    private  String sign;
    private  String imageName;

}
