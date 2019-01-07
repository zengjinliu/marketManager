package com.lx.market.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.market.bean.User;
import com.lx.market.enums.ResultEnum;
import com.lx.market.exception.MarketException;
import com.lx.market.service.impl.UserLoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserLoginController
 * @Description 用户登录
 * @Author Administrator
 * @Date 2018/12/27 15:37
 */
@Controller
@Slf4j
public class UserLoginController {
	private static int n = 0;

	@Autowired
	private UserLoginServiceImpl userLoginService;

	/**
	 * 用户的登录
	 *
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpSession session, Map<String, Object> map) {
		//TODO 用户三次的登录失败则显示验证码
		//1:获取subject
		Subject subject = SecurityUtils.getSubject();
		session.setAttribute("username", username);
		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			//执行subject 的login方法
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				map.put("count", n++);
				return "login";
			}
		}
		return "success";
	}


	@RequestMapping("/users")
	public ModelAndView findAll(Map<String, Object> map,@RequestParam(value = "pageNum",required = false) Integer pageNum)  {
		if (pageNum==null){
			pageNum=1;
		}
		PageHelper.startPage(pageNum,3);
		List<User> userList = userLoginService.findAll();
		PageInfo<User> pageInfo = new PageInfo<>(userList);
		map.put("pageInfo",pageInfo);
		map.put("userList", userList);
		return new ModelAndView("user_list", map);
	}


}
