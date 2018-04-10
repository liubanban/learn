package com.cn.lab.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.lab.dao.CommonMapper;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;
	/**
	 * 根据传入的参数动态生成简单的用一个字段和值换另一个字段的值
	 */
	@Override
	public Map<String, Object> getVByK(String tname, String bykeyname, String bykeyvalue, String keyout) {
		return commonMapper.getVByK(tname, bykeyname, bykeyvalue, keyout);
	
	}

}
