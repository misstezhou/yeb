package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.Admin;
import com.mikes.server.pojo.RespBean;
import com.mikes.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新操作员
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);

    /**
     * 更新用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);
}
