package com.xiaojun.dao;

import com.xiaojun.annotation.SlaveDataSource;
import com.xiaojun.entity.TestEntity;

public interface TestDao extends BeseDao<TestEntity> {
	/**
	 * ����������ȡ����
	 * @param id
	 * @return
	 */
	@SlaveDataSource("dataSource")
	String queryNameById(Integer id);
}
