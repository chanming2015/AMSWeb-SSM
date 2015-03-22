/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.entity;

/**
 * Project:AMSWeb
 * Package:com.dyr.team1.xms.amsw.entity
 * FileName:RoleMenu.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-24 下午7:55:09
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public class RoleMenu {
	
	/**
	 * 角色-权限映射编号
	 */
	private int id;
	/**
	 * 角色名称
	 */
	private String role;
	/**
	 * 权限对象
	 */
	private Menu menu;
	/**
	 * Author XuMaoSen
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Author XuMaoSen
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Author XuMaoSen
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Author XuMaoSen
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * Author XuMaoSen
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}
	/**
	 * Author XuMaoSen
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
