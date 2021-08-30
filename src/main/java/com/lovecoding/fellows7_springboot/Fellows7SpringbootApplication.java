package com.lovecoding.fellows7_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication : 标记一个类是主程序类、启动类、入口
 * 	@SpringBootConfiguration : 标识它是一个配置类  @Configuration
    @EnableAutoConfiguration : 开启自动配置的
 		@AutoConfigurationPackage ： 开启自动配置包/目录  主应用类所在的目录  （相当于 Spring context scan-package 自动扫描路径）
				Registrar.class 注册目录匹配
		@AutoConfigurationImportSelector:帮我们导入自动配置类 （130+）
				META-INF/spring.factories ： 寻找需要导入配置类
 *
 *
 */
@SpringBootApplication
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
