package com.xiaojun.service;
import com.xiaojun.entity.SysUserEntity;
/**
 * �û�����
 * @author xiaojun
 * @email  lxjluoxiaojun@163.com
 * @date   2017��1��12��
 */
public interface SysUserService {
	/**
	 * �����û�����ȡ�û���Ϣ
	 * @param userName
	 * @return
	 */
	public SysUserEntity selectSysUserByUserName(String userName);
}
