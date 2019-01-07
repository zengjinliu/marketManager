package com.lx.market.service.impl;

import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;
import com.lx.market.dao.BillDao;
import com.lx.market.dao.ChartDao;
import com.lx.market.service.ChartService;
import com.lx.market.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @ClassName CharServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/7 9:28
 */
@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	private ChartDao chartDao;

	/**
	 * 查询每月供应商数量
	 * @return
	 */
	@Override
	public ResultUtil<List<Supplier>> findPie() {
		ResultUtil<List<Supplier>> result = new ResultUtil<>();
		List<Supplier> pie = chartDao.findPie();
		if (!StringUtils.isEmpty(pie)){
			result.setCode(0);
			result.setMsg("查询数据完成");
			result.setData(pie);
		}else {
			result.setCode(1);
			result.setMsg("查询数据失败");
			result.setData(null);
		}
		return result;
	}

	/**
	 * 查询每日的交易订单总数，折线图
	 * @return
	 */
	@Override
	public ResultUtil<List<Bill>> findLines() {
		ResultUtil<List<Bill>> result = new ResultUtil<>();
		List<Bill> billList = chartDao.findBillLine();
		if (!StringUtils.isEmpty(result)) {
			result.setCode(0);
			result.setMsg("查询每日账单数成功");
			result.setData(billList);
		}else {
			result.setCode(1);
			result.setMsg("查询每日账单数失败");
			result.setData(null);
		}
		return result;
	}

	/**
	 * 查询每天账单的总交易金额，柱形图
	 * @return
	 */
	@Override
	public ResultUtil<List<Bill>> findAll() {
		ResultUtil<List<Bill>> result = new ResultUtil<>();
		List<Bill> billList = chartDao.findBillCylindrical();
		if (!StringUtils.isEmpty(billList)) {
			result.setCode(0);
			result.setMsg("查询成功");
			result.setData(billList);
		}else {
			result.setCode(1);
			result.setMsg("查询失败");
			result.setData(null);
		}
		return result;
	}
}
