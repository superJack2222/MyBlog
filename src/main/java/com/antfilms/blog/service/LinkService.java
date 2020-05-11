package com.antfilms.blog.service;

import com.antfilms.blog.entity.Link;

import java.util.List;

/**
 * @program: blog
 * @description: LinkService
 * @author: Jack.Miao
 * @create: 2020-05-08 11:21
 **/
public interface LinkService {
    List<Link> getLinkList();
}
