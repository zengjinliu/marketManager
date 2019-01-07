package com.lx.market.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName Supplier
 * @Description 供应商
 * @Author Administrator
 * @Date 2018/12/27 12:02
 */

public class Supplier implements Serializable {

	//供应商id
	private String supId;
	//供应商名字
	private String supName;
	//供应商描述
	private String supDescription;
	//联系人
	private String supContact;
	//供应商电话
	private String supPhone;
	//供应商传真
	private String supFax;
	//供应商地址
	private String supAddress;
	//创建时间
	private Timestamp creatTime;
	//修改时间
	private Timestamp updateTime;


	public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupDescription() {
		return supDescription;
	}

	public void setSupDescription(String supDescription) {
		this.supDescription = supDescription;
	}

	public String getSupContact() {
		return supContact;
	}

	public void setSupContact(String supContact) {
		this.supContact = supContact;
	}

	public String getSupPhone() {
		return supPhone;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public String getSupFax() {
		return supFax;
	}

	public void setSupFax(String supFax) {
		this.supFax = supFax;
	}

	public String getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	public Timestamp getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Timestamp creatTime) {
		this.creatTime = creatTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
