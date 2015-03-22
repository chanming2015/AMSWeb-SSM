/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.web;

import java.io.UnsupportedEncodingException;

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
public class AdminCateAction extends BaseAction{
	
	private String smallCate;
	private String bigCateSelect;
	private String bigCate;
	private String oldName;
	private String newName;
	
	public String getOldName() {
		return oldName;
	}
	
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return newName;
	}
	
	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	public String getSmallCate() {
		return smallCate;
	}
	
	public void setSmallCate(String smallCate) {
		this.smallCate = smallCate;
	}
	
	public String getBigCateSelect() {
		return bigCateSelect;
	}
	
	public void setBigCateSelect(String bigCateSelect) {
		this.bigCateSelect = bigCateSelect;
	}
	
	public String getBigCate() {
		return bigCate;
	}
	
	public void setBigCate(String bigCate) {
		this.bigCate = bigCate;
	}
	
	public String toAddCate(){
		putAllCateIntoReq();
		return "toAddCate_success";
	}
	
	public String doAddCate(){
		
		if(bigCate!=null){
			//添加大类
			int rows = operatorService.addBigCate(bigCate);
			if(rows==1){
				return "doAddCate_success";
			}else {
				return ERROR;
			}
		}else{
			//添加小类
			int rows = operatorService.addSmallCate(smallCate,bigCateSelect);
			if(rows==1){
				return "doAddCate_success";
			}else {
				return ERROR;
			}
		}
	}
	
	public void validateDoRemoveCate() {
		
		if("".equals(name.trim())) {
			addFieldError("name", "*请输入类名！");
			return;
		}
	}

	public String doRemoveCate(){
		
		/*//根据类别名称查询该类别下的资产
		List<Asset> assetList=operatorService.getAssetsByCateName(name);
		if(assetList!=null){
			
		}*/
		int rows = operatorService.removeCate(name);
		if(rows==1){
			return "doRemoveCate_success";
		}else {
			return ERROR;
		}
	}

	public String toGetCate(){
		
		putAllCateIntoReq();
		return "toGetCate_success";
	}
	
	public void validateDoModifyCate() {
		
		if("".equals(oldName.trim())) {
			addFieldError("oldName", "*请输入类名！");
			return;
		}
		
		if("".equals(newName.trim())) {
			addFieldError("newName", "*请输入类名！");
			return;
		}
	}
	
	public String doModifyCate(){
		
		int rows = operatorService.modifyCate(oldName,newName);
		if(rows==1){
			return "doModifyCate_success";
		}else {
			return ERROR;
		}
	}
	
	public String toModifyCate() throws UnsupportedEncodingException{
		
		name=new String(name.getBytes("ISO-8859-1"), "UTF-8");
		requset.put("name", name);
		return "toModifyCate_success";
	}
}
