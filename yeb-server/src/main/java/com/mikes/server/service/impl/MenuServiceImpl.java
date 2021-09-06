package com.mikes.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mikes.server.mapper.MenuMapper;
import com.mikes.server.pojo.Admin;
import com.mikes.server.pojo.Menu;
import com.mikes.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Security;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    /**
     * 根据用户id查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        return menuMapper.getMenusByAdminId(((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
