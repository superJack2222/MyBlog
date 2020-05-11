package com.antfilms.blog.util;


import com.antfilms.blog.entity.Blog;

public class PageUtil {

    public  static  String genPagination(String targetUrl,long totalNum,
                                         int currentPage,
                                         int pageSize,
                                         String param){
        //计算总页数
        long totalPage = totalNum % pageSize==0 ? totalNum/pageSize : totalNum/pageSize+1;
        if(totalPage == 0){
            return "未查询到数据";
        }else{
            StringBuffer pageCode = new StringBuffer();
            if(currentPage > 1) {
                pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>首页</a></li>");
                pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage-1) + "&" + param + "'>上一页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a>首页</a></li>");
                pageCode.append("<li class='disabled'><a>上一页</a></li>");
            }
            for(int i = currentPage - 2; i <= currentPage + 2; i++) {
                if(i < 1 || i > totalPage) {
                    continue;
                }
                if(i == currentPage) {
                    pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
                }else{
                    pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");
                }
            }
            if(currentPage < totalPage) {
                pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage+1) + "&" + param + "'>下一页</a></li>");
                pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>尾页</a></li>");
            }else{
                pageCode.append("<li class='disabled'><a>下一页</a></li>");
                pageCode.append("<li class='disabled'><a>尾页</a></li>");
            }
            return pageCode.toString();
        }
    }

    public static String getPrevAndNextPageCode(Blog prev, Blog next, String projectContent) {
        StringBuffer pageCode = new StringBuffer();
        if(prev == null || prev.getId() == null) {
            pageCode.append("<p>上一篇：无</P>");
        } else {
            pageCode.append("<p>上一篇：<a href='" + projectContent + "/blog/articles/" + prev.getId() + ".html'>" + prev.getTitle() + "</a></p>");
        }

        if(next == null || next.getId() == null) {
            pageCode.append("<p>下一篇：无</P>");
        } else {
            pageCode.append("<p>上一篇：<a href='" + projectContent + "/blog/articles/" + next.getId() + ".html'>" + next.getTitle() + "</a></p>");
        }

        return pageCode.toString();
    }
}
