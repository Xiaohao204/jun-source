package com.xiaojun.dao;

import com.xiaojun.entity.SysUserEntity;

public interface SysUserDao extends BeseDao<SysUserEntity>{

	/**
	 * �������������û���Ϣ
	 * @return
	 */
	public SysUserEntity selectSysUserByUserName(String username);
}
