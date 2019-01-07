package com.lx.market.controller;

import com.lx.market.bean.User;
import com.lx.market.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName FunctionController
 * @Description 表单头部controller
 * @Author Administrator
 * @Date 2018/12/29 10:58
 */
@Controller
public class FunctionController {

	@Autowired
	private UserLoginService userLoginService;
	/**
	 * 返回首页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "success";
	}

	/**
	 * clear缓存
	 */
	@RequestMapping("/clear")
	public String clear(HttpServletResponse response){
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		return "success";
	}

	/**
	 * 账号设置
	 * @param username
	 * @param map
	 * @return
	 */
	@RequestMapping("/editUser")
	public ModelAndView edit(@RequestParam("username") String username,
							 Map<String,Object> map, HttpSession session){
		User user = userLoginService.findOne(username);
		map.put("user",user);
		return new ModelAndView("user_edit",map);
		//TODO 用户名修改后，如何让用户头像下的姓名
	}


}
