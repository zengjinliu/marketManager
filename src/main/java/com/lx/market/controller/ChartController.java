package com.lx.market.controller;

import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;
import com.lx.market.service.ChartService;
import com.lx.market.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName ChartController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/1/7 9:37
 */
@Controller
public class ChartController {

	@Autowired
	private ChartService chartService;

	/**
	 * 查询每天账单总交易额，并形成柱形图
	 * @return
	 */
	@RequestMapping("/getJson")
	@ResponseBody
	public ResultUtil<List<Bill>> getJson(){
		ResultUtil<List<Bill>> result = chartService.findAll();
		return result;
	}

	/**
	 * 每天的交易账单总数，折线图
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getLineJson")
	public ResultUtil<List<Bill>> getLineJson(){
		ResultUtil<List<Bill>> result = chartService.findLines();
		return result;
	}

	/**
	 * 每月的供应商数量
	 * @return
	 */
	@RequestMapping("/getPieData")
	@ResponseBody
	public ResultUtil<List<Supplier>> getPieJson(){
		ResultUtil<List<Supplier>> result = chartService.findPie();
		return result;
	}
}
