package com.antfilms.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class PageBean<T>  implements Serializable {

    private  int currPage;  //当前页数
    private  int pageSize; //每页显示个数

    private  long total; //总记录数

    public PageBean(int currPage, int pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.start=(currPage-1)*pageSize;

        this.end=currPage*pageSize;
    }

    private  int start;
    private  int end;

    private List<T> result;

    private Map<String,Object> map=new HashMap<String, Object>();




}
