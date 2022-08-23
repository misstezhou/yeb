package com.mikes.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikes.server.pojo.Menu;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户id获取菜单列表
     *
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
