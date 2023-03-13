package com.atguigu.exception;

import com.atguigu.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author roo
 * @date 2023/3/13
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result GlobalException(Exception e){
        e.printStackTrace();
        return Result.fail(null).message("触发全局异常");
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public Result ArithmeticException(ArithmeticException e){
        e.printStackTrace();
        return Result.fail(null).message("触发特定异常");
    }
    //自定义异常
    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e){
        e.printStackTrace();
        return Result.fail(null).message(e.getMsg()).code(e.getCode());
    }
}
