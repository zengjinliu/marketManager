package com.lx.market.service.impl;

import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;
import com.lx.market.dao.BillDao;
import com.lx.market.dao.SupplierDao;
import com.lx.market.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BillServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/4 9:12
 */
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	@Autowired
	private SupplierDao supplierDao;


	/**
	 * 删除指定账单
	 * @param id
	 */
	@Override
	public void deleteById(String id) {
		billDao.deleteById(id);
	}

	/**
	 * 模糊查询，两者同时满足
	 * @param word
	 * @param payStatus
	 * @return
	 */
	@Override
	public List<Bill> searchBill(String word, String payStatus) {
		Map<String,Object> map = new HashMap<>();
		if (payStatus.equals("是")){
			map.put("word",word);
			map.put("payStatus","1");
		} else if (payStatus.equals("否")) {
			map.put("word",word);
			map.put("payStatus","0");
		}
		return billDao.findLikeBill(map);
	}

	@Override
	public Bill findById(String billId) {
		return billDao.preLookBill(billId);
	}

	@Override
	public List<Bill> findAll() {
		return billDao.findAll();
	}

	/**
	 * 更新账单
	 * @param bill
	 */
	@Override
	@Transactional
	public void updateBill(Bill bill) {
		billDao.update(bill);
	}

	/**
	 * 根据支付状态模糊查询
	 * @param payStatus
	 * @return
	 */
	@Override
	public List<Bill> findLikeByPayStatus(String payStatus) {
		if (payStatus.equals("是")){
			payStatus = "1";
			return billDao.findLikeBillByPayStatus(payStatus);
		} else if (payStatus.equals("否")) {
			payStatus = "0";
			return billDao.findLikeBillByPayStatus(payStatus);
		}
		return null;

	}

	/**
	 * 添加账单
	 * @param bill
	 */
	@Override
	public void addBill(Bill bill) {
		//商品数量
		Integer productAmount = bill.getProductAmount();
		//商品单价
		String unitPrice = bill.getDealUnit();
		String[] split = unitPrice.split("￥");
		int price = Integer.parseInt(split[0]);
		//交易价格
		Integer dealPrice  = productAmount*price;
		bill.setDealPrice(new BigDecimal(dealPrice));
		System.out.println(bill.getPayStatus());
		billDao.addBill(bill);

	}

	/**
	 * 级联查询
	 * @return
	 */
	@Override
	public List<Bill> findSups() {
		return billDao.findSup();
	}
}
