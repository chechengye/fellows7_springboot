package com.lovecoding.fellows7_springboot.controller;

import com.lovecoding.fellows7_springboot.pojo.Employee;
import com.lovecoding.fellows7_springboot.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

/**
 * @Api : 注解于类上面的
 *      tags与value作用一样 为类起名（swagger-ui文档上面）
 *      description : 描述，这个类是干嘛的
 * @ApiOperation : 作用于方法上面，来描述方法的功能
 *      notes ： 备注/词条。描述方法、参数一些作用。是否必传等等
 * @ApiModelProperty  : 作用于属性上面的，描述属性是干嘛的、直接从数据库中读取注释信息
 * @ApiParam : 描述参数信息
 * @ApiImplicitParams : 描述所有参数的
 */
@Api(tags = "EmployeeController" , description = "员工管理类")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService es;


    @ApiOperation(value = "根据雇员主键ID获取一个雇员信息" , notes = "描述传递所有参数信息")
    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(@ApiParam("主键信息") @RequestParam Long id){
        return es.getEmployeeById(id);
    }

    @PostMapping("/updateEmployee")
    public Employee updateEmployee(Employee employee){
        es.updateEmployee(employee);
        return employee;
    }

    /**
     * 遵从RestFul风格传递主键信息
     *
     * @param id
     */
    @ApiOperation(value = "根据雇员主键ID删除一个雇员信息")
    @PostMapping("/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        es.deleteEmployeeById(id);
    }
}
