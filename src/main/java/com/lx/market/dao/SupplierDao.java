package com.lx.market.dao;

import com.lx.market.bean.Supplier;

import java.util.List;

public interface SupplierDao {
	//查询所有供应商
	public List<Supplier> findAll();
	//增加供应商
	public void save(Supplier supplier);
	//查询单个供应商
	public Supplier findById(String id);
	//修改供应商信息
	public void update(Supplier supplier);
	//删除供应商信息
	public void delete(String id);
	//根据供应商名称模糊查询或者供应商描述
	public List<Supplier> findSupNameLike(String supName);
	//根据商品名称查询供应商
	public Supplier findSupByName(String name);
	//商品描述
	public Supplier findBySupName(String supName);


}
