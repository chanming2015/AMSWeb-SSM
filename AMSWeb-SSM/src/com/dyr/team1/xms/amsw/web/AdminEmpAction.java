/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.web;

import com.dyr.team1.xms.amsw.entity.Employee;

/**
 * Project:AMSWeb
 * Package:com.dyr.team1.xms.amsw.web
 * FileName:IndexAction.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-11 下午6:11:54
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
@SuppressWarnings("serial")
public class AdminEmpAction extends BaseAction{
	
	private Employee e;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}

	public String toAddEmp(){
		//获得最大职员编号
		int maxNo=operatorService.getMaxEmpNo()+1;
		requset.put("maxNo", maxNo);
		return "toAddEmp_success";
	}

	public void validateDoAddEmp() {
		
		if("".equals(e.getName().trim())) {
			addFieldError("EmpName", "*请输入姓名！");
			return;
		}
		
		if("".equals(e.getPost().trim())) {
			addFieldError("Post", "*请输入职位！");
			return;
		}
		
		if("".equals(e.getRemark().trim())) {
			addFieldError("EmpRemark", "*请输入备注！");
			return;
		}
		
	}

	public String doAddEmp(){
		
		int rows = operatorService.addEmp(e);
		if(rows==1){
			return "doAddEmp_success";
		}else {
			return ERROR;
		}
	}
	
	public String doRemoveEmp(){
		
		int rows = operatorService.removeEmp(id);
		if(rows==1){
			return "doRemoveEmp_success";
		}else {
			return ERROR;
		}
	}

	public String toGetEmp(){
		
		putAllEmpIntoReq();
		return "toGetEmp_success";
	}
	
	public String toModifyEmp(){
		
		Employee emp=operatorService.getEmpById(id);
		requset.put("emp", emp);
		return "toModifyEmp_success";
	}
	
	public void validateDoModifyEmp() {
		
		if("".equals(e.getName().trim())) {
			addFieldError("EmpName", "*请输入姓名！");
			return;
		}
		
		if("".equals(e.getPost().trim())) {
			addFieldError("Post", "*请输入职位！");
			return;
		}
		
		if("".equals(e.getRemark().trim())) {
			addFieldError("EmpRemark", "*请输入备注！");
			return;
		}
		
	}

	public String doModifyEmp(){
		
		int rows = operatorService.modifyEmp(e);
		if(rows==1){
			return "doModifyEmp_success";
		}else {
			return ERROR;
		}
	}
	
}
