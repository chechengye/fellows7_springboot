package com.lovecoding.fellows7_springboot.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 两种方式可以从配置文件中 读取属性值
 * 1）、@ConfigurationProperties : 全扫描匹配、属性文件中存在的与实体类中属性相同的则进行匹配
 *          支持JSR303检验 - 检查
 *          prefix : 来确定配置文件中的某个层级下面的所属
 *          要求： 即将被匹配的实体类，要存于Spring大容器中
 * 2) @Value 来对类中的属性进行赋值 - 一个一个赋值   支持#{spEl}
 */
@ConfigurationProperties(prefix = "person")
@Component
@Validated
public class Person implements Serializable{

    @Value("${person.name}")
    private String name;

    private String lastName;

    @Value("#{11 + 22}")
    private Integer age;

    //通过${} 从属性文件中或者是配置文件中读取值
    @Value("${person.birthday}")
    private Date birthday;

    private List list;

    private Map map;

    private Car car;

    @Email
    private String email;

    @Value("${wx.api}")
    private String WX_API;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWX_API() {
        return WX_API;
    }

    public void setWX_API(String WX_API) {
        this.WX_API = WX_API;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", list=" + list +
                ", map=" + map +
                ", car=" + car +
                ", email='" + email + '\'' +
                ", WX_API='" + WX_API + '\'' +
                '}';
    }
}
