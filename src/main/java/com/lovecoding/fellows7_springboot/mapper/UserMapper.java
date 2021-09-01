package com.lovecoding.fellows7_springboot.mapper;

import com.lovecoding.fellows7_springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * SpringBoot要求使用@Mapper来标记mapper层接口
 */
public interface UserMapper {
    User getUserById(Long id);

    @Update("update ums_user set username = #{username} , real_name = #{realName} where id = #{id}")
    int updateUser(User user);
}
