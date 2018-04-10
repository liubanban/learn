package com.cn.lab.dao;

import java.util.List;

import com.cn.lab.model.SysUser;

public interface SysUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Integer id);

	List<SysUser> selectAllByQuery(SysUser query);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);
}