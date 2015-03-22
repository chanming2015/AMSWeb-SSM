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
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dyr.team1.xms.amsw.entity.Asset;

/**
 * Project:AssetManagementSystemWeb
 * Package:com.dyr.team1.xms.amsw.dao
 * FileName:AssetDAO.java
 * Comments:
 * JDK Version:
 * Author XuMaoSen
 * Create Date:2015-2-10 下午6:07:50
 * Modified By:XuMaoSen
 * Modified Time:
 * What is Modified:
 * Description:
 * Version:
 */
public interface AssetDAO {

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午5:02:20
	 * Description
	 * @param name
	 * @return
	 */
	@Select("select * from AssetTable where asset_cate=#{name} ")
	@Results({
		@Result(id=true,column="asset_id",property="id"),
		@Result(column="asset_name",property="name"),
		@Result(column="asset_cate",property="cate",one=@One(select="com.dyr.team1.xms.amsw.dao.CategoryDAO.selectCateByName")),
		@Result(column="asset_price",property="price"),
		@Result(column="asset_buytime",property="buyTime"),
		@Result(column="asset_statue",property="statue"),
		@Result(column="asset_remark",property="remark")
	})
	List<Asset> selectAssetsByCateName(String name);
	
	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午3:03:05
	 * Description
	 * @return
	 */
	@Select("select * from AssetTable ")
	@Results({
		@Result(id=true,column="asset_id",property="id"),
		@Result(column="asset_name",property="name"),
		@Result(column="asset_cate",property="cate",one=@One(select="com.dyr.team1.xms.amsw.dao.CategoryDAO.selectCateByName")),
		@Result(column="asset_price",property="price"),
		@Result(column="asset_buytime",property="buyTime"),
		@Result(column="asset_statue",property="statue"),
		@Result(column="asset_remark",property="remark")
	})
	List<Asset> selectAllAsset();
	
	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午6:58:25
	 * Description
	 * @param id
	 * @return
	 */
	@Select("select * from AssetTable where asset_id=#{id} ")
	@Results({
		@Result(id=true,column="asset_id",property="id"),
		@Result(column="asset_name",property="name"),
		@Result(column="asset_cate",property="cate",one=@One(select="com.dyr.team1.xms.amsw.dao.CategoryDAO.selectCateByName")),
		@Result(column="asset_price",property="price"),
		@Result(column="asset_buytime",property="buyTime"),
		@Result(column="asset_statue",property="statue"),
		@Result(column="asset_remark",property="remark")
	})
	Asset selectAssetsById(int id);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午9:08:23
	 * Description 得到最大资产编号
	 * @return
	 */
	@Select("select MAX(asset_id) from AssetTable")
	int selectMaxAssetNo();

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-24 下午9:47:55
	 * Description
	 * @param id
	 * @param name
	 * @param cate
	 * @param price
	 * @return
	 */
	@Insert("insert into AssetTable values(#{id},#{name},#{cate},#{price},default,'可借出',default)")
	int insertAsset(@Param("id")int id, @Param("name")String name, @Param("cate")String cate, @Param("price")double price);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午6:49:44
	 * Description
	 * @param id
	 * @return
	 */
	@Delete("delete from AssetTable where asset_id=#{id} ")
	int deleteAsset(int id);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-25 下午7:50:56
	 * Description
	 * @param id
	 * @param name
	 * @param cateName
	 * @param price
	 * @param statue
	 * @param remark
	 * @return
	 */
	@Update("update AssetTable set asset_name=#{name},asset_cate=#{cateName},asset_price=#{price},asset_statue=#{statue},asset_remark=#{remark} where asset_id=#{id} ")
	int updateAsset(@Param("id")int id, @Param("name")String name, @Param("cateName")String cateName, @Param("price")double price, @Param("statue")String statue, @Param("remark")String remark);

	/**
	 * @author XuMaoSen
	 * Create Time:2015-2-26 下午9:15:14
	 * Description
	 * @param assetId 
	 * @param string
	 * @return
	 */
	@Update("update AssetTable set asset_statue=#{statue} where asset_id=#{id}")
	int updateAssetStatue(@Param("id")int id, @Param("statue")String statue);

}
