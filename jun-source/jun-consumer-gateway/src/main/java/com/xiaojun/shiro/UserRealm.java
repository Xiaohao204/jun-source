package com.xiaojun.shiro;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaojun.entity.SysUserEntity;
import com.xiaojun.service.SysUserService;

/**
 * ��֤����Ȩrealm
 * 
 * @author xiaojun
 * @email lxjluoxiaojun@163.com
 * @date 2017��1��12��
 */
public class UserRealm extends AuthorizingRealm {

	@Reference
	private SysUserService sysUserService;

	private Cache<String, AtomicInteger> passwordRetryCache;

	public UserRealm(CacheManager cacheManager) {
		passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	/**
	 * ��Ȩ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection paramPrincipalCollection) {
		return null;
	}

	/**
	 * ��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// ��token�л�ȡ�û���������
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		// �����ݿ����ȡ�û���Ϣ
		SysUserEntity user = sysUserService.selectSysUserByUserName(username);
		// �˺Ų�����
		if (user == null) {
			throw new UnknownAccountException("�˺Ż����벻��ȷ");
		}
		AtomicInteger retryCount = passwordRetryCache.get(user.getUsername());
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			passwordRetryCache.put(user.getUsername(), retryCount);
		}
		// �Զ���һ����֤���̣����û����������������3�����Ͻ�ֹ�û���¼һ��ʱ��
		if (retryCount.incrementAndGet() > 3) {
			throw new ExcessiveAttemptsException("����������󳬹�3��,�����ʱ������");
		}
		// �������
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("�˺Ż����벻��ȷ");
		}
		passwordRetryCache.remove(user.getUsername());
		// �˺�����
		if ("2".equals(user.getStatus())) {
			throw new LockedAccountException("�˺��ѱ�����,����ϵ����Ա");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}
