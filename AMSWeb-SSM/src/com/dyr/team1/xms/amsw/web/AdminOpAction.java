/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.web;

import java.util.List;
import com.dyr.team1.xms.amsw.entity.Operator;
import com.dyr.team1.xms.amsw.entity.RoleMenu;

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
public class AdminOpAction extends BaseAction{
	
	private String username;
	private String password;
	private String oldPass;
	private String newPass1;
	private String newPass2;
	private Operator op;
	private int assetId;
	private int empId;
	private String remark;
	
	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Operator getOp() {
		return op;
	}

	public void setOp(Operator op) {
		this.op = op;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}
	
	public String getNewPass1() {
		return newPass1;
	}
	
	public void setNewPass1(String newPass1) {
		this.newPass1 = newPass1;
	}
	
	public String getNewPass2() {
		return newPass2;
	}
	
	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void validateDoLogin() {
		
		if("".equals(username.trim())) {
			addFieldError("username", "*请输入用户名！");
			return;
		}
		
		if("".equals(password.trim())) {
			addFieldError("password", "*请输入密码！");
			return;
		}
	}

	public String doLogin(){
		
		op = operatorService.getOpByNameAndPass(username,password);
		if(op!=null){
			//登录成功,将操作员放入session
			session.put("admin", op);
			//取得权限，放入session
			List<RoleMenu> roleMenuList= operatorService.getRoleMenuListByRoleName(op.getRole());
			session.put("roleMenuList", roleMenuList);
			return "doLogin_success";
		}else {
			return LOGIN;
		}
	}
	
	public String toLogin(){
		return LOGIN;
	}
	
	public String toModifyPass(){
		
		return "toModifyPass_success";
	}
	
	public void validateDoModifyPass() {
		
		if("".equals(oldPass.trim())) {
			addFieldError("oldPass", "*请输入原密码！");
			return;
		}
		
		if("".equals(newPass1.trim())) {
			addFieldError("newPass1", "*请输入新密码！");
			return;
		}
	}

	public String doModifyPass(){
		
		int rows=0;
		op=(Operator) session.get("admin");
		if(op.getPassword().equals(oldPass)){
			rows=operatorService.modifyPass(op.getUserName(),newPass1);
		}
		if(rows == 1){
			return "doModifyPass_success";
		}else {
			return ERROR;
		}
	}
	
	public String logout(){
		
		session.remove("admin");
		return LOGIN;
	}
	
	public String exit(){
		
		session.remove("admin");
		return LOGIN;
	}
	
	public String toGetOp(){
		
		putAllOpIntoReq();
		return "toGetOp_success";
	}
	
	public String toAddOp(){
		
		putAllRoleIntoReq();
		return "toAddOp_success";
	}
	
	public void validateDoAddOp() {
		
		if("".equals(op.getUserName().trim())) {
			addFieldError("username", "*请输入用户名！");
			return;
		}
		
		if("".equals(op.getPassword().trim())) {
			addFieldError("password", "*请输入密码！");
			return;
		}
	}

	public String doAddOp(){
		
		int rows = operatorService.addOp(op);
		if(rows==1){
			return "doAddOp_success";
		}else {
			return ERROR;
		}
	}
	
	public String toLendAsset(){
		
		//获得资产和员工集合
		putAllAssetIntoReq();
		putAllEmpIntoReq();
		return "toLendAsset_success";
	}
	
	public void validateDoLendAsset() {
		
		if("".equals(remark.trim())) {
			addFieldError("remark", "*请输入备注！");
			return;
		}
		
	}

	public String doLendAsset(){
		op=(Operator) session.get("admin");
		int rows = operatorService.addLendInfo(assetId,empId,remark,op.getUserName());
		if(rows==1){
			return "doLendAsset_success";
		}else {
			return ERROR;
		}
	}
	
	public String toBackAsset(){
		
		putAllAssetIntoReq();
		return "toBackAsset_success";
	}
	
	public void validateDoBackAsset() {
		
		if("".equals(remark.trim())) {
			addFieldError("remark", "*请输入备注！");
			return;
		}
		
	}
	
	public String doBackAsset(){
		
		int rows = operatorService.addBackInfo(assetId,remark);
		if(rows==1){
			return "doBackAsset_success";
		}else {
			return ERROR;
		}
	}
	
	public String toDataCount(){
		putAllAssetIntoReq();
		return "toDataCount_success";
	}
	
	public String toHelp(){
		return "toHelp_success";
	}
}
