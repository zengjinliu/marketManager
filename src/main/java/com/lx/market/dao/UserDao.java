package com.lx.market.dao;

import com.lx.market.bean.User;

import java.util.List;

public interface UserDao {
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 根据username 查询指定的用户
	 * @param name
	 * @return
	 */
	public User findByName(String name);

	/**
	 * 新增用户
	 * @param user
	 */
	public void save(User user);

	//根据id，删除指定的用户
	public void deleteByName(String name);

	//修改用户信息
	public void update(User user);

	//模糊查询
	public List<User> findLike(String keyWord);

	//预览用户
	public User preLook(String userId);
}
