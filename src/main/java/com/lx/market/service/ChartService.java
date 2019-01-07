package com.lx.market.service;

import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;
import com.lx.market.util.ResultUtil;

import java.util.List;

public interface ChartService {
	//每天的账单交易金额，柱形图
	public ResultUtil<List<Bill>> findAll();
	//每天的交易账单总数
	public ResultUtil<List<Bill>> findLines();
	//每月供应商数量
	public ResultUtil<List<Supplier>> findPie();
}
