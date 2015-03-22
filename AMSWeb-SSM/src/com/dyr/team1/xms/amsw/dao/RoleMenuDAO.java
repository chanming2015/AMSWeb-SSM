/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.dao;

import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.dyr.team1.xms.amsw.entity.RoleMenu;

/**
 * Project:AssetManagementSystemWeb
 * Package:com.dyr.team1.xms.amsw.dao
 * FileName:RoleMenuDAO.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-10 下午6:09:42
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface RoleMenuDAO {

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-12 下午6:30:12
	 * Description
	 * @param name
	 * @return
	 */
	@Select("select * from RoleMenuTable where roleMenu_role=#{name} ")
	@Results({
		@Result(id=true,column="roleMenu_id",property="id"),
		@Result(column="roleMenu_role",property="role"),
		@Result(column="roleMenu_menu",property="menu",one=@One(select="com.dyr.team1.xms.amsw.dao.MenuDAO.selectMenuByMenuName"))
	})
	List<RoleMenu> selectRoleMenuListByRoleName(String name);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午5:42:22
	 * Description
	 * @return
	 */
	@Select("select *from RoleTable")
	List<String> selectAllRole();

}
