package com.itwang.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:06  16:19
 */
@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data=new HashMap<>();

    private R() {}

    public static R ok()
    {
        R r=new R();
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        r.setSuccess(true);
        return r;
    }

    public  static R error()
    {
        R r=new R();
        r.setCode(ResultCode.FAILED);
        r.setMessage("失败");
        r.setSuccess(false);
        return r;
    }

    public R success(Boolean success)
    {
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code)
    {
        this.setCode(code);
        return this;
    }

    public R data(String key,Object o)
    {
        this.data.put(key,o);
        return this;
    }
    public R data(Map<String,Object> maps)
    {
        this.data.putAll(maps);
        return this;
    }

    public R message(String message)
    {
        this.setMessage(message);
        return this;
    }

}
