package com.lx.market.controller;

import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;
import com.lx.market.service.BillService;
import com.lx.market.service.SupplierService;
import com.lx.market.util.ExportExcelUtil;
import com.lx.market.util.ExportExcelWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName ExportExcel
 * @Description 导出Excel表格
 * @Author Administrator
 * @Date 2019/1/3 16:00
 */
@Controller
public class ExportExcelController {
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private BillService billService;


	/**
	 * 导出供应商Excel表格
	 * @param req
	 * @param res
	 */
	@RequestMapping("/exportExcel")
	public void getExcel(HttpServletRequest req,
						 HttpServletResponse res){
		List<Supplier> supplierList = supplierService.findAll();
		String[] columeNames ={"编号","供应商名称","供应商描述","联系人","电话","传真","地址","创建时间","修改时间"};
		String fileName = "供应商表";
		String title = "供应商表";
		ExportExcelWrapper<Supplier> util = new ExportExcelWrapper<>();
		util.exportExcel(fileName,title,columeNames,supplierList,res, ExportExcelUtil.EXCEL_FILE_2003);
	}

	/**
	 * 导出账单Excel表格
	 * @param req
	 * @param res
	 */
	@RequestMapping("/exportExcelBill")
	public void exportExcelBill(HttpServletRequest req, HttpServletResponse res){
		List<Bill> billList = billService.findAll();
		String[] columeNames ={"编号","商品名称","商品数量","交易金额","是否付款","交易单位","供应商名称","商品描述","账单时间"};
		String fileName = "账单表";
		String title = "账单表";
		ExportExcelWrapper<Bill> util = new ExportExcelWrapper<>();
		util.exportExcel(fileName,title,columeNames,billList,res, ExportExcelUtil.EXCEL_FILE_2003);

	}

}
