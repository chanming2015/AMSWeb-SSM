/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.web;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dyr.team1.xms.amsw.entity.Asset;
import com.dyr.team1.xms.amsw.entity.Category;
import com.dyr.team1.xms.amsw.entity.Employee;
import com.dyr.team1.xms.amsw.entity.Operator;
import com.dyr.team1.xms.amsw.service.OperatorService;
import com.opensymphony.xwork2.ActionSupport;

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
public class BaseAction extends ActionSupport implements RequestAware,SessionAware{
	
	protected Map<String, Object> session;
	protected Map<String, Object> requset;
	protected String name;
	protected OperatorService operatorService;
	
	public OperatorService getOperatorService() {
		return operatorService;
	}
	
	public void setOperatorService(OperatorService operatorService) {
		this.operatorService = operatorService;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> req) {
		this.requset=req;
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午9:06:16
	 * Description 得到所有资产类别
	 */
	protected void putAllCateIntoReq(){
		//得到所有资产类别
		List<Category> categoryList = operatorService.getAllCate();
		requset.put("categoryList", categoryList);
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午3:02:32
	 * Description 得到所有资产
	 */
	protected void putAllAssetIntoReq() {
		
		//得到所有资产
		List<Asset> assetList=operatorService.getAllAsset();
		requset.put("assetList", assetList);
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:19:31
	 * Description 得到所有职员
	 */
	protected void putAllEmpIntoReq() {
		
		//得到所有资产
		List<Employee> employeeList=operatorService.getAllEmp();
		requset.put("employeeList", employeeList);
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午3:16:16
	 * Description
	 */
	protected void putAllOpIntoReq() {
		
		//得到所有操作员
		List<Operator> operatorList=operatorService.getAllOp();
		requset.put("operatorList", operatorList);
	}
	
	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午5:40:56
	 * Description 将所有角色放入request
	 */
	protected void putAllRoleIntoReq() {
		
		//得到所有角色
		List<String> roleList=operatorService.getAllRole();
		requset.put("roleList", roleList);
	}
}
