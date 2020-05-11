package com.antfilms.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public  static  String formatDate(Date date,String format){
        String result="";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        if (date!=null){
            return simpleDateFormat.format(date);
        }
        else {
            return  result;
        }
    }

    public  static  String getCurrentDateStr(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddhhmmss");
        return  simpleDateFormat.format(date);

    }
}
