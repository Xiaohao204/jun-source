package com.xiaojun.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.xiaojun.dto.UserDTO;
import com.xiaojun.entity.SysUserEntity;
import com.xiaojun.exception.CustomException;

/**
 * 系统用户service
 * 
 * @author xiaojun
 * @email lxjluoxiaojun@163.com
 * @date 2017年1月16日
 */
public interface SysUserService {
	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public SysUserEntity selectSysUserByUserName(String userName) throws CustomException;

	/**
	 * 根据用户名更新密码
	 * 
	 * @param map
	 * @return
	 * @throws CustomException
	 */
	public int updatePassword(Map<String, Object> map) throws CustomException;

	/**
	 * 查询用户集合
	 * 
	 * @param map
	 * @return
	 * @throws CustomException
	 */
	public PageInfo<SysUserEntity> queryList(UserDTO dto) throws CustomException;

	/**
	 * 根据用户id获取角色id集合
	 * 
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	public List<Integer> getRoleIdsByUserId(Integer userId) throws CustomException;

	/**
	 * 根据用户id获取用户信息
	 * 
	 * @param userId
	 * @return
	 * @throws CustomException
	 */
	public SysUserEntity queryUser(Integer userId) throws CustomException;

	/**
	 * 保存
	 * @param user
	 * @return
	 * @throws CustomException
	 */
	public Integer save(SysUserEntity user) throws CustomException;
	
	/**
	 * 更新
	 * @param user
	 * @return
	 * @throws CustomException
	 */
	public Integer update(SysUserEntity user) throws CustomException;
	/**
	 * 保存用户角色关联
	 * @throws CustomException
	 */
	public void saveUserRole(Map<String, Object> map) throws CustomException;
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws CustomException
	 */
	public Integer deleteBatch(Integer[] ids) throws CustomException;
}
