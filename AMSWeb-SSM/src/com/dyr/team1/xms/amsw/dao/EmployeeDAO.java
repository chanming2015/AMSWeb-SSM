/*
 *www.dyr.com
 *Copyright (c) 2014 All Rights Reserved
 */
/**
 * Author XuMaoSen
 */
package com.dyr.team1.xms.amsw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dyr.team1.xms.amsw.entity.Employee;

/**
 * Project:AssetManagementSystemWeb
 * Package:com.dyr.team1.xms.amsw.dao
 * FileName:EmployeeDAO.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-10 下午6:08:32
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface EmployeeDAO {

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:21:08
	 * Description
	 * @return
	 */
	@Select("select * from EmployeeTable")
	@Results({
		@Result(id=true,column="employee_id",property="id"),
		@Result(column="employee_name",property="name"),
		@Result(column="employee_post",property="post"),
		@Result(column="employee_remark",property="remark")
	})
	List<Employee> selectAllEmp();
	
	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午10:16:05
	 * Description
	 * @param id
	 * @return
	 */
	@Select("select * from EmployeeTable where employee_id=#{id} ")
	@Results({
		@Result(id=true,column="employee_id",property="id"),
		@Result(column="employee_name",property="name"),
		@Result(column="employee_post",property="post"),
		@Result(column="employee_remark",property="remark")
	})
	Employee selectEmpBy(int id);
	
	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:02:31
	 * Description
	 * @return
	 */
	@Select("select MAX(employee_id) from EmployeeTable")
	int selectMaxEmpNo();

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:15:55
	 * Description
	 * @param e
	 * @return
	 */
	@Insert("insert into EmployeeTable values(#{id},#{name},#{post},#{remark}) ")
	int insertEmp(Employee e);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午9:38:16
	 * Description
	 * @param id
	 * @return
	 */
	@Delete("delete from EmployeeTable where employee_id=#{id} ")
	int deleteEmp(int id);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午10:20:50
	 * Description
	 * @param e
	 * @return
	 */
	@Update("update EmployeeTable set employee_name=#{name},employee_post=#{post},employee_remark=#{remark} where employee_id=#{id} ")
	int updateEmp(Employee e);

}
