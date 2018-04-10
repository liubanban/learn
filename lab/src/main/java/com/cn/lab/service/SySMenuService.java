package com.cn.lab.service;

import java.util.List;

import com.cn.lab.model.SysMenu;
import com.cn.sys.tree.TreeNode;

public interface SySMenuService {
	List<SysMenu> selectAllByQuery(SysMenu query);

	int deleteByPrimaryKey(Integer id);

	int insert(SysMenu record);

	int insertSelective(SysMenu record);

	SysMenu selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysMenu record);

	int updateByPrimaryKey(SysMenu record);
	
	TreeNode reListMenus(List<SysMenu> mlist );

}
