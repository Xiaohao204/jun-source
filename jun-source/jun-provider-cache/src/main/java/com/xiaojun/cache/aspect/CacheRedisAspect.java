package com.xiaojun.cache.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiaojun.cache.jedis.RedisClientTemplate;
import com.xiaojun.util.GSONUtils;

/**
 * redis ��������
 * 
 * @author xiaojun
 * @email lxjluoxiaojun@163.com
 * @date 2017��2��10��
 */
@Component
@Aspect
public class CacheRedisAspect {
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private RedisClientTemplate redisClientTemplate;

	@Pointcut("execution(* com.xiaojun.cache.*.*(..))")
	public void cacheRedisPointcut() {
	};

	public Object getCache(ProceedingJoinPoint point) {
		Object[] args = point.getArgs();
		String key = null;
		if (args != null && args.length != 0) {
			key = (String) args[0];
		}
		String value = null;
		try {
			value = redisClientTemplate.get(key);
		} catch (Exception e) {
			logger.warn("redis��ȡ����ʧ��" + e.getMessage(), e);
			try {
				value = getResultByDB(point, args, key);
			} catch (Throwable e1) {
				logger.error("������" + e.getMessage(), e);
			}
		}
		if ("".equals(value)) {
			try {
				return getResultByDB(point, args, key);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return value;

	}

	private String getResultByDB(ProceedingJoinPoint point, Object[] args, String key) throws Throwable {
		String value;
		// ִ��Ŀ�귽���������ݿ��л�ȡ
		Object proceed = point.proceed(args);
		// �����ת��Ϊjson��ʽ
		value = GSONUtils.toJson(proceed, false);
		// ���뻺��
		redisClientTemplate.set(key, value);
		return value;
	}
}
