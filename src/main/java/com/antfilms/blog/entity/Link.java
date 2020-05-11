package com.antfilms.blog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Link  implements Serializable {

    private  int id;
    private  String linkName;
    private  String linkUrl;
    private  int orderNum;
}
