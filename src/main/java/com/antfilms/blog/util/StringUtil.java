package com.antfilms.blog.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public  static  boolean isEmpty(String str){
        if (str==null||"".equals(str.trim())){
            return  true;
        }
        else {
            return  false;
        }
    }

    public  static  boolean isNotEmpty(String str){
        if(str!=null&&!"".equals(str.trim())){
            return  true;
        }
        else {
            return  false;
        }
    }


    public  static List<String> filterWhite(List<String> list){
        List<String> resultList=new ArrayList<>();
        for (String l :list){
            if (isNotEmpty(l)){
                resultList.add(l);
            }
        }
        return  resultList;
    }


}
