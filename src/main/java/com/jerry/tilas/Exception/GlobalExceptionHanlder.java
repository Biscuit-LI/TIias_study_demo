package com.jerry.tilas.Exception;


import com.jerry.tilas.pojo.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHanlder {
    //全局异常捕获
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e){
        log.info("服务异常~",e);
        return Result.error("服务异常");
    }

    //特定
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.info("重复异常~",e);
        String message=e.getMessage();
        int i=message.indexOf("Duplicate entry");
        String errMsg=message.substring(i);
        String[] arr=errMsg.split(" ");
        return Result.error(arr[2]+"已存在");
    }

}
