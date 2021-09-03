package com.lovecoding.fellows7_springboot.service.impl;

import com.lovecoding.fellows7_springboot.mapper.EmployeeMapper;
import com.lovecoding.fellows7_springboot.pojo.Employee;
import com.lovecoding.fellows7_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 缓存注解中的方法：
     *      value与cacheNames 是一个作用。给我们缓存起名字（缓存组件中会存储多条记录）。二者选其一即可，名字可以是多个。此属性必填
     *      key与keyGenerator 是一个作用。标识缓存记录的（可以查询到某一条记录）默认值 ：方法的第一个参数。非必填属性
     *      cacheManager与cacheResolver ： 缓存管理器与缓存解析器。解析缓存内容。通常无需修改 - 自动配置的即可、
     *      condition ： 条件 ，缓存的时候可以设定缓存条件，（满足什么条件下才进行缓存）
     *      unless : 条件，除非什么情况下才缓存。（相反）不满足才缓存 unless = "#result == null"
     *      sync : 是否同步，默认是同步（线程安全） 不建议进行修改！！！
     *      获取第一个参数的方式：
     *          #参数名  ，#p0  #a0
     *      获取方法返回结果
     *          #result
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp" , condition = "#id > 1")
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeMapper.getEmployeeById(id);
    }
}
