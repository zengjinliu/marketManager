package com.lx.market.dao;

import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;

import java.util.List;

public interface ChartDao {
	//每天的交易金额，柱形图
	public List<Bill> findBillCylindrical();
	//每天的账单数量
	public List<Bill> findBillLine();
	//每月供应商数量
	public List<Supplier> findPie();
}
