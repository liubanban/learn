package com.cn.lab.service;

import java.util.List;

import com.cn.lab.model.SysRole;

public interface SySRoleService {
	List<SysRole> selectAllByQuery(SysRole query);

	int deleteByPrimaryKey(Integer id);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	SysRole selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);

}
