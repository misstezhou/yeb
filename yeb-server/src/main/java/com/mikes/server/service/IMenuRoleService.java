package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.MenuRole;
import com.mikes.server.pojo.RespBean;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
