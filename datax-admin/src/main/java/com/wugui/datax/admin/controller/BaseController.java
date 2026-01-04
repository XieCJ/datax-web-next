package com.wugui.datax.admin.controller;


import com.wugui.datax.admin.common.Result;
import com.wugui.datax.admin.util.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

import static com.wugui.datatx.core.util.Constants.STRING_BLANK;

/**
 * base controller
 */
public class BaseController {

    public Integer getCurrentUserId(HttpServletRequest request) {
        Enumeration<String> auth = request.getHeaders(JwtTokenUtils.TOKEN_HEADER);
        String token = auth.nextElement().replace(JwtTokenUtils.TOKEN_PREFIX, STRING_BLANK);
        return JwtTokenUtils.getUserId(token);
    }

    /**
     * 成功返回结果
     */
    public <T> Result<T> success() {
        return Result.ok();
    }

    /**
     * 成功返回结果
     *
     * @param data 数据
     */
    public <T> Result<T> success(T data) {
        return Result.ok(data);
    }

    /**
     * 成功返回结果
     *
     * @param data 数据
     * @param msg  消息
     */
    public <T> Result<T> success(T data, String msg) {
        return Result.ok(data, msg);
    }

    /**
     * 失败返回结果
     */
    public <T> Result<T> failed() {
        return Result.failed();
    }

    /**
     * 失败返回结果
     *
     * @param msg 消息
     */
    public <T> Result<T> failed(String msg) {
        return Result.failed(msg);
    }

    /**
     * 失败返回结果
     *
     * @param data 数据
     * @param msg  消息
     */
    public <T> Result<T> failed(T data, String msg) {
        return Result.failed(data, msg);
    }
}