package com.lx.market.dao;

import com.lx.market.bean.Bill;

import java.util.List;
import java.util.Map;

public interface BillDao {
	//级联查询
	public List<Bill> findSup();
	//删除指定账单
	public void deleteById(String billId);
	//添加账单
	public void addBill(Bill bill);
	//查询所有的账单
	public List<Bill> findAll();
	//预览账单
    public Bill preLookBill(String billId);
    //模糊查询,两者同时满足
	public List<Bill> findLikeBill(Map params);
	//只根据付款状态进行模糊查询
	public List<Bill> findLikeBillByPayStatus(String payStatus);
	//更新账单
	public void update(Bill bill);

}
