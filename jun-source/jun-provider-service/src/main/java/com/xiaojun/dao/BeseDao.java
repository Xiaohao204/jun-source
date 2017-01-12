package com.xiaojun.dao;

import java.util.List;
import java.util.Map;
/**
 * ����Dao ��Ҫ��Ӧÿ��xml������Ӧ��sql
 * @author xiaojun
 * @email  lxjluoxiaojun@163.com
 * @date   2017��1��10��
 * @param <T>
 */
public interface BeseDao<T> {

	int save(T t);
	
	void save(Map<String, Object> map);
	
	void saveBath(List<T> list);
	
	int update(T t);
	
	int update(Map<String, Object> map);
	
	int delete(Object id);
	
	int delete(Map<String, Object> map);
	
	int deleteBatch(Object[] id);
	
	T queryObject(Object id);
	
	List<T> queryList(Map<String, Object> map);
	
	List<T> queryList(Object id);
	
	int queryTotal(Map<String, Object> map);

	int queryTotal();
}
