package com.antfilms.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: blog
 * @description: CommonResult
 * @author: Jack.Miao
 * @create: 2020-05-08 14:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>  implements Serializable {

    private Integer code;
    private  String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
