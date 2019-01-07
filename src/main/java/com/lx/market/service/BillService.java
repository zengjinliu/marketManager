package com.lx.market.service;

import com.lx.market.bean.Bill;

import java.util.List;

public interface BillService {
	//级联查询
	public List<Bill> findSups();
	//删除指定账单
	public void deleteById(String id);
	//增加账单
	public void addBill(Bill bill);
	//查询所有的账单
	public List<Bill> findAll();
    //查询单个账单(预览功能实现)
    public Bill findById(String billId);
    //模糊查询，两个条件同时满足
	public List<Bill> searchBill(String word,String payStatus);
	//根据支付状态模糊查询
	public List<Bill> findLikeByPayStatus(String payStatus);
	//更新账单
	public void updateBill(Bill bill);
}
