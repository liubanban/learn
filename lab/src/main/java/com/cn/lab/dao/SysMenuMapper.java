package com.cn.lab.dao;

import java.util.List;

import com.cn.lab.model.SysMenu;

public interface SysMenuMapper {
	List<SysMenu> selectAllByQuery(SysMenu query);

	int deleteByPrimaryKey(Integer id);

	int insert(SysMenu record);

	int insertSelective(SysMenu record);

	SysMenu selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysMenu record);

	int updateByPrimaryKey(SysMenu record);
}