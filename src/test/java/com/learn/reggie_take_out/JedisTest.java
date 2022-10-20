package com.learn.reggie_take_out;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Set;


public class JedisTest {

	@Test
	public void  testRedis(){
		//1 获取连接
		Jedis jedis = new Jedis("localhost",6379);

		//2 执行具体的操作
		jedis.set("username","11111");

		String value = jedis.get("username");
		System.out.println(value);

		jedis.hset("myhash","addr","bj");
		String hValue = jedis.hget("myhash", "addr");
		System.out.println(hValue);

		Set<String> keys = jedis.keys("*");
		for (String key : keys) {
			System.out.println(key);
		}

		//3 关闭连接
		jedis.close();

	}

}
