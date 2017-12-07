package com.cdtu.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
 

public class RedisTest {
	
		
protected static Jedis jedis=new Jedis("127.0.0.1", 6379);
@SuppressWarnings("static-access")
public void save() {

	jedis.set("a", "1");
	System.out.println(jedis.get("a"));
	jedis.expire("a", 4);
	Thread thread=new Thread();
	try {
		thread.sleep(5000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	System.out.println(jedis.get("a"));
}
public void findAll(){
	jedis.keys("*");
}

//根据Key修改数据
public void update(){
    jedis.rename("a", "jedis_new");
}

//根据Key删除数据
public void del() {
    jedis.del("jedis");
}

//操作key
public void key() {
    System.out.println(jedis.exists("id"));
    System.out.println(jedis.del("id"));
}

//操作String
public void string() {
    System.out.println(jedis.set("id", "1"));
    System.out.println(jedis.set("name", "jack"));
}

//操作List
public void list() {

    // 从头添加
    jedis.lpush("list", "tom", "jack", "jason", "peter", "lc", "easy");

    // 从尾添加
    jedis.rpush("list", "andy", "eleven");

    // 返回List长度
    jedis.llen("list");

    // 取值
    List<String> list = jedis.lrange("list", 0, 15);
    for (String string : list) {
        System.out.println(string);
    }
}

//操作Map
public void map() {
    jedis.hset("Mcity", "c1", "北京");
    System.out.println("取值：" + jedis.hget("city", "c1"));

    Map<String, String> map = new HashMap<String, String>();
    map.put("c1", "桂林");
    map.put("c2", "天津");
    map.put("c3", "合肥");
    jedis.hmset("Mcity2", map);

    List<String> list = jedis.hmget("Mcity2", "c1", "c2", "c3");
    for (String string : list) {
        System.out.println(string);
    }
    System.out.println(jedis.hlen("Mcity2"));
}

//操作Set
public void set() {
    jedis.sadd("city", "北京", "上海", "南京", "武汉", "安徽", "广州", "深圳", "山东");
    System.out.println("取最上面的值：" + jedis.spop("city"));
    System.out.println("随机取值" + jedis.srandmember("city"));

    jedis.sadd("city2", "北京", "武汉", "河北", "张家界", "辽林", "云南", "陕西", "山西", "黑龙江");
    System.out.println("交集：" + jedis.sinter("city", "city1"));
    System.out.println("并集：" + jedis.sunion("city", "city1"));
    System.out.println("差集：" + jedis.sdiff("city", "city1"));
}

public static void main(String[] args) {
	
	 new RedisTest().save();
//     new RedisTest().update();
//     new RedisTest().findAll();
//     new RedisTest().del();
//     new RedisTest().key();
//     new RedisTest().string();
//     new RedisTest().list();
//     new RedisTest().map();
//     new RedisTest().set();
}
}
