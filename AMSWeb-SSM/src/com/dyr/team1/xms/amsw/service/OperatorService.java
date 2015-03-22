/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.service;

import java.util.List;

import com.dyr.team1.xms.amsw.dao.AssetDAO;
import com.dyr.team1.xms.amsw.dao.BackDAO;
import com.dyr.team1.xms.amsw.dao.CategoryDAO;
import com.dyr.team1.xms.amsw.dao.EmployeeDAO;
import com.dyr.team1.xms.amsw.dao.LendDAO;
import com.dyr.team1.xms.amsw.dao.OperatorDAO;
import com.dyr.team1.xms.amsw.dao.RoleMenuDAO;
import com.dyr.team1.xms.amsw.entity.Asset;
import com.dyr.team1.xms.amsw.entity.Category;
import com.dyr.team1.xms.amsw.entity.Employee;
import com.dyr.team1.xms.amsw.entity.Operator;
import com.dyr.team1.xms.amsw.entity.RoleMenu;

/**
 * Project:AMSWeb
 * Package:com.dyr.team1.xms.amsw.service
 * FileName:OperatorService.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-11 下午6:10:03
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class OperatorService {

	private OperatorDAO operatorDAO;
	private RoleMenuDAO roleMenuDAO;
	private CategoryDAO categoryDAO;
	private AssetDAO assetDAO;
	private EmployeeDAO employeeDAO;
	private LendDAO lendDAO;
	private BackDAO backDAO;

	public BackDAO getBackDAO() {
		return backDAO;
	}

	public void setBackDAO(BackDAO backDAO) {
		this.backDAO = backDAO;
	}

	public LendDAO getLendDAO() {
		return lendDAO;
	}

	public void setLendDAO(LendDAO lendDAO) {
		this.lendDAO = lendDAO;
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public AssetDAO getAssetDAO() {
		return assetDAO;
	}

	public void setAssetDAO(AssetDAO assetDAO) {
		this.assetDAO = assetDAO;
	}

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public RoleMenuDAO getRoleMenuDAO() {
		return roleMenuDAO;
	}

	public void setRoleMenuDAO(RoleMenuDAO roleMenuDAO) {
		this.roleMenuDAO = roleMenuDAO;
	}

	public OperatorDAO getOperatorDAO() {
		return operatorDAO;
	}

	public void setOperatorDAO(OperatorDAO operatorDAO) {
		this.operatorDAO = operatorDAO;
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-11 下午6:21:32
	 * Description
	 * @param username
	 * @param password
	 * @return
	 */
	public Operator getOpByNameAndPass(String username, String password) {
		return operatorDAO.selectOpByNameAndPass(username, password);
		
	}
	
	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午3:17:38
	 * Description
	 * @return
	 */
	public List<Operator> getAllOp() {
		return operatorDAO.selectAllOp();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-12 下午6:24:36
	 * Description
	 * @param string
	 * @return
	 */
	public List<RoleMenu> getRoleMenuListByRoleName(String name) {
		return roleMenuDAO.selectRoleMenuListByRoleName(name);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-13 下午5:23:07
	 * Description
	 * @return
	 */
	public List<Category> getAllCate() {
		return categoryDAO.selectAllCate();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:05:47
	 * Description 添加大类
	 * @param bigCate
	 * @return
	 */
	public int addBigCate(String bigCate) {
		return categoryDAO.insertBigCate(bigCate);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:16:56
	 * Description 添加小类
	 * @param smallCate
	 * @param bigCateSelect
	 * @return
	 */
	public int addSmallCate(String smallCate, String bigCateSelect) {
		return categoryDAO.addSmallCate(smallCate,bigCateSelect);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:32:49
	 * Description 删除类别
	 * @param name
	 * @return
	 */
	public int removeCate(String name) {
		return categoryDAO.deleteCate(name);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-23 下午5:47:36
	 * Description 修改类别
	 * @param oldName
	 * @param newName
	 * @return
	 */
	public int modifyCate(String oldName, String newName) {
		return categoryDAO.updateCate(oldName,newName);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午5:00:18
	 * Description
	 * @param name
	 * @return
	 */
	public List<Asset> getAssetsByCateName(String name) {
		return assetDAO.selectAssetsByCateName(name);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午9:07:47
	 * Description 得到最大资产编号
	 * @return
	 */
	public int getMaxAssetNo() {
		return assetDAO.selectMaxAssetNo();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午9:47:13
	 * Description
	 * @param id
	 * @param name
	 * @param cate
	 * @param price
	 * @return
	 */
	public int addAsset(int id, String name, String cate, double price) {
		return assetDAO.insertAsset(id,name,cate,price);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午3:02:17
	 * Description 得到所有资产
	 * @return
	 */
	public List<Asset> getAllAsset() {
		return assetDAO.selectAllAsset();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午6:49:16
	 * Description
	 * @param id
	 * @return
	 */
	public int removeAsset(int id) {
		return assetDAO.deleteAsset(id);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午6:57:54
	 * Description
	 * @param id
	 * @return
	 */
	public Asset getAllById(int id) {
		return assetDAO.selectAssetsById(id);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午7:49:48
	 * Description
	 * @param id
	 * @param name
	 * @param name2
	 * @param price
	 * @param statue
	 * @param remark
	 * @return
	 */
	public int modifyAsset(int id, String name, String cateName, double price,	String statue, String remark) {
		return assetDAO.updateAsset(id,name,cateName,price,statue,remark);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午8:59:27
	 * Description
	 * @return
	 */
	public int getMaxEmpNo() {
		return employeeDAO.selectMaxEmpNo();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:15:27
	 * Description
	 * @param e
	 * @return
	 */
	public int addEmp(Employee e) {
		return employeeDAO.insertEmp(e);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:20:42
	 * Description
	 * @return
	 */
	public List<Employee> getAllEmp() {
		return employeeDAO.selectAllEmp();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:37:56
	 * Description
	 * @param id
	 * @return
	 */
	public int removeEmp(int id) {
		return employeeDAO.deleteEmp(id);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午10:15:26
	 * Description
	 * @param id
	 * @return
	 */
	public Employee getEmpById(int id) {
		return employeeDAO.selectEmpBy(id);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午10:20:28
	 * Description
	 * @param e
	 * @return
	 */
	public int modifyEmp(Employee e) {
		return employeeDAO.updateEmp(e);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午2:40:11
	 * Description
	 * @param newPass1 
	 * @param oldPass
	 * @return
	 */
	public int modifyPass(String name, String newPass) {
		return operatorDAO.updatePass(name,newPass);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午5:39:10
	 * Description
	 * @return
	 */
	public List<String> getAllRole() {
		return roleMenuDAO.selectAllRole();
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午5:50:14
	 * Description
	 * @param op
	 * @return
	 */
	public int addOp(Operator op) {
		return operatorDAO.insertOp(op);
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午9:03:38
	 * Description 借出资产
	 * @param assetId
	 * @param empId
	 * @param remark
	 * @param string 
	 * @return
	 */
	public int addLendInfo(int assetId, int empId, String remark, String name) {
		
		if(lendDAO.insertLendInfo(assetId,empId,remark,name)==1){
			if(assetDAO.updateAssetStatue(assetId,"待归还")==1){
				return 1;
			}
		}
		return 0;
	}

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午9:36:27
	 * Description 归还资产
	 * @param assetId
	 * @param remark
	 * @return
	 */
	public int addBackInfo(int assetId, String remark) {
		
		if(backDAO.insertBackInfo(assetId,remark)==1){
			if(assetDAO.updateAssetStatue(assetId,"可借出")==1){
				return 1;
			}
		}
		return 0;
	}

}
