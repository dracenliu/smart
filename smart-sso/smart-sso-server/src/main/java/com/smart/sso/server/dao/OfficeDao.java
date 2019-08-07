package com.smart.sso.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.smart.mvc.dao.mybatis.Dao;
import com.smart.sso.server.model.Office;

@Mapper
public interface OfficeDao extends Dao<Office, Integer> {

	public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

	public List<Office> findByParams(@Param("isEnable") Boolean isEnable, @Param("isParent") Boolean isParent,
			@Param("currentId") Integer currentId);
}
