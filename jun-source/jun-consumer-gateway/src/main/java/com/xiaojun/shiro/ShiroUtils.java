package com.xiaojun.shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * shiro������
 * @author xiaojun
 * @email  lxjluoxiaojun@163.com
 * @date   2017��1��13��
 */
import com.xiaojun.entity.SysUserEntity;
public class ShiroUtils {
	/**
	 * ��ȡshiro��session
	 * @return
	 */
	public static Session getSession(){
		return SecurityUtils.getSubject().getSession();
	}
	/**
	 * ��ȡ����
	 * @return
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	/**
	 * ��shiro�л�ȡ��֤
	 * @return
	 */
	public static SysUserEntity getSysUserEntity(){
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}
	/**
	 * ��ȡ�û�id
	 * @return
	 */
	public static Integer getId() {
		return getSysUserEntity().getId();
	}
	/**
	 * �������ݵ�session��
	 * @param key
	 * @param value
	 */
	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}
	/**
	 * ��ȡsession�е�ֵ
	 * @param key
	 * @return
	 */
	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}
	/**
	 * �ж��û��Ƿ��¼��֤��
	 * @return
	 */
	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}
	/**
	 * �˳���¼
	 */
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	/**
	 * ��session�л�ȡ��֤��
	 * @param key
	 * @return
	 */
	public static String getKaptcha(String key){
		String kaptcha=getSessionAttribute(key).toString();
		getSession().removeAttribute(key);
		return kaptcha;
	}
}
