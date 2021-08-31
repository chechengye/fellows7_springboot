package com.lovecoding.fellows7_springboot;

import com.lovecoding.fellows7_springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Fellows7SpringbootApplicationTests {

	Logger logger = LoggerFactory.getLogger(Fellows7SpringbootApplicationTests.class);
	@Autowired
	Person person;
	@Test
	void contextLoads() {

		System.out.println(person);
	}

	/**
	 * SpringBoot Sl4J是有日志默认的级别的。 info 及以上级别的就会打印出来。
	 */
	@Test
	void testFn(){
		//正常情况下，日志输出是根据不同业务场景去输出打印
		logger.trace("这是一个跟踪日志");
		logger.debug("这是调试日志");
		logger.info("这是一个基本打印日志");
        System.out.println("这是测试打印！！！！");
		logger.warn("警告日志！");
		logger.error("错误日志！");
	}
}
