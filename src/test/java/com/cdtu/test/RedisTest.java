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

//����Key�޸�����
public void update(){
    jedis.rename("a", "jedis_new");
}

//����Keyɾ������
public void del() {
    jedis.del("jedis");
}

//����key
public void key() {
    System.out.println(jedis.exists("id"));
    System.out.println(jedis.del("id"));
}

//����String
public void string() {
    System.out.println(jedis.set("id", "1"));
    System.out.println(jedis.set("name", "jack"));
}

//����List
public void list() {

    // ��ͷ���
    jedis.lpush("list", "tom", "jack", "jason", "peter", "lc", "easy");

    // ��β���
    jedis.rpush("list", "andy", "eleven");

    // ����List����
    jedis.llen("list");

    // ȡֵ
    List<String> list = jedis.lrange("list", 0, 15);
    for (String string : list) {
        System.out.println(string);
    }
}

//����Map
public void map() {
    jedis.hset("Mcity", "c1", "����");
    System.out.println("ȡֵ��" + jedis.hget("city", "c1"));

    Map<String, String> map = new HashMap<String, String>();
    map.put("c1", "����");
    map.put("c2", "���");
    map.put("c3", "�Ϸ�");
    jedis.hmset("Mcity2", map);

    List<String> list = jedis.hmget("Mcity2", "c1", "c2", "c3");
    for (String string : list) {
        System.out.println(string);
    }
    System.out.println(jedis.hlen("Mcity2"));
}

//����Set
public void set() {
    jedis.sadd("city", "����", "�Ϻ�", "�Ͼ�", "�人", "����", "����", "����", "ɽ��");
    System.out.println("ȡ�������ֵ��" + jedis.spop("city"));
    System.out.println("���ȡֵ" + jedis.srandmember("city"));

    jedis.sadd("city2", "����", "�人", "�ӱ�", "�żҽ�", "����", "����", "����", "ɽ��", "������");
    System.out.println("������" + jedis.sinter("city", "city1"));
    System.out.println("������" + jedis.sunion("city", "city1"));
    System.out.println("���" + jedis.sdiff("city", "city1"));
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
