package com.xiaojun.cache.jedis;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;

/**
 * redis�����ͻ���
 * 
 * @author xiaojun
 * @email lxjluoxiaojun@163.com
 * @date 2017��2��9��
 */
@Repository("redisClientTemplate")
public class RedisClientTemplate {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private JedisDataSource jedisDataSource;

	public void disconnect() {
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		shardedJedis.disconnect();
	}

	/**
	 * ���õ���ֵ
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(String key, String value) {
		logger.info("���õ�key��value" + key + ":" + value);
		String result = null;
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			result = shardedJedis.set(key, value);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedisDataSource.returnResource(shardedJedis);
		}
		return result;
	}

	/**
	 * ��ȡ����ֵ
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		logger.info("��Ҫ��ȡ��ֵ" + key);
		String result = null;
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			result = shardedJedis.get(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedisDataSource.returnResource(shardedJedis);
		}
		return result;
	}

	/**
	 * �ж�key�Ƿ����
	 */
	public Boolean exists(String key) {
		Boolean result = false;
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			result = shardedJedis.exists(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedisDataSource.returnResource(shardedJedis);
		}
		return result;
	}

	/**
	 * ����key��ĳ��ʱ���ʧЧ
	 * 
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(String key, int seconds) {
		Long result = null;
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			result = shardedJedis.expire(key, seconds);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedisDataSource.returnResource(shardedJedis);
		}
		return result;
	}

	/**
	 * ����ĳ��key��ĳ��ʱ���ʧЧ
	 * 
	 * @param key
	 * @param unixTime
	 * @return
	 */
	public Long expireAt(String key, long unixTime) {
		Long result = null;
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			result = shardedJedis.expireAt(key, unixTime);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedisDataSource.returnResource(shardedJedis);
		}
		return result;
	}

	/**
	 * ��ȡĳ��key���ڵ�ʣ��ʱ��(��)
	 * 
	 * @param key
	 * @return
	 */
	public Long ttl(String key) {
		Long result = null;
		ShardedJedis shardedJedis = jedisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		try {
			result = shardedJedis.ttl(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedisDataSource.returnResource(shardedJedis);
		}
		return result;
	}
}
