package com.lx.market.service.impl;

import com.lx.market.bean.Supplier;
import com.lx.market.dao.SupplierDao;
import com.lx.market.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SupplierServiceImpl
 * @Description 供应商模块增删改查
 * @Author Administrator
 * @Date 2019/1/2 15:42
 */
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDao supplierDao;

	@Override
	public List<Supplier> findAll() {
		return supplierDao.findAll();
	}

	@Override
	public Supplier findOne(String id) {
		return supplierDao.findById(id);
	}

	@Override
	public void save(Supplier supplier) {
 		supplierDao.save(supplier);
	}

	@Override
	public void deleteById(String id) {
		supplierDao.delete(id);
	}


	@Override
	public List<Supplier> findSupplierNameLike(String supName) {
		return supplierDao.findSupNameLike(supName);
	}


	@Override
	public Supplier findBySupName(String desc) {
		return supplierDao.findBySupName(desc);
	}

	@Override
	public void updateSup(Supplier supplier) {
		supplierDao.update(supplier);
	}
}
