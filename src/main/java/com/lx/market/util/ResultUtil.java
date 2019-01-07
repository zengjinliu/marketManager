package com.lx.market.util;


import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/7 9:26
 */
@Data
public class ResultUtil<T> implements Serializable {

	private static final long serialVersionUID = 7830592343160115047L;

	private Integer code;
	private String msg;
	private T data;
}
