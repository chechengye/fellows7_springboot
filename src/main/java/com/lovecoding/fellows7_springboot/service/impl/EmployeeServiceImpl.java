package com.lovecoding.fellows7_springboot.service.impl;

import com.lovecoding.fellows7_springboot.mapper.EmployeeMapper;
import com.lovecoding.fellows7_springboot.pojo.Employee;
import com.lovecoding.fellows7_springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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
     *       执行顺序：
     *          会先操作缓存、然后再执行方法（缓存的操作是在方法前执行的）
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp" , condition = "#id > 1")
    @Override
    public Employee getEmployeeById(Long id) {
        System.out.println("员工: " + id);
        return employeeMapper.getEmployeeById(id);
    }

    /**
     * @CachePut : 用于更新方法 （目的：数据更新之后，若是之前缓存中存在于此条目，直接更新缓存数据）
     *      执行顺序：先操作方法，再进行缓存处理。（在方法执行之后处理，保证方法的正常执行。）
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp" , key = "#result.id")
    @Override
    public Employee updateEmployee(Employee employee) {
        System.out.println("employee id : " + employee.getId());
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * allEntries : 默认不清空缓存中的所有记录，若为true，则清除所有。
     * beforeInvocation ： 默认是false，若方法执行的过程中出现异常，则不清空。方法后执行
     *         若置为true，则会在方法前执行，直接先清除指定缓存记录
     * @param id
     */
    @CacheEvict(cacheNames = "emp" , key = "#id")
    @Override
    public void deleteEmployeeById(Long id) {
        employeeMapper.deleteEmployeeById(id);
        //int i = 1/0;
    }
}
