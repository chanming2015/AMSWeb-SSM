/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import com.dyr.team1.xms.amsw.entity.Menu;

/**
 * Project:AssetManagementSystemWeb
 * Package:com.dyr.team1.xms.amsw.dao
 * FileName:MenuDAO.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-10 下午6:08:50
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface MenuDAO {

	/**
	 * 
	 * @author XuMaoSen
	 * Create Time:2015-2-12 下午6:52:55
	 * Description
	 * @param name
	 * @return
	 */
	@Select("select * from MenuTable where menu_name=#{name} ")
	@Results({
		@Result(id=true,column="menu_name",property="name"),
		@Result(column="menu_supper",property="supper"),
		@Result(column="menu_url",property="url")
	})
	Menu selectMenuByMenuName(String name);
}
