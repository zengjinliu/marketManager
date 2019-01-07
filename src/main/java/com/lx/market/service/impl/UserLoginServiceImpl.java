package com.lx.market.service.impl;

import com.lx.market.bean.User;
import com.lx.market.dao.UserDao;
import com.lx.market.enums.ResultEnum;
import com.lx.market.exception.MarketException;
import com.lx.market.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserLoginServiceImpl
 * @Description 用户实现类
 * @Author Administrator
 * @Date 2018/12/27 15:05
 */
@Service
@Slf4j
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserDao userDao;

	/**
	 * 删除指定的用户
	 * @param name
	 */
	@Override
	public void deleteOne(String name) {
		User user = userDao.findByName(name);
		if (user==null){
			throw new MarketException(ResultEnum.USER_NOT_EXISTS);
		}
		userDao.deleteByName(name);
	}

	/**
	 * 查询单个用户
	 * @param name
	 * @return
	 */
	@Override
	public User findOne(String name) {
		User user = userDao.findByName(name);
		if (user==null){
			log.error("【用户不存在】");
			throw new MarketException(ResultEnum.USER_NOT_EXISTS);
		}
		return user;
	}

	/**
	 * 预览用户
	 * @param userId
	 * @return
	 */
	@Override
	public User preLook(String userId) {
		User user = userDao.preLook(userId);
		if (StringUtils.isEmpty(user)){
			log.error("用户不存在");
			throw new MarketException(ResultEnum.USER_NOT_EXISTS);
		}
		return user;
	}

	/**
	 * 模糊查询
	 * @param keyWord
	 * @return
	 */
	@Override
	public List<User> findLike(String keyWord) {
		return userDao.findLike(keyWord);
	}

	/**
	 * 修改指定用户信息
	 * @param user
	 */
	@Override
	public void update(User user) {

		userDao.update(user);
	}

	/**
	 * 新增用户
	 * @param user
	 */
	@Override
	public void addUser(User user) {

		//表单提交用户不能为空
		if (user==null) {
			log.error("【用户不能为空】");
			throw new MarketException(ResultEnum.USER_NOT_EXISTS);
		}
		//查询数据库看用户是否已经存在
		User hasUser = userDao.findByName(user.getUsername());
		if(!StringUtils.isEmpty(hasUser)){
			log.error("【用户名已经存在】");
			throw new MarketException(ResultEnum.USERNAME_EXISTS);
		}
		//1:加密方式String algorithmName = "MD5";
		//2:密码Object source = "123456";
		//盐值加密ByteSource salt = ByteSource.Util.bytes("jason");
		//加密次数 hashIterations
		Object result = new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024);
		user.setPassword(result.toString());
		userDao.save(user);
	}

	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> findAll(){
		return userDao.findAll();
	}
}
