package com.lovecoding.fellows7_springboot;

import com.lovecoding.fellows7_springboot.pojo.Book;
import com.lovecoding.fellows7_springboot.pojo.Person;
import com.lovecoding.fellows7_springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

	/**
	 * 测试数据源
	 */
	@Autowired
	DataSource dataSource;
	@Test
	void testFn1(){
		System.out.println(dataSource.getClass());
	}


	@Autowired
	StringRedisTemplate stringRedisTemplate;

	/**
	 * stringRedisTemplate.opsForValue() : 对字符串类型数据操作
	 * stringRedisTemplate.opsForList() : 对列表类型数据操作
	 * stringRedisTemplate.opsForHash  : 对散列数据类型操作
	 * stringRedisTemplate.opsForSet() : 对集合类型数据操作
	 * stringRedisTemplate.opsForZSet() : 对有序集合类型数据操作
	 */
	@Test
	void testFn2(){
		//测试redis操作缓存字符串
		//stringRedisTemplate.opsForValue().append("k1" , "rediscode_val");
		stringRedisTemplate.opsForList().leftPushAll("list_code" , "r1" , "r2" , "r3");
		//stringRedisTemplate.opsForZSet().
	}

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	EmployeeService es;

	@Autowired
	RedisTemplate empRedisTemplate;
	@Test
	void testFn3(){
		//可以修改对象的序列化策略，来让对象可以显示出来。
		empRedisTemplate.opsForValue().set("emp-01" , es.getEmployeeById(1l));
	}


	/**
	 * 测试RabbitMQ相关
	 */
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Test
	void testFn4(){
		Map<String , Object> map = new HashMap<>();
		map.put("msg" , "代码发送消息至点对点的消息队列");
		map.put("data" , Arrays.asList(200, "数据..." , "成功!"));
		//点对点式发送消息
		rabbitTemplate.convertAndSend("exchange.direct" , "lovecoding" , map);
	}

	@Test
	void testFn5(){
		Object lovecoding = rabbitTemplate.receiveAndConvert("lovecoding");
		System.out.println("receive msg : " + lovecoding);
	}

	@Test
	void testFn6(){
		Book book = new Book();
		book.setAuthor("曹雪芹");
		book.setBookName("红楼梦");
		rabbitTemplate.convertAndSend("exchange.topic" , "*.news" , book);
	}

	/**
	 * 实时监听消息队列中的消息
	 */
	@Test
	void testFn7(){
		Book book = new Book();
		book.setAuthor("罗贯中");
		book.setBookName("三国演义");
		rabbitTemplate.convertAndSend("exchange.topic" , "*.news" , book);

	}

	/**
	 * 使用AmqpAdmin 对象来创建交换器、队列、和绑定规则
	 */
	@Autowired
	AmqpAdmin amqpAdmin;
	@Test
	void testFn8(){
		//DirectExchange : 点对点式的交换器
		//amqpAdmin.declareExchange(new DirectExchange("amqpadmin.direct"));
		//amqpAdmin.declareQueue(new Queue("amqpadmin.news"));
		amqpAdmin.declareBinding(new Binding("amqpadmin.news"
				, Binding.DestinationType.QUEUE , "amqpadmin.direct"
				, "amqpadmin.news", null));
	}
}
