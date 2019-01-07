package com.lx.market.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @ClassName User
 * @Description 用户
 * @Author Administrator
 * @Date 2018/12/27 11:01
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1655010896880345316L;
	//用户Id
	private String userId;
	//用户名
	private String username;
	//密码
	private String password;
	//性别 0代表女，1代表男
	private String sex;
	//用户年龄
	private Integer age;
	//用户电话
	private String userPhone;
	//用户地址
	private String userAddress;
	//用户权限 0代表普通员工，1代表经理'
	private String userRight;
	//用户状态 0代表正常，1代表锁住
	private String userStatus;
	//创建时间
	private Timestamp creatTime;
	//修改时间
	private Timestamp updateTime;

}
