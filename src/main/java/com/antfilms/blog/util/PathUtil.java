package com.antfilms.blog.util;

/**
 * @program: blog
 * @description: Path帮助类
 * @author: Jack.Miao
 * @create: 2020-05-06 15:54
 **/
public class PathUtil {

    /**
    * @Description: 获取项目的根路径
    * @Param:
    * @return:
    * @Author: JackMiao
    * @Date:
    */
    public  static  String getRootPath(){
        String path=PathUtil.class.getResource("/").toString();
        for (int i = 0; i < 5; i++) {
            int end=path.lastIndexOf("/");
            path=path.substring(0,end);
        }
        int index=path.indexOf(":");
        return  path.substring(index+1);
    }
}
