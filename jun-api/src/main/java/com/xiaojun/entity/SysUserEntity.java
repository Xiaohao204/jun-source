package com.xiaojun.entity;

import java.io.Serializable;

public class SysUserEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4264694101670929097L;
	/**
	 * ����id
	 */
	private Integer id;
	/**
	 * �û���
	 */
	private String username;
	/**
	 * ����
	 */
	private String password;
	/**
	 * ��
	 */
	private String salt;
	/**
	 * ��������
	 */
	private String email;
	/**
	 * �ֻ��绰
	 */
	private String mobile;
	/**
	 * �û�״̬
	 */
	private String status;
	/**
	 * ����ʱ��
	 */
	private String createTime;
	/**
	 * ������
	 */
	private String createName;
	/**
	 * ����ʱ��
	 */
	private String updateTime;
	/**
	 * ������
	 */
	private String updateName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

}
