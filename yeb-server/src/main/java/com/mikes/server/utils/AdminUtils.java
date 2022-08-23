package com.mikes.server.utils;

import com.mikes.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 操作员工具类
 */
public class AdminUtils {
    /**
     * 获取当前操作登录员
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
