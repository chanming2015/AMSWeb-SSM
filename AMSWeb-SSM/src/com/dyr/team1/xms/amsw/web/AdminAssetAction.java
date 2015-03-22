/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.web;

import com.dyr.team1.xms.amsw.entity.Asset;

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
public class AdminAssetAction extends BaseAction{
	
	private Asset a;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Asset getA() {
		return a;
	}

	public void setA(Asset a) {
		this.a = a;
	}

	public String toAddAsset(){
		
		putAllCateIntoReq();
		//得到最大资产编号
		int maxNo=operatorService.getMaxAssetNo()+1;
		requset.put("maxNo", maxNo);
		return "toAddAsset_success";
	}
	
	public void validateDoAddAsset() {
		
		if("".equals(a.getName().trim())) {
			addFieldError("AssetName", "*请输入资产名称！");
			return;
		}
	}

	public String doAddAsset(){
		
		int rows = operatorService.addAsset(a.getId(),a.getName(),name,a.getPrice());
		if(rows==1){
			return "doAddAsset_success";
		}else {
			return ERROR;
		}
	}
	
	public String doRemoveAsset(){
		
		int rows = operatorService.removeAsset(id);
		if(rows==1){
			return "doRemoveAsset_success";
		}else {
			return ERROR;
		}
	}
	
	public String toGetAsset(){
		
		putAllAssetIntoReq();
		return "toGetAsset_success";
	}
	
	public String toModifyAsset(){
		Asset asset=operatorService.getAllById(id);
		requset.put("asset", asset);
		putAllCateIntoReq();
		return "toModifyAsset_success";
	}

	public void validateDoModifyAsset() {
		
		if("".equals(a.getName().trim())) {
			addFieldError("AssetName", "*请输入资产名称！");
			return;
		}
		
		if("".equals(a.getStatue().trim())) {
			addFieldError("statue", "*请输入资产状态！");
			return;
		}
		
		if("".equals(a.getRemark().trim())) {
			addFieldError("AssetRemark", "*请输入资产备注！");
			return;
		}
	}
	
	public String doModifyAsset(){
		
		int rows = operatorService.modifyAsset(a.getId(),a.getName(),name,a.getPrice(),a.getStatue(),a.getRemark());
		if(rows==1){
			return "doModifyAsset_success";
		}else {
			return ERROR;
		}
	}
}
