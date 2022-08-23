package com.mikes.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mikes.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);

    /**
     * 添加部门
     * @param dep
     */
    void addDep(Department dep);

    /**
     * 删除部门
     * @param dep
     */
    void deleteDep(Department dep);
}
