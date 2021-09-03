package com.lovecoding.fellows7_springboot.mapper;

import com.lovecoding.fellows7_springboot.pojo.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapper {


    @Select("select * from ems_employee where id = #{id}")
    Employee getEmployeeById(Long id);
}
