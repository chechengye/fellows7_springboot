package com.lovecoding.fellows7_springboot.mapper;

import com.lovecoding.fellows7_springboot.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper {


    @Select("select * from ems_employee where id = #{id}")
    Employee getEmployeeById(Long id);

    @Update("update ems_employee set name = #{name} , email = #{email} where id = #{id}")
    int updateEmployee(Employee employee);

    @Delete("delete from ems_employee where id = #{id}")
    void deleteEmployeeById(Long id);
}
