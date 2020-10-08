package com.itwang.servicebase.errrorhandler;

import com.itwang.utils.MException;
import com.itwang.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:06  21:01
 */
@Slf4j
@RestControllerAdvice
public class GlobalExcetionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public R errornull(ArithmeticException e)
    {
        return R.error().message("arithmetic error");
    }


    //指定出现什么异常
    @ExceptionHandler(Exception.class)
    public R error(Exception e)
    {
        e.printStackTrace();
        return R.error().message("服务器出错");
    }

    @ExceptionHandler(MException.class)
    public R error(MException e)
    {
        log.error(e.getMessage());
        return R.error().code(e.getCode()).message(e.getMessage());
    }

}
