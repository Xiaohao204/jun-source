package com.xiaojun.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * ������Դ·��
 * @author xiaojun
 * @email  lxjluoxiaojun@163.com
 * @date   2017��1��11��
 */
public class MultipleDataSource extends AbstractRoutingDataSource {
	/**
	 * Ϊÿ���߳̿���һ���ռ�
	 */
	private static final ThreadLocal<String> dataSourceKey =new ThreadLocal<>(); 
	/**
	 * ��������Դ
	 * @param dataSource
	 */
	public static void setDataSourceKey(String dataSource){
		dataSourceKey.set(dataSource);
	}
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey.get();
	}

}
