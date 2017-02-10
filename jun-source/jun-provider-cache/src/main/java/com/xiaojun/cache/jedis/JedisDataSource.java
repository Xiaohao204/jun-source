package com.xiaojun.cache.jedis;

import redis.clients.jedis.ShardedJedis;

/**
 * jedis����Դ
 * @author xiaojun
 * @email  lxjluoxiaojun@163.com
 * @date   2017��2��9��
 */
public interface JedisDataSource {
	/**
	 * ��ȡ�ͻ�������
	 * @return
	 */
	ShardedJedis getRedisClient();
	/**
	 * ������Դ
	 * @param shardedJedis
	 */
	void returnResource(ShardedJedis shardedJedis);
	
}
