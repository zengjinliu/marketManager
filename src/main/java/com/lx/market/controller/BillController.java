package com.lx.market.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.market.bean.Bill;
import com.lx.market.bean.Supplier;
import com.lx.market.bean.User;
import com.lx.market.service.BillService;
import com.lx.market.service.SupplierService;
import com.lx.market.util.ExportExcelUtil;
import com.lx.market.util.ExportExcelWrapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BillController
 * @Description 账单模块
 * @Author Administrator
 * @Date 2019/1/4 9:14
 */
@Controller
public class BillController {

	@Autowired
	private BillService billService;
	@Autowired
	private SupplierService supplierService;

	/**
	 * 查询所有账单
	 * @param map
	 * @return
	 */
	@RequestMapping("/billList")
	public ModelAndView billList(Map<String,Object> map,
								 @RequestParam(value = "pageNum",required = false) Integer pageNum){
		if (pageNum==null){
			pageNum=1;
		}
		PageHelper.startPage(pageNum,3);
		List<Bill> billList = billService.findSups();
		PageInfo<Bill> pageInfo = new PageInfo<>(billList);
		map.put("pageInfo",pageInfo);
		map.put("billList", billList);
		return new ModelAndView("bill_list", map);
	}

	/**
	 * 删除指定账单
	 * @param billId
	 * @return
	 */
	@RequestMapping("/delBill")
	public String delete(@RequestParam("billId") String billId){
		billService.deleteById(billId);
		return "redirect:/billList";
	}

	/**
	 * 来到添加账单页面
	 * @return
	 */
	@RequestMapping("/goAddBill")
	public ModelAndView goAddBill(Map<String,Object> map){
		List<Supplier> supplierList = supplierService.findAll();
		map.put("supplierList",supplierList);
		return new ModelAndView("bill_detail",map);
	}

	/**
	 * 添加账单
	 * @param bill
	 * @return
	 */
	@RequestMapping("/addBill")
	public String addBill(Bill bill){
		billService.addBill(bill);
		return "redirect:/billList";
	}

	/**
	 * 账单数据回显
	 * @param billId
	 * @param map
	 * @return
	 */
	@RequestMapping("/preLookBill")
	public ModelAndView  preLookBill(@RequestParam("billId") String billId,
									 Map<String,Object> map){
		Bill bill = billService.findById(billId);
		map.put("bill",bill);
		//来到预览模式将提交框隐藏
		String supId = bill.getSupId();
		Supplier supplier = supplierService.findOne(supId);
		map.put("supplier",supplier);
		map.put("n",1);
		return new ModelAndView("bill_detail",map);

	}

	/**
	 * 两者模糊查询同时生效
	 * @param word
	 * @param payStatus
	 * @return
	 */
	@RequestMapping("/findLikeBill")
	public ModelAndView findLikeBill(@RequestParam("word") String word,@RequestParam("payStatus") String payStatus,
									 Map<String,Object> map){
		List<Bill> billList = billService.searchBill(word, payStatus);
		map.put("billList",billList);
		return new ModelAndView("bill_list",map);
	}
	/**
	 * 根据支付状态进行模糊查询
	 * @param payStatus
	 * @param map
	 * @return
	 */
	@RequestMapping("/findLikeByPayStatus")
	public ModelAndView findBillByPayStatus(@RequestParam("payStatus") String payStatus,
											Map<String,Object> map){
		List<Bill> billList = billService.findLikeByPayStatus(payStatus);
		map.put("billList",billList);
		return new ModelAndView("bill_list",map);
	}

	/**
	 * 来到账单编辑页面
	 * @param billId
	 * @param map
	 * @return
	 */
	@RequestMapping("/editBill")
	public ModelAndView editBill(@RequestParam("billId") String billId,Map<String,Object> map){
		Bill bill = billService.findById(billId);
		map.put("bill",bill);
		String supId = bill.getSupId();
		Supplier supplier = supplierService.findOne(supId);
		map.put("supplier",supplier);
		//来到编辑页面，并修改表单的提交路径
		map.put("change",1);
		return new ModelAndView("bill_detail",map);
	}

	//更新账单
	@RequestMapping("/updateBill")
	public String updateBill(Bill bill,@RequestParam("supName") String supName){
		//动态计算出交易金额
		//TODO 解决同步修改的问题
		System.out.println(supName);
		Integer productAmount = bill.getProductAmount();
		String dealUnit = bill.getDealUnit();
		String[] split = dealUnit.split("￥");
		bill.setDealPrice(new BigDecimal(productAmount*Integer.parseInt(split[0])));
		//设置supId
		Supplier supplier = supplierService.findBySupName(supName);
		System.out.println(supplier.getSupId());
		bill.setSupId(supplier.getSupId());
		billService.updateBill(bill);
		return "redirect:/billList";
	}


}
