package com.mikes.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikes.server.pojo.Employee;
import com.mikes.server.pojo.RespBean;
import com.mikes.server.pojo.RespPageBean;
import io.swagger.models.auth.In;

import java.time.LocalDate;
import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhanglishen
 * @since 2021-07-22
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工（分页）
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 获取工号
     * @return
     */
    RespBean maxWorkId();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 查询员工
     * @param id
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工账套
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
