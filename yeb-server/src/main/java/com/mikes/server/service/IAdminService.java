package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.Admin;
import com.mikes.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录之后返回token
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登陆之后返回token
     * @author mikes
     * @date 2021/7/27 16:54
     */
    RespBean login(String username, String password,String code, HttpServletRequest request);

    /**
     *  根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

}
