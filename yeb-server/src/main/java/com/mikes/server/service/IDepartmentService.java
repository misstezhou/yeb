package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.Department;
import com.mikes.server.pojo.RespBean;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param dep
     * @return
     */
    RespBean addDep(Department dep);

    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean deleteDep(Integer id);
}
