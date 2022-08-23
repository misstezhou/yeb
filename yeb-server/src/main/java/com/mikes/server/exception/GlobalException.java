package com.mikes.server.exception;

import com.mikes.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if(e instanceof SQLException){
            return RespBean.error("该操作有关联数据，操作失败");
        }
        return RespBean.error("数据库异常，操作失败");
    }
}
