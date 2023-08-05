package com.lzx.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommentResult
 * @Description TODO JSON封装实体
 * @Author lzx
 * @Date 2023/8/2 16:01:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data; //不同类型的json数据
    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }
}
