package com.lovecoding.fellows7_springboot;

import com.lovecoding.fellows7_springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Fellows7SpringbootApplicationTests {

	@Autowired
	Person person;
	@Test
	void contextLoads() {

		System.out.println(person);
	}

}
