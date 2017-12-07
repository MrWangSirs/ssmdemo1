package com.cdtu.cache;


import redis.clients.jedis.Jedis;


public class RedisCache {  
    
	Jedis jedis=new Jedis("127.0.0.1", 6379);
      
  
    //��redis�����в�ѯ�������л�  
    public Object getDataFromRedis(String redisKey){  
        //��ѯ  
    
        byte[] result = jedis.get(redisKey.getBytes());  
          
        //�����ѯû��Ϊ��  
        if(null == result){  
            return null;  
        }  
          
    
        //��ѯ���ˣ������л�  
        return SerializeUtil.unSerialize(result);  
    }  
      
    //�����ݿ��в�ѯ�������ݷ���redis  
    public void setDataToRedis(String redisKey, Object obj){  
          
        //���л�  
        byte[] bytes = SerializeUtil.serialize(obj);  
        //����redis  
        
        String success = jedis.set(redisKey.getBytes(), bytes);  
          
        if("OK".equals(success)){  
            System.out.println("���ݳɹ����浽redis...");  
        }  
    }  
}  
