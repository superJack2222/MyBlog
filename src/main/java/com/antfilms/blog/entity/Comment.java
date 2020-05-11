package com.antfilms.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment  implements Serializable {
    private  int id;
    private String userIp;
    private String comment;
    private Date commentDate;
    private  int state;

    private  Blog blog;

}
