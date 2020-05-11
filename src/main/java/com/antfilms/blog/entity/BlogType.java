package com.antfilms.blog.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class BlogType  implements Serializable {
    private  int id;
    private  String typeName;
    private  int orderNum;
    private  int blogCount;
}
