package com.lx.market.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName Bill
 * @Description 账单
 * @Author Administrator
 * @Date 2018/12/27 12:09
 */
@Data
public class Bill implements Serializable {
	//账单编号
	private String billId;
	//商品名称
	private String productName;
	//商品数量
	private Integer productAmount;
	//交易金额
	private BigDecimal dealPrice;
	//交易单位
	private String dealUnit;
	//支付状态 0代表未支付，1代表已支付
	private String payStatus;
	//供应商id
	private String supId;
	//供应商描述
	private String productDescription;
	//创建时间
	private Timestamp creatTime;
	//供应商
	private Supplier supplier;
	//每天交易金额总数


}
