package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.Menu;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();
}
