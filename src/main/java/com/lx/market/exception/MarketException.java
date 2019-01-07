package com.lx.market.exception;

import com.lx.market.enums.ResultEnum;

/**
 * @ClassName MarketException
 * @Description 自定义异常
 * @Author Administrator
 * @Date 2018/12/27 15:19
 */
public class MarketException extends RuntimeException{
	private Integer code;
	public MarketException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
//	public SellException(Integer code,String msg){
//		super(msg);
//		this.code=code;
//	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
