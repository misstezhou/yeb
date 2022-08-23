package com.mikes.server.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.mikes.server.pojo.Menu;
import com.mikes.server.pojo.MenuRole;
import com.mikes.server.pojo.RespBean;
import com.mikes.server.pojo.Role;
import com.mikes.server.service.IMenuRoleService;
import com.mikes.server.service.IMenuService;
import com.mikes.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/basic/permissing")
public class PerMissingController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IMenuService menuService;
    @Autowired
    private IMenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" + role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if(roleService.removeById(rid)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public  List<Menu> getAllMenu(){
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        QueryWrapper queryWrapper = new QueryWrapper<MenuRole>().eq("rid",rid);
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid)).stream().map(MenuRole::getMid).collect(Collectors.toList());
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);
    }
}
