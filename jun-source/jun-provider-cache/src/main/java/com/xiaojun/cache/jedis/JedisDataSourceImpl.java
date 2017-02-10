package com.xiaojun.cache.jedis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Jedis ʵ��
 * 
 * @author xiaojun
 * @email lxjluoxiaojun@163.com
 * @date 2017��2��9��
 */
@Repository("JedisDataSource")
public class JedisDataSourceImpl implements JedisDataSource {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	@Override
	public ShardedJedis getRedisClient() {
		ShardedJedis shardedJedis = null;
		try {
			shardedJedis = shardedJedisPool.getResource();
			return shardedJedis;
		} catch (Exception e) {
			logger.error("��ȡjedis����Դʧ��",e);
			if (shardedJedis != null) {
				shardedJedis.close();
			}
		}
		return null;
	}

	@Override
	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedis.close();
	}

}
