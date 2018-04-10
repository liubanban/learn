package com.cn.lab.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.lab.dao.SysUserMapper;
import com.cn.lab.model.SysUser;
import com.cn.lab.service.SySUserService;

@Service("sySUserService")
public class SySUserServiceImpl implements SySUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUser record) {
		return sysUserMapper.insert(record);
	}

	@Override

	public int insertSelective(SysUser record) {
		return sysUserMapper.insertSelective(record);
	}

	@Override
	public SysUser selectByPrimaryKey(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser record) {
		return sysUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {
		return sysUserMapper.updateByPrimaryKey(record);
	}
	/**
	 * 根据查询条件,查询
	 */
	@Override
	public List<SysUser> selectAllByQuery(SysUser query) {
		Map<String, String> map = new HashMap<String, String>();
		if(StringUtils.isNotBlank(query.getUsercode())){
			map.put("usercode", query.getUsercode());
		}
		if(StringUtils.isNotBlank(query.getUsername())){
			map.put("username", query.getUsername());
		}
		if(StringUtils.isNotBlank(query.getSex())){
			map.put("sex", query.getSex());
		}
		if(StringUtils.isNotBlank(query.getPhone())){
			map.put("phone", query.getPhone());
		}
		return sysUserMapper.selectAllByQuery(query);
	}

}
