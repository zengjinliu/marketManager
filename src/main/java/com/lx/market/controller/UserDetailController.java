package com.lx.market.controller;

import com.lx.market.bean.User;
import com.lx.market.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDetailController
 * @Description 用户模块
 * @Author Administrator
 * @Date 2018/12/27 17:56
 */
@Controller
@Slf4j
public class UserDetailController {
	@Autowired
	private UserLoginService userLoginService;

	/**
	 * 来到用户详情页
	 * @return
	 */
	@RequestMapping("/userDetail")
	public String userDetail(){
		return "user_detail";
	}

	/**
	 * 添加用户，重定向到用户详情页
	 * @return
	 */
	@RequestMapping("/addUser")
	public ModelAndView addUser(User user){
		if (user==null){
			return new ModelAndView("redirect:/userDetail");
		}
		userLoginService.addUser(user);
		return new ModelAndView("redirect:/users");
	}

	/**
	 * 删除指定的用户
	 * @param name
	 * @return
	 */
	@RequestMapping("/deleteOne")
	public ModelAndView delete(@RequestParam("username") String name){
         userLoginService.deleteOne(name);
		return new ModelAndView("redirect:/users");
	}


	/**
	 * 来到修改页面，并进行信息回显
	 * @param name
	 * @param map
	 * @return
	 */
	@RequestMapping("/edit")
	public ModelAndView update(@RequestParam("username") String name,Map<String,Object> map){
		User user = userLoginService.findOne(name);
		map.put("user",user);
		map.put("edit",1);
		return new ModelAndView("user_detail",map);

	}

	/**
	 * 修改完成后，跳转到用户界面
	 * @return
	 */
	@RequestMapping("/modUser")
	public ModelAndView modUser(User user){
		String username = user.getUsername();
		//从数据库查出来的密码
		User odlUser = userLoginService.findOne(username);
		if (odlUser.getPassword()==user.getPassword()){
			Object result = new SimpleHash("MD5",user.getPassword(),user.getUsername(),1024);
			user.setPassword(result.toString());
		}
		userLoginService.update(user);
		return new ModelAndView("redirect:/users");
	}

	/**
	 * 模糊查询
	 * @return
	 */
	@RequestMapping("/findLike")
	public ModelAndView findLike(@RequestParam("keyWord") String keyWord,
								 Map<String,Object> map){
		List<User> userList = userLoginService.findLike(keyWord);
		map.put("userList",userList);
		return new ModelAndView("user_list",map);
	}

	/**
	 * 预览用户
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/preLook")
	public ModelAndView preLook(@RequestParam("userId") String userId,
								Map<String,Object> map){
		User user = userLoginService.preLook(userId);
		map.put("user",user);
		map.put("n",1);
		return new ModelAndView("user_detail",map);
	}

	public static void main(String[] args) {
		Object result = new SimpleHash("MD5","123456","jason",1024);
		System.out.println(result);
	}

}
