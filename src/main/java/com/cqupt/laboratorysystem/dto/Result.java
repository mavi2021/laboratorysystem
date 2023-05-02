package com.cqupt.laboratorysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果类封装
 * @Author : ZengJun
 * @create 2023/4/30 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * 请求成功, 不返回数据
     * 返回200状态码
     */
    private Boolean success;

    /**
     * 请求失败，返回错误消息
     */
    private String errorMessage;

    /**
     * 请求成功，返回数据
     */
    private Object data;

    /**
     * 成功不返回数据
     */
    public static Result ok(){
        return new Result(true,null,null);
    }

    /**
     * 成功返回数据
     * @param data
     * @return
     */
    public static Result ok(Object data){
        return new Result(true,null,data);
    }

    /**
     * 失败返回错误消息
     * @param errorMessage
     * @return
     */
    public static Result fail(String errorMessage){
        return new Result(false,errorMessage,null);
    }
}
