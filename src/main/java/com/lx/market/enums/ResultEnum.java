package com.lx.market.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	USER_NOT_EXISTS(1,"用户不存在"),
	USER_PASSWORD_ERROR(2,"用户密码不一致"),
	USERNAME_EXISTS(3,"用户名已存在"),
	USER_LOCKED(4,"用户已被锁定"),
	LOGIN_FAIL(5,"登录失败"),
	SUPPLIER_NOT_EXISTS(6,"商家不存在"),
	;

	private Integer code;
	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
