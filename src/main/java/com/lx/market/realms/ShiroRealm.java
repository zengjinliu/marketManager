package com.lx.market.realms;

import com.lx.market.bean.User;
import com.lx.market.enums.ResultEnum;
import com.lx.market.exception.MarketException;
import com.lx.market.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description 用户登录
 * @Author Administrator
 * @Date 2018/12/29 12:27
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserLoginService userLoginService;
	/**
	 * 实现用户的授权
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object principal = principals.getPrimaryPrincipal();
		Set<String> roles = new HashSet<>();
		User user = userLoginService.findOne(principal.toString());
		if (user.getUserRight().equals("1")){
			roles.add("admin");
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		return info;
	}

	/**
	 * 实现用户的认证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1:将username封装成usernamePasswordToken对象
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2:从该对象中获取用户名和密码(前台传过来的用户名)
		String username = upToken.getUsername();
		//判断当前的用户名是否在数据库中存在
		User user = userLoginService.findOne(username);
		if (user==null){
			throw new MarketException(ResultEnum.USER_NOT_EXISTS);
		}
		if (user.getUserStatus().equals("1")){
			throw new MarketException(ResultEnum.USER_LOCKED);
		}
		//4：返回一个AuthenticationInfo 的子对象(一下信息是要从数据库中查询出来的)
		//用户名
		Object principal = username;
		//MD5盐值加密
		String hashedCredentials = user.getPassword();

		//盐
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
		//realName 通过当前对象getRealm()方法获得
		String realmName = getName();

		SimpleAuthenticationInfo info = null;
		info = new SimpleAuthenticationInfo(principal,hashedCredentials,credentialsSalt,realmName);
		return info;
	}


	public static void main(String[] args) {
		//1:加密方式
		String algorithmName = "MD5";
		//2:密码
		Object source = "123456";
		//盐值加密
		ByteSource salt = ByteSource.Util.bytes("jason");
		//加密次数
		int hashIterations = 1024;

		Object result = new SimpleHash(algorithmName,source,salt,hashIterations);
		System.out.println(result);
	}
}
