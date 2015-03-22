/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dyr.team1.xms.amsw.entity.Operator;

/**
 * Project:AssetManagementSystemWeb
 * Package:com.dyr.team1.xms.amsw.dao
 * FileName:OperatorDAO.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-10 下午6:09:10
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface OperatorDAO {

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-11 下午3:41:55
	 * Description
	 * @param name
	 * @param password
	 * @return
	 */
	@Select("select * from OperatorTable where operator_username=#{name} and operator_password=#{password} ")
	@Results({
		@Result(id=true,column="operator_username",property="userName"),
		@Result(column="operator_password",property="password"),
		@Result(column="operator_used",property="used"),
		@Result(column="operator_role",property="role")
	})
	Operator selectOpByNameAndPass(@Param("name")String name, @Param("password")String password);
	
	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午3:18:34
	 * Description
	 * @return
	 */
	@Select("select * from OperatorTable ")
	@Results({
		@Result(id=true,column="operator_username",property="userName"),
		@Result(column="operator_password",property="password"),
		@Result(column="operator_used",property="used"),
		@Result(column="operator_role",property="role")
	})
	List<Operator> selectAllOp();

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午2:50:57
	 * Description
	 * @param newPass
	 * @param newPass2 
	 * @return
	 */
	@Update("update OperatorTable set operator_password=#{newPass} where operator_username=#{name} ")
	int updatePass(@Param("name")String name, @Param("newPass")String newPass);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午5:50:39
	 * Description
	 * @param op
	 * @return
	 */
	@Insert("insert into OperatorTable values(#{userName},#{password},#{used},#{role} )")
	int insertOp(Operator op);

}
