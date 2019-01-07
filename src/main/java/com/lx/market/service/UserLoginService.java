package com.lx.market.service;

import com.lx.market.bean.User;
import org.apache.shiro.authz.annotation.RequiresRoles;

import java.util.List;

public interface UserLoginService {

	//增加用户
	public void addUser(User user);
	//查询单个用户
	public User findOne(String name);
	//删除指定用户
	public void deleteOne(String name);
	//修改指定用户信息
	public void update(User user);
	//模糊查询
	public List<User> findLike(String keyWord);
	//预览用户
	public User preLook(String userId);

}
