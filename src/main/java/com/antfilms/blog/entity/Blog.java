package com.antfilms.blog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class Blog  implements Serializable {

    private  Integer id;
    private  String title;
    private  String summary;
    private Date releaseDate;
    private  int clickHit;
    private  int replyHit;
    private  String content;
    private  String contentNoTag; //不带标签的博客内容，用户lucence索引
    private  String keyWord;
    private  BlogType blogType;
    private  int blogCount;
    private  String releaseDateStr;
    private List<String> imageList=new LinkedList<>();


}
