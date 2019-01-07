package com.lx.market.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lx.market.bean.Supplier;
import com.lx.market.enums.ResultEnum;
import com.lx.market.exception.MarketException;
import com.lx.market.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SupplierController
 * @Description 供应商模块
 * @Author Administrator
 * @Date 2019/1/2 15:56
 */
@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	//来带供应商列表界面,并进行信息分页显示
	@RequestMapping("/supplierList")
	public ModelAndView goSupList(Map<String,Object> map, @RequestParam(value = "pageNum",required = false) Integer pageNum){
		if (pageNum==null){
			pageNum=1;
		}
		PageHelper.startPage(pageNum,3);
		List<Supplier> supplierList = supplierService.findAll();
		PageInfo<Supplier> pageInfo = new PageInfo<>(supplierList);
		map.put("pageInfo",pageInfo);
		map.put("supplierList",supplierList);
		return new ModelAndView("supplier_list",map);
	}
	//来到供应商详情页面
	@RequestMapping("/supplierDetail")
	public ModelAndView goSupDetail(){
		return new ModelAndView("supplier_detail");
	}

	//添加供应商,来到添加页面
	@RequestMapping("/goaddSup")
	public String addSup(){
		return "supplier_detail";
	}

	//添加供应商
	@RequestMapping("/addSup")
	public String addSup(Supplier supplier){
		supplierService.save(supplier);
		return "redirect:/supplierList";
	}
	//删除指定员工
	@RequestMapping("/delSup")
	public String delSup(@RequestParam("id") String id){
		supplierService.deleteById(id);
		return "redirect:/supplierList";
	}

	//修改商家信息,来到编辑模式
	@RequestMapping("/editSup")
	public String editSup(@RequestParam("id") String id,Map<String,Object> map){
		Supplier supplier = supplierService.findOne(id);
		if (supplier==null){
			throw new MarketException(ResultEnum.SUPPLIER_NOT_EXISTS);
		}
		map.put("edit",1);
		map.put("supplier",supplier);
		return "supplier_detail";
	}

	//修改后的商家信息提交
	@RequestMapping("/update")
	public ModelAndView update(Supplier supplier){
		supplierService.updateSup(supplier);
		return new ModelAndView("redirect:/supplierList");
	}
	//预览商家信息
	@RequestMapping("/prevLook")
	public String prevLook(@RequestParam("id") String id,Map<String,Object> map){
		Supplier supplier = supplierService.findOne(id);
		map.put("supplier",supplier);
		map.put("previous",2);
		return "supplier_detail";
	}
	//根据商家名称进行模糊查询
	@RequestMapping("/findLikeSupplier")
	public ModelAndView findSupName(@RequestParam(value = "supname") String supName,Map<String,Object> map){
		List<Supplier> supplierList = supplierService.findSupplierNameLike(supName);
		map.put("supplierList",supplierList);
		return new ModelAndView("supplier_list",map);
	}
	@RequestMapping("/findLikeSuppliers")
	public ModelAndView findSupDesc(@RequestParam(value = "supdesc") String supdesc,Map<String,Object> map){
		List<Supplier> supplierList = supplierService.findSupplierNameLike(supdesc);
		map.put("supplierList",supplierList);
		return new ModelAndView("supplier_list",map);
	}

}
