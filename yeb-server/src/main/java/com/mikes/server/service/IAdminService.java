package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.Admin;
import com.mikes.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录之后返回token
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     *  根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

}
