package com.lx.market.service;


import com.lx.market.bean.Supplier;

import java.util.List;
import java.util.Map;

public interface SupplierService {
	//查询所有的供应商
	public List<Supplier> findAll();
	//查询单个供应商
	public Supplier findOne(String id);
	//增加供应商
	public void save(Supplier supplier);
	//删除供应商
	public void deleteById(String id);
	//修改商家信息
	public void updateSup(Supplier supplier);
	//模糊查询，依据供应商名称或者供应商描述
	public List<Supplier> findSupplierNameLike(String supName);
	//查询描述
	public Supplier findBySupName(String desc);



}
