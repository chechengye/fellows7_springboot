package com.lovecoding.fellows7_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @SpringBootApplication : 标记一个类是主程序类、启动类、入口
 * 	@SpringBootConfiguration : 标识它是一个配置类  @Configuration
    @EnableAutoConfiguration : 开启自动配置的
 		@AutoConfigurationPackage ： 开启自动配置包/目录  主应用类所在的目录  （相当于 Spring context scan-package 自动扫描路径）
				Registrar.class 注册目录匹配
		@AutoConfigurationImportSelector:帮我们导入自动配置类 （130+）
				META-INF/spring.factories ： 寻找需要导入配置类
 *
 *@MapperScan : 扫描所有Mybatis mapper接口的
 * 	添加它之后就不再需要添加@Mapper注解了
 *
 * @EnableCaching：开启整个工程的缓存注解使用。
 *
 *
 * Redis整合
 *  redis的数据结构是key,value 键值对
 *  支持的数据类型有 字符串、列表、散列、集合Set 、有序集合ZSet。
 *  1、导入依赖
 *  2、配置文件中添加spring.redis.host
 *@EnableRabbit :
 * 	开启rabbit主键应用
 */
@SpringBootApplication
@MapperScan("com.lovecoding.fellows7_springboot.mapper")
@EnableCaching
@EnableRabbit
public class Fellows7SpringbootApplication {

	/**
	 * 主函数入口
	 * 启动的时候，会直接启动内嵌的Tomcat服务器
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Fellows7SpringbootApplication.class, args);
	}

}
