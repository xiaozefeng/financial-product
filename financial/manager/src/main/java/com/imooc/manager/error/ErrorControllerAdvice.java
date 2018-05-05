package com.imooc.manager.error;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一错误处理
 *
 * @author xiaozefeng
 * @date 2018/5/5 上午9:51
 */
@ControllerAdvice
public class ErrorControllerAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseEntity handleException(Exception e) {
        String message = e.getMessage();
        return new ResponseEntity(ImmutableMap.of("message", message),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
