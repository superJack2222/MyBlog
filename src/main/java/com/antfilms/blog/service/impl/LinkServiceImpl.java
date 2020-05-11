package com.antfilms.blog.service.impl;

import com.antfilms.blog.entity.Link;
import com.antfilms.blog.mapper.LinkMapper;
import com.antfilms.blog.service.LinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: blog
 * @description: LinkServiceImpl
 * @author: Jack.Miao
 * @create: 2020-05-08 11:21
 **/
@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private LinkMapper linkMapper;
    @Override
    public List<Link> getLinkList() {
        return  linkMapper.getLinkList();
    }
}
