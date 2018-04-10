package com.cn.lab.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.lab.dao.SysRoleMapper;
import com.cn.lab.model.SysRole;
import com.cn.lab.service.SySRoleService;

@Service("sySRoleService")
public class SySRoleServiceImpl implements SySRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysRole record) {
		return sysRoleMapper.insert(record);
	}

	@Override

	public int insertSelective(SysRole record) {
		return sysRoleMapper.insertSelective(record);
	}

	@Override
	public SysRole selectByPrimaryKey(Integer id) {
		return sysRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysRole record) {
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysRole record) {
		return sysRoleMapper.updateByPrimaryKey(record);
	}
	/**
	 * 根据查询条件,查询
	 */
	@Override
	public List<SysRole> selectAllByQuery(SysRole query) {
		Map<String, String> map = new HashMap<String, String>();
		if(StringUtils.isNotBlank(query.getRolecode())){
			map.put("usercode", query.getRolecode());
		}
		if(StringUtils.isNotBlank(query.getRolename())){
			map.put("username", query.getRolename());
		}
		return sysRoleMapper.selectAllByQuery(query);
	}

}
