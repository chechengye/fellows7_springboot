package com.lovecoding.fellows7_springboot.controller;

import com.lovecoding.fellows7_springboot.pojo.User;
import com.lovecoding.fellows7_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @RestController ： SpringBoot中新增的注解 ，组合注解 包含了@Controller 与 @ResponseBody
 *
 * @Controller : SpringMVC中的注解，标识一个类是控制层类，可以被DispatherServlet解析器查询。
 */
@RestController
public class UserController {

    @Autowired
    JdbcTemplate jt;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/getUserList" , method = RequestMethod.GET)
    public List<User> getUserList(){
        return jt.query("select * from ums_user ", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getInt("sex"));
                return user;
            }
        });
    }
    /**
     * @GetMapping : get方式请求
     */
    @GetMapping("/getUserById")
    public User getUserById(Long id){
        return userService.getUserById(id);
    }

    /**
     * @PostMapping : post方式请求
     */
    @PostMapping("/updateUser")
    public User updateUser(User user){
        int rows = userService.updateUser(user);
        return user;
    }
}
