package com.antfilms.blog.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @program: blog
 * @description: MD5Util
 * @author: Jack.Miao
 * @create: 2020-05-09 14:39
 **/
public class MD5Util {

    public  static  String md5(String str,String salt){
        return  new Md5Hash(str,salt).toString();
    }
}
