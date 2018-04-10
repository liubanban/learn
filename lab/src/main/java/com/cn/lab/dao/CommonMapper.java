package com.cn.lab.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface CommonMapper { 
	Map<String, Object> getVByK(@Param("tname")String tname,
			@Param("bykeyname")String bykeyname,
			@Param("bykeyvalue")String bykeyvalue,
			@Param("keyout")String keyout );
	
}